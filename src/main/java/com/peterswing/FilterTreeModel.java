package com.peterswing;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;

public class FilterTreeModel extends DefaultTreeModel {
	public String filter;
	public int filterLevel = -1;
	private TreeModel delegate;
	public boolean exactMatch;

	public FilterTreeModel(TreeModel delegate) {
		super((TreeNode) delegate.getRoot());
		this.delegate = delegate;
	}

	public FilterTreeModel(TreeModel delegate, int filterLevel) {
		this(delegate);
		this.filterLevel = filterLevel;
	}

	public void reload() {
		Object root = getRoot();
		walk(root, 0);
		nodeStructureChanged((TreeNode) root);
	}

	void walk(Object o, int level) {
		int cc;
		cc = delegate.getChildCount(o);
		for (int i = 0; i < cc; i++) {
			Object child = delegate.getChild(o, i);
			if (child instanceof FilterTreeNode && filter != null) {
				FilterTreeNode fn = (FilterTreeNode) child;
				if (exactMatch && child.toString().toLowerCase().equals(filter)) {
					setAllParentVisible(fn, true);
				}
				if (!exactMatch && child.toString().toLowerCase().contains(filter)) {
					setAllParentVisible(fn, true);
				} else {
					fn.isShown = false;
				}
			}
			if (!isLeaf(child) && level < filterLevel - 1) {
				walk(child, level + 1);
			}
		}
	}

	void setAllParentVisible(FilterTreeNode node, boolean b) {
		node.isShown = b;
		TreeNode parent = node.getParent();
		if (parent != null && parent instanceof FilterTreeNode) {
			setAllParentVisible((FilterTreeNode) parent, b);
		}
	}

	public Object getChild(Object parent, int index) {
		int count = 0;
		for (int i = 0; i < delegate.getChildCount(parent); i++) {
			final Object child = delegate.getChild(parent, i);
			if (child instanceof FilterTreeNode) {
				if (((FilterTreeNode) child).isShown) {
					if (count == index) {
						return child;
					}
					count++;
				}
			} else if (count == index) {
				return child;
			} else {
				count++;
			}
		}
		return null;
	}

	//	public int getIndexOfChild(Object parent, Object child) {
	//		return delegate.getIndexOfChild(parent, child);
	//	}

	public int getChildCount(Object parent) {
		int count = 0;
		for (int i = 0; i < delegate.getChildCount(parent); i++) {
			final Object child = delegate.getChild(parent, i);
			if (child instanceof FilterTreeNode) {
				if (((FilterTreeNode) child).isShown) {
					count++;
				}
			} else {
				count++;
			}
		}
		return count;
	}

	public boolean isLeaf(Object node) {
		if (node == null) {
			return true;
		} else {
			return delegate.isLeaf(node);
		}
	}
}
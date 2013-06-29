package com.peterswing.advancedswing.swappanel;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager2;
import java.util.Random;
import java.util.Vector;

public class SwapPanelLayout implements LayoutManager2, java.io.Serializable {
	int hgap;
	int vgap;
	//	Component north;
	//	Component west;
	//	Component east;
	//	Component south;
	//	Component center;

	Component firstLine;
	Component lastLine;
	Component firstItem;
	Component lastItem;
	public static final String NORTH = "North";
	public static final String SOUTH = "South";
	public static final String EAST = "East";
	public static final String WEST = "West";
	public static final String CENTER = "Center";
	public static final String BEFORE_FIRST_LINE = "First";
	public static final String AFTER_LAST_LINE = "Last";
	public static final String BEFORE_LINE_BEGINS = "Before";
	public static final String AFTER_LINE_ENDS = "After";
	public static final String PAGE_START = BEFORE_FIRST_LINE;
	public static final String PAGE_END = AFTER_LAST_LINE;
	public static final String LINE_START = BEFORE_LINE_BEGINS;
	public static final String LINE_END = AFTER_LINE_ENDS;
	private static final long serialVersionUID = -8658291919501921765L;
	private Vector<Component> components = new Vector<Component>();
	Random r=new Random();

	public SwapPanelLayout() {
		this(0, 0);
	}

	public SwapPanelLayout(int hgap, int vgap) {
		this.hgap = hgap;
		this.vgap = vgap;
	}

	public int getHgap() {
		return hgap;
	}

	public void setHgap(int hgap) {
		this.hgap = hgap;
	}

	public int getVgap() {
		return vgap;
	}

	public void setVgap(int vgap) {
		this.vgap = vgap;
	}

	public void addLayoutComponent(Component comp, Object constraints) {
		System.out.println("addLayoutComponent(Component comp, Object constraints)");
		System.out.println(constraints);
		synchronized (comp.getTreeLock()) {
			if ((constraints == null) || (constraints instanceof String)) {
				addLayoutComponent((String) constraints, comp);
			} else {
				throw new IllegalArgumentException("cannot add to layout: constraint must be a string (or null)");
			}
		}
	}

	@Override
	public void addLayoutComponent(String name, Component comp) {
		synchronized (comp.getTreeLock()) {
			components.add(comp);
		}
	}

	/*@Deprecated
	public void addLayoutComponent(String name, Component comp) {
		System.out.println("addLayoutComponent(String name, Component comp)");
		synchronized (comp.getTreeLock()) {
			// Special case:  treat null the same as "Center".
			if (name == null) {
				name = "Center";
			}

			// Assign the component to one of the known regions of the layout.
			if ("Center".equals(name)) {
				center = comp;
			} else if ("North".equals(name)) {
				north = comp;
			} else if ("South".equals(name)) {
				south = comp;
			} else if ("East".equals(name)) {
				east = comp;
			} else if ("West".equals(name)) {
				west = comp;
			} else if (BEFORE_FIRST_LINE.equals(name)) {
				firstLine = comp;
			} else if (AFTER_LAST_LINE.equals(name)) {
				lastLine = comp;
			} else if (BEFORE_LINE_BEGINS.equals(name)) {
				firstItem = comp;
			} else if (AFTER_LINE_ENDS.equals(name)) {
				lastItem = comp;
			} else {
				throw new IllegalArgumentException("cannot add to layout: unknown constraint: " + name);
			}
		}
	}*/

	public void removeLayoutComponent(Component comp) {
		synchronized (comp.getTreeLock()) {
			components.remove(comp);
		}
	}

	public Component getLayoutComponent(Object constraints) {
		throw new IllegalArgumentException("cannot get component: unknown constraint: " + constraints);
	}

	public Component getLayoutComponent(Container target, Object constraints) {
		throw new IllegalArgumentException("cannot get component: invalid constraint: " + constraints);
	}

	public Object getConstraints(Component comp) {
		return null;
	}

	public Dimension minimumLayoutSize(Container target) {
		synchronized (target.getTreeLock()) {
			Dimension dim = new Dimension(0, 0);

			//			boolean ltr = target.getComponentOrientation().isLeftToRight();
			//			Component c = null;

			for (Component c : components) {
				Dimension d = c.getMinimumSize();
				dim.width += d.width + hgap;
				dim.height = Math.max(d.height, dim.height);
			}
			//			if ((c = getChild(EAST, ltr)) != null) {
			//				Dimension d = c.getMinimumSize();
			//				dim.width += d.width + hgap;
			//				dim.height = Math.max(d.height, dim.height);
			//			}
			//			if ((c = getChild(WEST, ltr)) != null) {
			//				Dimension d = c.getMinimumSize();
			//				dim.width += d.width + hgap;
			//				dim.height = Math.max(d.height, dim.height);
			//			}
			//			if ((c = getChild(CENTER, ltr)) != null) {
			//				Dimension d = c.getMinimumSize();
			//				dim.width += d.width;
			//				dim.height = Math.max(d.height, dim.height);
			//			}
			//			if ((c = getChild(NORTH, ltr)) != null) {
			//				Dimension d = c.getMinimumSize();
			//				dim.width = Math.max(d.width, dim.width);
			//				dim.height += d.height + vgap;
			//			}
			//			if ((c = getChild(SOUTH, ltr)) != null) {
			//				Dimension d = c.getMinimumSize();
			//				dim.width = Math.max(d.width, dim.width);
			//				dim.height += d.height + vgap;
			//			}

			Insets insets = target.getInsets();
			dim.width += insets.left + insets.right;
			dim.height += insets.top + insets.bottom;

			return dim;
		}
	}

	public Dimension preferredLayoutSize(Container target) {
		synchronized (target.getTreeLock()) {
			Dimension dim = new Dimension(0, 0);

			//			boolean ltr = target.getComponentOrientation().isLeftToRight();
			//			Component c = null;

			for (Component c : components) {
				Dimension d = c.getPreferredSize();
				dim.width += d.width + hgap;
				dim.height = Math.max(d.height, dim.height);
			}

			//			if ((c = getChild(EAST, ltr)) != null) {
			//				Dimension d = c.getPreferredSize();
			//				dim.width += d.width + hgap;
			//				dim.height = Math.max(d.height, dim.height);
			//			}
			//			if ((c = getChild(WEST, ltr)) != null) {
			//				Dimension d = c.getPreferredSize();
			//				dim.width += d.width + hgap;
			//				dim.height = Math.max(d.height, dim.height);
			//			}
			//			if ((c = getChild(CENTER, ltr)) != null) {
			//				Dimension d = c.getPreferredSize();
			//				dim.width += d.width;
			//				dim.height = Math.max(d.height, dim.height);
			//			}
			//			if ((c = getChild(NORTH, ltr)) != null) {
			//				Dimension d = c.getPreferredSize();
			//				dim.width = Math.max(d.width, dim.width);
			//				dim.height += d.height + vgap;
			//			}
			//			if ((c = getChild(SOUTH, ltr)) != null) {
			//				Dimension d = c.getPreferredSize();
			//				dim.width = Math.max(d.width, dim.width);
			//				dim.height += d.height + vgap;
			//			}

			Insets insets = target.getInsets();
			dim.width += insets.left + insets.right;
			dim.height += insets.top + insets.bottom;

			return dim;
		}
	}

	public Dimension maximumLayoutSize(Container target) {
		return new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
	}

	public float getLayoutAlignmentX(Container parent) {
		return 0.5f;
	}

	public float getLayoutAlignmentY(Container parent) {
		return 0.5f;
	}

	public void invalidateLayout(Container target) {
	}

	public void layoutContainer(Container target) {
		System.out.println("layoutContainer()");
		synchronized (target.getTreeLock()) {
			Insets insets = target.getInsets();
			int top = insets.top;
			int bottom = target.getHeight() - insets.bottom;
			int left = insets.left;
			int right = target.getWidth() - insets.right;

			//			boolean ltr = target.getComponentOrientation().isLeftToRight();
			//			Component c = null;

			for (Component c : components) {
				c.setSize(right - left, c.getHeight());
				Dimension d = c.getPreferredSize();
				c.setBounds(r.nextInt(400), top, right - left, d.height);
				top += d.height + vgap;
			}
			//			if ((c = getChild(NORTH, ltr)) != null) {
			//				c.setSize(right - left, c.getHeight());
			//				Dimension d = c.getPreferredSize();
			//				c.setBounds(left, top, right - left, d.height);
			//				top += d.height + vgap;
			//			}
			//			if ((c = getChild(SOUTH, ltr)) != null) {
			//				c.setSize(right - left, c.getHeight());
			//				Dimension d = c.getPreferredSize();
			//				c.setBounds(left, bottom - d.height, right - left, d.height);
			//				bottom -= d.height + vgap;
			//			}
			//			if ((c = getChild(EAST, ltr)) != null) {
			//				c.setSize(c.getWidth(), bottom - top);
			//				Dimension d = c.getPreferredSize();
			//				c.setBounds(right - d.width, top, d.width, bottom - top);
			//				right -= d.width + hgap;
			//			}
			//			if ((c = getChild(WEST, ltr)) != null) {
			//				c.setSize(c.getWidth(), bottom - top);
			//				Dimension d = c.getPreferredSize();
			//				c.setBounds(left, top, d.width, bottom - top);
			//				left += d.width + hgap;
			//			}
			//			if ((c = getChild(CENTER, ltr)) != null) {
			//				c.setBounds(left, top, right - left, bottom - top);
			//			}
		}
	}

	private Component getChild(String key, boolean ltr) {
		Component result = null;

		//		if (key == NORTH) {
		//			result = (firstLine != null) ? firstLine : north;
		//		} else if (key == SOUTH) {
		//			result = (lastLine != null) ? lastLine : south;
		//		} else if (key == WEST) {
		//			result = ltr ? firstItem : lastItem;
		//			if (result == null) {
		//				result = west;
		//			}
		//		} else if (key == EAST) {
		//			result = ltr ? lastItem : firstItem;
		//			if (result == null) {
		//				result = east;
		//			}
		//		} else if (key == CENTER) {
		//			result = center;
		//		}
		//		if (result != null && !result.isVisible()) {
		//			result = null;
		//		}
		return result;
	}

	public String toString() {
		return getClass().getName() + "[hgap=" + hgap + ",vgap=" + vgap + "]";
	}

}

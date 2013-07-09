package com.peterswing.advancedswing.jtable;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class SortableTableModel extends DefaultTableModel {
	int[] indexes;
	TableSorter sorter;
	public AbstractTableModel model;

	public SortableTableModel(AbstractTableModel model) {
		this.model = model;
	}

	public String getColumnName(int column) {
		if (model != null) {
			return model.getColumnName(column);
		} else {
			return null;
		}
	}

	public int getColumnCount() {
		if (model != null) {
			return model.getColumnCount();
		} else {
			return 0;
		}
	}

	public int getRowCount() {
		if (model != null) {
			return model.getRowCount();
		} else {
			return 0;
		}
	}

	public Class getColumnClass(int columnIndex) {
		return model.getColumnClass(columnIndex);
	}

	public Object getValueAt(int row, int col) {
		int rowIndex = row;
		if (indexes != null) {
			rowIndex = indexes[row];
		}
		return model.getValueAt(rowIndex, col);
	}

	public void setValueAt(Object value, int row, int col) {
		int rowIndex = row;
		if (indexes != null) {
			rowIndex = indexes[row];
		}
		model.setValueAt(value, rowIndex, col);
	}

	public void sortByColumn(int column, boolean isAscent) {
		if (sorter == null) {
			sorter = new TableSorter(this);
		}
		sorter.sort(column, isAscent);
		model.fireTableDataChanged();
	}

	public int[] getIndexes() {
		int n = model.getRowCount();
		if (indexes != null) {
			if (indexes.length == n) {
				return indexes;
			}
		}
		indexes = new int[n];
		for (int i = 0; i < n; i++) {
			indexes[i] = i;
		}
		return indexes;
	}

	public void fireTableStructureChanged() {
		if (model != null) {
			model.fireTableStructureChanged();
		}
		super.fireTableStructureChanged();
	}

	public void fireTableDataChanged() {
		if (model != null) {
			model.fireTableDataChanged();
		}
		super.fireTableDataChanged();
	}

	public boolean isCellEditable(int row, int column) {
		return model.isCellEditable(row, column);
	}

	public int getColumnIndex(String columnName) {
		for (int x = 0; x < getColumnCount(); x++) {
			if (getColumnName(x).equals(columnName)) {
				return x;
			}
		}
		return -1;
	}
}
package com.peterswing;

import java.util.HashMap;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class GenericTableModel extends DefaultTableModel {
	public Vector<String> columnNames = new Vector<String>();
	public Vector<Vector<Object>> values = new Vector<Vector<Object>>();
	public HashMap<Integer, Boolean> editables = new HashMap<Integer, Boolean>();
	public HashMap<Integer, Class> columnTypes = new HashMap<Integer, Class>();

	public GenericTableModel() {
	}

	public String getColumnName(int column) {
		return columnNames.get(column);
	}

	public int getColumnCount() {
		if (columnNames == null) {
			return 0;
		}
		return columnNames.size();
	}

	public int getRowCount() {
		if (values == null || values.size() == 0) {
			return 0;
		}
		return values.get(0).size();
	}

	public void setValueAt(Object aValue, int row, int column) {
		this.fireTableDataChanged();
	}

	public Object getValueAt(final int row, int column) {
		return values.get(column).get(row);
	}

	public boolean isCellEditable(int row, int column) {
		if (editables.get(column) != null) {
			return editables.get(column);
		}
		return false;
	}

	public Class getColumnClass(int columnIndex) {
		if (getValueAt(0, columnIndex) == null && columnTypes.get(columnIndex) == null) {
			return Object.class;
		}
		if (columnTypes.get(columnIndex) != null) {
			return columnTypes.get(columnIndex);
		}
		return getValueAt(0, columnIndex).getClass();
	}

	public int getColumnIndex(String columnName) {
		for (int x = 0; x < columnNames.size(); x++) {
			if (columnNames.get(x).equals(columnName)) {
				return x;
			}
		}
		return -1;
	}

	public Object getValue(String columnName, int row) {
		int x = 0;
		for (x = 0; x < columnNames.size(); x++) {
			if (columnNames.get(x).equals(columnName)) {
				return getValueAt(row, x);
			}
		}
		return null;
	}
}
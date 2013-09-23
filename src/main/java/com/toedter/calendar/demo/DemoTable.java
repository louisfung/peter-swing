package com.toedter.calendar.demo;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import com.toedter.calendar.JDateChooserCellEditor;

public class DemoTable extends JPanel {
	private static final long serialVersionUID = -2823838920746867592L;

	public DemoTable() {
		super(new GridLayout(1, 0));

		setName("DemoTable");

		JTable table = new JTable(new DemoTableModel());
		table.setPreferredScrollableViewportSize(new Dimension(180, 32));
		table.setDefaultEditor(Date.class, new JDateChooserCellEditor());

		// Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);

		// Add the scroll pane to this panel.
		add(scrollPane);
	}

	class DemoTableModel extends AbstractTableModel {
		private static final long serialVersionUID = 3283465559187131559L;

		private final String[] columnNames = { "Empty Date", "Date set" };

		private final Object[][] data = { { null, new Date() }, { null, new Date() } };

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.length;
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

		public Object getValueAt(int row, int col) {
			return data[row][col];
		}

		public Class getColumnClass(int c) {
			return getValueAt(0, 1).getClass();
		}

		public boolean isCellEditable(int row, int col) {
			return true;
		}

		public void setValueAt(Object value, int row, int col) {
			data[row][col] = value;
			fireTableCellUpdated(row, col);
		}
	}
}
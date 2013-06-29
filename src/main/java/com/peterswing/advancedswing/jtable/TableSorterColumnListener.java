package com.peterswing.advancedswing.jtable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

public class TableSorterColumnListener extends MouseAdapter {
	protected JTable table;
	SortableTableModel sortableTableModel;
	public boolean isSortAsc = true;
	public int sortCol = 0;

	public TableSorterColumnListener(JTable table, SortableTableModel sortableTableModel) {
		this.table = table;
		this.sortableTableModel = sortableTableModel;
	}

	public void mouseClicked(MouseEvent e) {
		try {
			TableColumnModel colModel = table.getColumnModel();
			int columnModelIndex = colModel.getColumnIndexAtX(e.getX());
			int modelIndex = colModel.getColumn(columnModelIndex).getModelIndex();
			if (modelIndex < 0)
				return;
			if (sortCol == modelIndex)
				isSortAsc = !isSortAsc;
			else
				sortCol = modelIndex;

			sortableTableModel.sortByColumn(columnModelIndex, isSortAsc);
			sortableTableModel.fireTableDataChanged();
		} catch (Exception ex) {

		}
	}

}

package com.peterswing.white;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTableHeaderUI;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class TableHeaderUI extends BasicTableHeaderUI {
	boolean mouseOver;
	int mouseOverColumn = -1;

	Image normalBG = new ImageIcon(TableHeaderUI.class.getResource("images/PTable/PTable_Header.png")).getImage();
	Image mouseOverBG = new ImageIcon(TableHeaderUI.class.getResource("images/PTable/PTable_Header_mouseOver.png")).getImage();

	public static ComponentUI createUI(JComponent h) {
		return new TableHeaderUI();
	}

	//	protected MouseInputListener createMouseInputListener() {
	//		super.createMouseInputListener();
	//		return new MouseInputHandler();
	//	}

	public void paint(Graphics g, JComponent c) {
		//		System.out.println(c + "," + c.getX() + "," + c.getY() + "," + c.getWidth() + "," + c.getHeight());
		JTableHeader header = (JTableHeader) c;
		Rectangle rect = new Rectangle();
		for (int x = 0; x < header.getColumnModel().getColumnCount(); x++) {
			rect.y = 0;
			rect.width = header.getColumnModel().getColumn(x).getWidth();
			rect.height = c.getHeight();
			paintCell(g, rect, x);
			rect.x += rect.width;
		}
	}

	private void paintCell(Graphics g, Rectangle cellRect, int columnIndex) {
		g.drawImage(normalBG, cellRect.x, cellRect.y, cellRect.width, cellRect.height, null, null);
		g.setColor(Color.gray);
		g.drawLine(cellRect.x, cellRect.height - 1, cellRect.x + cellRect.width, cellRect.height - 1);

		Component component = getHeaderRenderer(columnIndex);
		rendererPane.paintComponent(g, component, header, cellRect.x, cellRect.y, cellRect.width, cellRect.height, true);
	}

	private Component getHeaderRenderer(int columnIndex) {
		try {
			TableColumn aColumn = header.getColumnModel().getColumn(columnIndex);
			TableCellRenderer renderer = aColumn.getHeaderRenderer();

			if (renderer == null) {
				renderer = header.getDefaultRenderer();
			}

			return renderer.getTableCellRendererComponent(header.getTable(), aColumn.getHeaderValue(), false, false, -1, columnIndex);
		} catch (Exception ex) {

		}
		return null;
	}

	//	class MouseInputHandler implements MouseInputListener {
	//
	//		public void mouseEntered(MouseEvent e) {
	//			mouseOver = true;
	//			TableColumnModel columnModel = header.getColumnModel();
	//			mouseOverColumn = columnModel.getColumnIndexAtX(e.getPoint().x);
	//			header.repaint();
	//		}
	//
	//		public void mouseExited(MouseEvent e) {
	//			mouseOver = false;
	//			header.repaint();
	//		}
	//
	//		@Override
	//		public void mouseClicked(MouseEvent e) {
	//			// TODO Auto-generated method stub
	//
	//		}
	//
	//		@Override
	//		public void mousePressed(MouseEvent e) {
	//			// TODO Auto-generated method stub
	//
	//		}
	//
	//		@Override
	//		public void mouseReleased(MouseEvent e) {
	//			// TODO Auto-generated method stub
	//
	//		}
	//
	//		@Override
	//		public void mouseDragged(MouseEvent e) {
	//			// TODO Auto-generated method stub
	//
	//		}
	//
	//		@Override
	//		public void mouseMoved(MouseEvent e) {
	//			// TODO Auto-generated method stub
	//
	//		}
	//
	//	}
}
package com.peterswing.white;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTableHeaderUI;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class TableHeaderUI extends BasicTableHeaderUI {
	Image normalBG = new ImageIcon(TableHeaderUI.class.getResource("images/PTable/PTable_Header.png")).getImage();
	Image mouseOverBG = new ImageIcon(TableHeaderUI.class.getResource("images/PTable/PTable_Header_mouseOver.png")).getImage();

	public static ComponentUI createUI(JComponent h) {
		return new TableHeaderUI();
	}

	public void paint(Graphics g, JComponent c) {
		Random rand = new Random();
		float r = rand.nextFloat();
		float gg = rand.nextFloat();
		float b = rand.nextFloat();
		Color randomColor = new Color(r, gg, b);
		g.setColor(randomColor);
		g.fillRect(c.getX(), c.getY(), c.getWidth(), c.getHeight());
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

}
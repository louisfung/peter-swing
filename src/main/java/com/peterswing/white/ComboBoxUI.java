package com.peterswing.white;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.ComboPopup;

public class ComboBoxUI extends BasicComboBoxUI {
	JComboBox comboBox;

	public static ComponentUI createUI(final JComponent c) {
		return new ComboBoxUI();
	}

	public void installUI(JComponent c) {
		comboBox = (JComboBox) c;
		super.installUI(c);
	}

	public void uninstallUI(JComponent c) {
		super.uninstallUI(c);
	}

	public JButton createArrowButton() {
		return new ComboBox_ArrowButton(comboBox);
	}

	public ComboBoxEditor createEditor() {
		return new ComboBox_ComboBoxEditor();
	}

	protected ComboPopup createPopup() {
		return super.createPopup();
	}

	public void paint(Graphics g, JComponent c) {
		super.paint(g, c);
	}

	public void paintCurrentValue(Graphics g, Rectangle bounds, boolean hasFocus) {
		bounds.x += 1;
		//		bounds.width -= 2;
		bounds.y += 1;
		bounds.height -= 2;
		super.paintCurrentValue(g, bounds, hasFocus);
	}

	public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
		super.paintCurrentValueBackground(g, bounds, hasFocus);
		g.setColor(Color.LIGHT_GRAY);
		g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height - 1);
		//		g.setColor(MetalLookAndFeel.getControlShadow());
		//		g.drawRect(bounds.x + 1, bounds.y + 1, bounds.width, bounds.height - 3);
	}

	public Dimension getMinimumSize(JComponent c) {
		if (!isMinimumSizeDirty) {
			return new Dimension(cachedMinimumSize);
		}

		Dimension size = null;

		if (!comboBox.isEditable() && arrowButton != null) {
			Insets buttonInsets = arrowButton.getInsets();
			Insets insets = comboBox.getInsets();

			size = getDisplaySize();
			size.width += insets.left + insets.right;
			size.width += buttonInsets.right;
			size.width += arrowButton.getMinimumSize().width;
			size.height += insets.top + insets.bottom;
			size.height += buttonInsets.top + buttonInsets.bottom;
		} else if (comboBox.isEditable() && arrowButton != null && editor != null) {
			size = super.getMinimumSize(c);
			Insets margin = arrowButton.getMargin();
			size.height += margin.top + margin.bottom;
			size.width += margin.left + margin.right;
		} else {
			size = super.getMinimumSize(c);
		}

		cachedMinimumSize.setSize(size.width + 20, size.height);
		isMinimumSizeDirty = false;

		return new Dimension(cachedMinimumSize);
	}

}

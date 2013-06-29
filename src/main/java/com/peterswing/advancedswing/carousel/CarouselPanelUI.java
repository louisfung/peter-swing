package com.peterswing.advancedswing.carousel;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicPanelUI;

public class CarouselPanelUI extends BasicPanelUI {
	// Shared UI object
	private static CarouselPanelUI panelUI;

	public static ComponentUI createUI(JComponent c) {
		if (panelUI == null) {
			panelUI = new CarouselPanelUI();
		}
		return panelUI;
	}

	public void installUI(JComponent c) {
		super.installUI(c);
	}

	public void uninstallUI(JComponent c) {
		super.uninstallUI(c);
	}

	public void paint(Graphics g, JComponent c) {
		super.paint(g, c);
	}
}

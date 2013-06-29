package com.peterswing.advancedswing.jmaximizabletabbedpane;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JPanel;

public class JMaximizableTabbedPane_BasePanel extends JPanel {
	public JMaximizableTabbedPane_BasePanel() {
		this.setLayout(new CardLayout());
	}

	public void show(String name) {
		CardLayout cl = (CardLayout) (this.getLayout());
		cl.show(this, name);
	}
}

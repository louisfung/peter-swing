package com.peterswing.advancedswing.carousel;

import java.awt.Component;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Carousel extends JPanel {
	CarouselAnimationPanel animationPanel = new CarouselAnimationPanel();

	public Carousel() {
		setLayout(new CarouselLayout());
		add(animationPanel, "animationPanel");
		// b.setSize(100, 100);
	}

	// public Component add(Component c) {
	// return c;
	// }
	//
	// public Component add(Component c, String name) {
	// return c;
	// }

	// public void paint(Graphics g) {
	// b.paint(g);
	// }

}

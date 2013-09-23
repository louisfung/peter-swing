package com.peterswing.advancedswing.resizabletextfield;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
import javax.swing.text.Document;

public class JResizableTextField extends JTextField implements FocusListener {
	public JResizableTextField() {
		super();
		initGUI();
	}

	public JResizableTextField(String text) {
		super(text);
		initGUI();
	}

	public JResizableTextField(int columns) {
		super(columns);
		initGUI();
	}

	public JResizableTextField(String text, int columns) {
		super(text, columns);
		initGUI();
	}

	public JResizableTextField(Document doc, String text, int columns) {
		super(doc, text, columns);
		initGUI();
	}

	private void initGUI() {
		this.addFocusListener(this);
	}

	int originalHeight;
	int originalWidth;

	@Override
	public void focusGained(FocusEvent e) {
		System.out.println("focusGained");
		System.out.println(originalHeight);
		this.originalHeight = this.getMinimumSize().height;
		this.originalWidth = this.getWidth();
		this.setSize(new Dimension(300, 100));
		this.repaint();
		// this.updateUI();
	}

	@Override
	public void focusLost(FocusEvent e) {
		System.out.println("focusLost");
		System.out.println(originalHeight);
		this.setSize(new Dimension(300, 25));
		// this.updateUI();
	}

}

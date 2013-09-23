package com.peterswing.advancedswing.swappanel;

import java.awt.BorderLayout;

import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class TestJFrame extends javax.swing.JFrame {
	private SwapPanel swapPanel1;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TestJFrame inst = new TestJFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public TestJFrame() {
		super();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		{
			swapPanel1 = new SwapPanel();
			getContentPane().add(swapPanel1, BorderLayout.CENTER);
		}
		pack();
		setSize(400, 400);
	}

}

package com.peterswing.advancedswing.swappanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SwapPanel extends JPanel implements ActionListener {
	private JButton jButton1;
	private JButton jButton2;
	private Timer timer = new Timer(200, this);

	public SwapPanel() {
		super();
		try {
			SwapPanelLayout thisLayout = new SwapPanelLayout();
			this.setLayout(thisLayout);
			this.setPreferredSize(new java.awt.Dimension(397, 302));

			jButton1 = new JButton();
			this.add(jButton1);
			jButton1.setText("jButton1");

			jButton2 = new JButton();
			this.add(jButton2);
			jButton2.setText("jButton2");

			timer.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("timer");
		this.layout();
	}

}

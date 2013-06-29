package com.peterswing.advancedswing.swappanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class SwapPanel extends JPanel implements ActionListener {
	private JButton jButton1;
	private JButton jButton2;
	private Timer timer = new Timer(200, this);

	public SwapPanel() {
		super();
		initGUI();
		timer.start();
	}

	private void initGUI() {
		try {
			{
				SwapPanelLayout thisLayout = new SwapPanelLayout();
				this.setLayout(thisLayout);
				this.setPreferredSize(new java.awt.Dimension(397, 302));
				{
					jButton1 = new JButton();
					this.add(jButton1);
					jButton1.setText("jButton1");
				}
				{
					jButton2 = new JButton();
					this.add(jButton2);
					jButton2.setText("jButton2");
				}
			}
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

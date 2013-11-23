package com.peterswing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import java.awt.Color;

public class NewJFrame extends javax.swing.JFrame {
	private JScrollPane jScrollPane1;
	private JButton jButton1;
	private JProgressBar jProgressBar1;
	private JTable jTable1;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.peterswing.white.PeterSwingWhiteLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				NewJFrame inst = new NewJFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public NewJFrame() {
		super();
		getContentPane().setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		{
			jScrollPane1 = new JScrollPane();
			getContentPane().add(jScrollPane1);
			jScrollPane1.setBounds(23, 63, 390, 244);
			{
				TableModel jTable1Model = new DefaultTableModel(new String[][] { { "One", "Two" }, { "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" },
						{ "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" },
						{ "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" },
						{ "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" } }, new String[] { "Column 1",
						"Column 2" });
				jTable1 = new JTable();
				jScrollPane1.setViewportView(jTable1);
				jTable1.setModel(jTable1Model);
			}
		}
		{
			jButton1 = new JButton();
			getContentPane().add(jButton1);
			jButton1.setText("jButton1");
			jButton1.setBounds(204, 346, 58, 25);
			jButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton1ActionPerformed(evt);
				}
			});
		}
		{
			jProgressBar1 = new JProgressBar();
			getContentPane().add(jProgressBar1);
			jProgressBar1.setBounds(23, 16, 148, 14);
			//				jProgressBar1.setStringPainted(true);
		}
		
		JSlider slider = new JSlider();
		slider.setBounds(281, 346, 200, 24);
		getContentPane().add(slider);
		
		JSlider slider_1 = new JSlider();
		slider_1.setOrientation(SwingConstants.VERTICAL);
		slider_1.setBounds(482, 28, 24, 310);
		getContentPane().add(slider_1);
		this.setSize(607, 533);
	}

	private void jButton1ActionPerformed(ActionEvent evt) {
	}
}

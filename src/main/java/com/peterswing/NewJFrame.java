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
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		{
			jScrollPane1 = new JScrollPane();
			getContentPane().add(jScrollPane1);
			jScrollPane1.setBounds(23, 63, 540, 264);
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
		pack();
		this.setSize(576, 399);
	}

	private void jButton1ActionPerformed(ActionEvent evt) {
	}

}

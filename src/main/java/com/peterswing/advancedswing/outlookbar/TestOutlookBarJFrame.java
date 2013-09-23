package com.peterswing.advancedswing.outlookbar;

import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class TestOutlookBarJFrame extends javax.swing.JFrame {
	private OutlookBar outlookBar1;
	private JColorChooser jColorChooser1;
	private JPanel jPanel3;
	private JScrollPane jScrollPane2;
	private JPanel jPanel2;
	private JPanel jPanel1;
	private JTabbedPane jTabbedPane1;
	private JSplitPane jSplitPane1;
	private JTree jTree1;
	private JTable jTable1;
	private JScrollPane jScrollPane1;
	private JPanel Peter;
	private JPanel jTreePanel;
	private JPanel jTablePanel;

	ImageIcon icon1 = new ImageIcon(TestOutlookBarJFrame.class.getResource("add.png"));
	ImageIcon icon2 = new ImageIcon(TestOutlookBarJFrame.class.getResource("bell.png"));
	ImageIcon icon3 = new ImageIcon(TestOutlookBarJFrame.class.getResource("bomb.png"));

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.peterswing.white.PeterSwingWhiteLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TestOutlookBarJFrame inst = new TestOutlookBarJFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public TestOutlookBarJFrame() {
		super();
		try {
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			GroupLayout thisLayout = new GroupLayout((JComponent) getContentPane());
			getContentPane().setLayout(thisLayout);
			this.setTitle("Outlook Bar");

			jSplitPane1 = new JSplitPane();
			jSplitPane1.setDividerLocation(180);

			outlookBar1 = new OutlookBar();
			jSplitPane1.add(outlookBar1, JSplitPane.LEFT);

			jTablePanel = new JPanel();
			BorderLayout jTablePanelLayout = new BorderLayout();
			jTablePanel.setLayout(jTablePanelLayout);
			outlookBar1.add(jTablePanel, "JTable");
			//					outlookBar1.setSelectedButtonColor(OutlookBar.SelectedButtonColor.outlookBarColorRed);

			jScrollPane1 = new JScrollPane();
			jTablePanel.add(jScrollPane1, BorderLayout.CENTER);

			TableModel jTable1Model = new DefaultTableModel(new String[][] { { "One", "Two" }, { "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" },
					{ "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" },
					{ "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" },
					{ "Three", "Four" } }, new String[] { "Column 1", "Column 2" });
			jTable1 = new JTable();
			jScrollPane1.setViewportView(jTable1);
			jTable1.setModel(jTable1Model);

			jTreePanel = new JPanel();
			BorderLayout jTreePanelLayout = new BorderLayout();
			jTreePanel.setLayout(jTreePanelLayout);
			outlookBar1.add(jTreePanel, "JTree");

			jScrollPane2 = new JScrollPane();
			jTreePanel.add(jScrollPane2, BorderLayout.CENTER);

			jTree1 = new JTree();
			jScrollPane2.setViewportView(jTree1);
			for (int x = 0; x < jTree1.getRowCount(); x++) {
				jTree1.expandRow(x);
			}

			Peter = new JPanel();
			outlookBar1.add(Peter, "Peter");

			jColorChooser1 = new JColorChooser();
			Peter.add(jColorChooser1);

			outlookBar1.setSelectedComponent(jTreePanel);

			jTabbedPane1 = new JTabbedPane();
			jSplitPane1.add(jTabbedPane1, JSplitPane.RIGHT);

			jPanel1 = new JPanel();
			jTabbedPane1.addTab("jPanel1", null, jPanel1, null);

			jPanel2 = new JPanel();
			jTabbedPane1.addTab("jPanel2", null, jPanel2, null);

			jPanel3 = new JPanel();
			jTabbedPane1.addTab("jPanel3", null, jPanel3, null);

			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup().addContainerGap(32, 32).addComponent(jSplitPane1, 0, 350, Short.MAX_VALUE).addContainerGap(46, 46));
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup().addContainerGap().addComponent(jSplitPane1, 0, 438, Short.MAX_VALUE).addContainerGap());
			pack();
			this.setSize(800, 700);

			outlookBar1.getJButton("JTree").setIcon(icon1);
			outlookBar1.getJButton("JTable").setIcon(icon2);
			outlookBar1.getJButton("Peter").setIcon(icon3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

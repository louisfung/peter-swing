package com.peterswing;

import com.peterswing.advancedswing.jdropdownbutton.JDropDownButton;
import com.peterswing.advancedswing.onoffbutton.OnOffButton;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import java.awt.BorderLayout;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JEditorPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.ListModel;
import javax.swing.SpinnerListModel;
import javax.swing.UIManager;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

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
public class ShowAllControlsJFrame extends javax.swing.JFrame {
	private JButton jButton1;
	private JSpinner jSpinner2;
	private JScrollPane jScrollPane1;
	private JTable jTable1;
	private JProgressBar jProgressBar1;
	private JEditorPane jEditorPane1;
	private JTextField jTextField1;
	private JList jList1;
	private JScrollPane jScrollPane2;
	private JPanel jPanel3;
	private JPanel jPanel2;
	private JPanel jPanel1;
	private JTabbedPane jTabbedPane1;
	private JCheckBox jCheckBox2;
	private JTree jTree2;
	private JTable jTable2;
	private JScrollPane jScrollPane5;
	private JScrollPane jScrollPane4;
	private JPanel jPanel5;
	private JPanel jPanel4;
	private JSplitPane jSplitPane1;
	private JComboBox jComboBox3;
	private JComboBox jComboBox2;
	private JCalendar jCalendar1;
	private OnOffButton onOffButton1;
	private JDropDownButton jDropDownButton1;
	private JTextArea jTextArea1;
	private JMenuItem jMenuItem3;
	private JSeparator jSeparator1;
	private JMenuItem jMenuItem2;
	private JMenuItem jMenuItem1;
	private JMenu jMenu2;
	private JCheckBoxMenuItem jCheckBoxMenuItem1;
	private JMenu jMenu1;
	private JMenuBar jMenuBar1;
	private JInternalFrame jInternalFrame2;
	private JInternalFrame jInternalFrame1;
	private JDesktopPane jDesktopPane1;
	private JToggleButton jToggleButton2;
	private JRadioButton jRadioButton2;
	private JButton jButton2;
	private JToolBar jToolBar1;
	private JScrollPane jScrollPane3;
	private JTree jTree1;
	private JLabel jLabel1;
	private JSpinner jSpinner1;
	private JComboBox jComboBox1;
	private JToggleButton jToggleButton1;
	private JCheckBox jCheckBox1;
	private JRadioButton jRadioButton1;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.peterswing.white.peterswingWhiteLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ShowAllControlsJFrame inst = new ShowAllControlsJFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public ShowAllControlsJFrame() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("UI Demo");
			getContentPane().setLayout(null);
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu1 = new JMenu();
					jMenuBar1.add(jMenu1);
					jMenu1.setText("jMenu1");
					{
						jCheckBoxMenuItem1 = new JCheckBoxMenuItem();
						jMenu1.add(jCheckBoxMenuItem1);
						jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");
					}
					{
						jMenuItem2 = new JMenuItem();
						jMenu1.add(jMenuItem2);
						jMenuItem2.setText("jMenuItem2");
					}
					{
						jSeparator1 = new JSeparator();
						jMenu1.add(jSeparator1);
					}
					{
						jMenuItem3 = new JMenuItem();
						jMenu1.add(jMenuItem3);
						jMenuItem3.setText("jMenuItem3");
					}
				}
				{
					jMenu2 = new JMenu();
					jMenuBar1.add(jMenu2);
					jMenu2.setText("jMenu2");
					{
						jMenuItem1 = new JMenuItem();
						jMenu2.add(jMenuItem1);
						jMenuItem1.setText("jMenuItem1");
					}
				}
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("jButton1");
				jButton1.setBounds(18, 11, 109, 22);
			}
			{
				jRadioButton1 = new JRadioButton();
				getContentPane().add(jRadioButton1);
				jRadioButton1.setText("jRadioButton1");
				jRadioButton1.setBounds(139, 13, 131, 19);
			}
			{
				jCheckBox1 = new JCheckBox();
				getContentPane().add(jCheckBox1);
				jCheckBox1.setText("jCheckBox1");
				jCheckBox1.setBounds(292, 13, 113, 19);
			}
			{
				jToggleButton1 = new JToggleButton();
				getContentPane().add(jToggleButton1);
				jToggleButton1.setText("jToggleButton1");
				jToggleButton1.setBounds(18, 45, 109, 22);
			}
			{
				ComboBoxModel jComboBox1Model = new DefaultComboBoxModel(new String[] { "Item One", "Item Two" });
				jComboBox1 = new JComboBox();
				getContentPane().add(jComboBox1);
				jComboBox1.setModel(jComboBox1Model);
				jComboBox1.setBounds(139, 45, 106, 22);
			}
			{
				SpinnerListModel jSpinner1Model = new SpinnerListModel(new String[] { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" });
				jSpinner1 = new JSpinner();
				getContentPane().add(jSpinner1);
				jSpinner1.setModel(jSpinner1Model);
				jSpinner1.setBounds(472, 44, 102, 24);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("jLabel1");
				jLabel1.setBounds(585, 49, 59, 15);
			}
			{
				ListModel jList1Model = new DefaultComboBoxModel(new String[] { "Item One", "Item Two" });
				jList1 = new JList();
				getContentPane().add(jList1);
				jList1.setModel(jList1Model);
				jList1.setBounds(18, 79, 111, 125);
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1);
				jTextField1.setText("jTextField1");
				jTextField1.setBounds(139, 79, 106, 19);
			}
			{
				jScrollPane2 = new JScrollPane();
				getContentPane().add(jScrollPane2);
				jScrollPane2.setBounds(141, 104, 257, 158);
				{
					jEditorPane1 = new JEditorPane();
					jScrollPane2.setViewportView(jEditorPane1);
					jEditorPane1.setText("jEditorPane1\n\nline1\nline2\nline3\nline4\nline5\nline6\nline7\nline8\nline9");
					jEditorPane1.setBounds(141, 104, 257, 158);
				}
			}
			{
				jProgressBar1 = new JProgressBar();
				getContentPane().add(jProgressBar1);
				jProgressBar1.setBounds(257, 84, 148, 14);
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(411, 84, 233, 164);
				{
					TableModel jTable1Model = new DefaultTableModel(new String[][] { { "One", "Two" }, { "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" },
							{ "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" },
							{ "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" }, { "Three", "Four" } },
							new String[] { "Column 1", "Column 2" });
					jTable1 = new JTable();
					jScrollPane1.setViewportView(jTable1);
					jTable1.setModel(jTable1Model);
					jTable1.setBounds(519, 115, 235, 160);
				}
			}
			{
				jScrollPane3 = new JScrollPane();
				getContentPane().add(jScrollPane3);
				jScrollPane3.setBounds(18, 216, 111, 253);
				{
					jTree1 = new JTree();
					jScrollPane3.setViewportView(jTree1);
					jTree1.setBounds(18, 216, 111, 253);
				}
			}
			{
				jToolBar1 = new JToolBar();
				getContentPane().add(jToolBar1);
				jToolBar1.setBounds(141, 274, 555, 28);
				{
					jButton2 = new JButton();
					jToolBar1.add(jButton2);
					jButton2.setText("jButton2");
				}
				{
					jRadioButton2 = new JRadioButton();
					jToolBar1.add(jRadioButton2);
					jRadioButton2.setText("jRadioButton2");
				}
				{
					jCheckBox2 = new JCheckBox();
					jToolBar1.add(jCheckBox2);
					jCheckBox2.setText("jCheckBox2");
				}
				{
					jToggleButton2 = new JToggleButton();
					jToolBar1.add(jToggleButton2);
					jToggleButton2.setText("jToggleButton2");
				}
				{
					SpinnerListModel jSpinner2Model = 
							new SpinnerListModel(
									new String[] { "Sun", "Mon" , "Tue" , "Wed" , "Thu" , "Fri" , "Sat" });
					jSpinner2 = new JSpinner();
					jToolBar1.add(jSpinner2);
					jSpinner2.setModel(jSpinner2Model);
				}
			}
			{
				jTabbedPane1 = new JTabbedPane();
				getContentPane().add(jTabbedPane1);
				jTabbedPane1.setBounds(141, 308, 278, 161);
				{
					jPanel1 = new JPanel();
					jTabbedPane1.addTab("jPanel1", null, jPanel1, null);
				}
				{
					jPanel2 = new JPanel();
					jTabbedPane1.addTab("jPanel2", null, jPanel2, null);
				}
				{
					jPanel3 = new JPanel();
					jTabbedPane1.addTab("jPanel3", null, jPanel3, null);
				}
			}
			{
				jDesktopPane1 = new JDesktopPane();
				getContentPane().add(jDesktopPane1);
				jDesktopPane1.setBounds(431, 314, 385, 176);
				{
					jInternalFrame1 = new JInternalFrame("JInternalFrame");
					jInternalFrame1.setMaximizable(true);
					jInternalFrame1.setIconifiable(true);
					jDesktopPane1.add(jInternalFrame1, JLayeredPane.DEFAULT_LAYER);
					jInternalFrame1.setBounds(10, 16, 188, 136);
					jInternalFrame1.setVisible(true);
				}
				{
					jInternalFrame2 = new JInternalFrame("JInternalFrame");
					jDesktopPane1.add(jInternalFrame2, JLayeredPane.DEFAULT_LAYER);
					jInternalFrame2.setBounds(222, 8, 142, 111);
					jInternalFrame2.setVisible(true);
				}
			}
			{
				jTextArea1 = new JTextArea();
				getContentPane().add(jTextArea1);
				jTextArea1.setText("jTextArea1  Item");
				jTextArea1.setBounds(667, 74, 149, 172);
			}
			{
				jDropDownButton1 = new JDropDownButton();
				getContentPane().add(jDropDownButton1);
				jDropDownButton1.setText("jDropDownButton1");
				jDropDownButton1.setBounds(411, 10, 193, 25);
			}
			{
				onOffButton1 = new OnOffButton();
				getContentPane().add(onOffButton1);
				onOffButton1.setText("onOffButton1");
				onOffButton1.setBounds(621, 14, 46, 16);
			}
			{
				jCalendar1 = new JCalendar();
				getContentPane().add(jCalendar1);
				jCalendar1.setBounds(18, 496, 258, 189);
			}
			{
				ComboBoxModel jComboBox2Model = new DefaultComboBoxModel(new String[] { "Item One", "Item Two" });
				jComboBox2 = new JComboBox();
				getContentPane().add(jComboBox2);
				jComboBox2.setModel(jComboBox2Model);
				jComboBox2.setBounds(139, 45, 106, 22);
			}
			{
				ComboBoxModel jComboBox3Model = new DefaultComboBoxModel(new String[] { "Item One", "Item Two" });
				jComboBox3 = new JComboBox();
				getContentPane().add(jComboBox3);
				jComboBox3.setModel(jComboBox3Model);
				jComboBox3.setBounds(257, 45, 106, 22);
				jComboBox3.setEditable(true);
			}
			{
				jSplitPane1 = new JSplitPane();
				getContentPane().add(jSplitPane1);
				jSplitPane1.setBounds(292, 496, 460, 216);
				jSplitPane1.setDividerLocation(220);
				{
					jPanel4 = new JPanel();
					BorderLayout jPanel4Layout = new BorderLayout();
					jPanel4.setLayout(jPanel4Layout);
					jSplitPane1.add(jPanel4, JSplitPane.RIGHT);
					{
						jScrollPane5 = new JScrollPane();
						jPanel4.add(jScrollPane5, BorderLayout.CENTER);
						{
							TableModel jTable2Model = 
									new DefaultTableModel(
											new String[][] { { "One", "Two" }, { "Three", "Four" } },
											new String[] { "Column 1", "Column 2" });
							jTable2 = new JTable();
							jScrollPane5.setViewportView(jTable2);
							jTable2.setModel(jTable2Model);
						}
					}
				}
				{
					jPanel5 = new JPanel();
					BorderLayout jPanel5Layout = new BorderLayout();
					jPanel5.setLayout(jPanel5Layout);
					jSplitPane1.add(jPanel5, JSplitPane.LEFT);
					{
						jScrollPane4 = new JScrollPane();
						jPanel5.add(jScrollPane4, BorderLayout.CENTER);
						{
							jTree2 = new JTree();
							jScrollPane4.setViewportView(jTree2);
						}
					}
				}
			}
			pack();
			this.setSize(858, 783);
		} catch (Exception e) {
			//add your error handling code here
			e.printStackTrace();
		}
	}

}

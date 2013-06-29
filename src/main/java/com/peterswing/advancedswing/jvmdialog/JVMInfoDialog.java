package com.peterswing.advancedswing.jvmdialog;

import java.awt.BorderLayout;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.peterswing.CommonLib;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used commercially (ie, by a
 * corporation, company or business for any purpose whatever) then you should purchase a license for each developer using Jigloo. Please visit www.cloudgarden.com for details. Use
 * of Jigloo implies acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR ANY
 * CORPORATE OR COMMERCIAL PURPOSE.
 */
public class JVMInfoDialog extends javax.swing.JDialog {
	private JScrollPane JScrollPane1;
	private JTable pVMTable;

	public JVMInfoDialog(JFrame frame) {
		super(frame, true);
		initGUI();
	}

	private void initGUI() {
		try {
			{
				this.setTitle("JVM Information");
			}
			{
				JScrollPane1 = new JScrollPane();
				getContentPane().add(JScrollPane1, BorderLayout.CENTER);
				{
					pVMTable = new JTable();
					JScrollPane1.setViewportView(pVMTable);
				}
			}
			initVMTable();
			setSize(500, 600);
			CommonLib.centerDialog(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initVMTable() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("property");
		model.addColumn("value");
		Properties prop = new Properties();
		String key = null;
		prop = System.getProperties();
		Enumeration keysEnum = prop.keys();
		Vector keyList = new Vector();
		while (keysEnum.hasMoreElements()) {
			keyList.add(keysEnum.nextElement());
		}
		Collections.sort(keyList);
		for (Enumeration e = keyList.elements(); e.hasMoreElements();) {
			key = e.nextElement().toString();
			model.addRow(new Object[] { key, prop.getProperty(key) });
		}
		pVMTable.setModel(model);
	}

}

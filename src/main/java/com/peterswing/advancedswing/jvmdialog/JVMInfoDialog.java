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

public class JVMInfoDialog extends javax.swing.JDialog {
	private JScrollPane JScrollPane1;
	private JTable pVMTable;

	public JVMInfoDialog(JFrame frame) {
		super(frame, true);
		try {
			this.setTitle("JVM Information");
			JScrollPane1 = new JScrollPane();
			getContentPane().add(JScrollPane1, BorderLayout.CENTER);
			pVMTable = new JTable();
			JScrollPane1.setViewportView(pVMTable);
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

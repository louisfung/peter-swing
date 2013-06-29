package com.peterswing.advancedswing.jprogressbardialog;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.LayoutStyle;
import javax.swing.SwingWorker;
import javax.swing.event.EventListenerList;

import com.peterswing.CommonLib;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used commercially (ie, by a
 * corporation, company or business for any purpose whatever) then you should purchase a license for each developer using Jigloo. Please visit www.cloudgarden.com for details. Use
 * of Jigloo implies acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR ANY
 * CORPORATE OR COMMERCIAL PURPOSE.
 */
public class JProgressBarDialog extends javax.swing.JDialog {
	public JPanel jMainPanel;
	public JProgressBar jProgressBar;
	public Thread thread;
	private JPanel jPanel1;
	public JButton jCancelButton;
	private EventListenerList listenerList = new EventListenerList();

	public JProgressBarDialog(JFrame frame) {
		super(frame);
		initGUI();
	}

	public JProgressBarDialog() {
		super();
		initGUI();
	}

	public JProgressBarDialog(Dialog owner, boolean modal) {
		super(owner, modal);
		initGUI();
	}

	public JProgressBarDialog(Dialog owner, String title, boolean modal, GraphicsConfiguration gc) {
		super(owner, title, modal, gc);
		initGUI();
	}

	public JProgressBarDialog(Dialog owner, String title, boolean modal) {
		super(owner, title, modal);
		initGUI();
	}

	public JProgressBarDialog(Dialog owner, String title) {
		super(owner, title);
		initGUI();
	}

	public JProgressBarDialog(Dialog owner) {
		super(owner);
		initGUI();
	}

	public JProgressBarDialog(Frame owner, boolean modal) {
		super(owner, modal);
		initGUI();
	}

	public JProgressBarDialog(Frame owner, String title, boolean modal, GraphicsConfiguration gc) {
		super(owner, title, modal, gc);
		initGUI();
	}

	public JProgressBarDialog(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		initGUI();
	}

	public JProgressBarDialog(Frame owner, String title) {
		super(owner, title);
		initGUI();
	}

	public JProgressBarDialog(Frame owner) {
		super(owner);
		initGUI();
	}

	public JProgressBarDialog(Window owner, ModalityType modalityType) {
		super(owner, modalityType);
		initGUI();
	}

	public JProgressBarDialog(Window owner, String title, ModalityType modalityType, GraphicsConfiguration gc) {
		super(owner, title, modalityType, gc);
		initGUI();
	}

	public JProgressBarDialog(Window owner, String title, ModalityType modalityType) {
		super(owner, title, modalityType);
		initGUI();
	}

	public JProgressBarDialog(Window owner, String title) {
		super(owner, title);
		initGUI();
	}

	public JProgressBarDialog(Window owner) {
		super(owner);
		initGUI();
	}

	private void initGUI() {
		try {
			{
				jMainPanel = new JPanel();
				GroupLayout jMainPanelLayout = new GroupLayout((JComponent) jMainPanel);
				jMainPanel.setLayout(jMainPanelLayout);
				getContentPane().add(jMainPanel, BorderLayout.CENTER);
				{
					jProgressBar = new JProgressBar();
				}
				{
					jPanel1 = new JPanel();
					FlowLayout jPanel1Layout = new FlowLayout();
					jPanel1.setLayout(jPanel1Layout);
					{
						jCancelButton = new JButton();
						jPanel1.add(jCancelButton);
						jCancelButton.setText("Cancel");
						jCancelButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jCancelButtonActionPerformed(evt);
							}
						});
					}
				}
				jMainPanelLayout.setHorizontalGroup(jMainPanelLayout
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								jMainPanelLayout.createParallelGroup().addComponent(jProgressBar, GroupLayout.Alignment.LEADING, 0, 394, Short.MAX_VALUE)
										.addComponent(jPanel1, GroupLayout.Alignment.LEADING, 0, 394, Short.MAX_VALUE)).addContainerGap());
				jMainPanelLayout.setVerticalGroup(jMainPanelLayout.createSequentialGroup().addContainerGap(53, 53)
						.addComponent(jProgressBar, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE).addContainerGap(18, Short.MAX_VALUE));
			}
			this.setSize(420, 110);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonLib.centerDialog(this);
	}

	public void setVisible(boolean b) {
		try {
			if (thread != null) {
				thread.start();

				new Thread() {
					public void run() {
						try {
							thread.join();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						finished();
					}
				}.start();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		super.setVisible(b);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				thisWindowClosing(evt);
			}
		});
	}

	private void finished() {
		super.setVisible(false);
	}

	private void jCancelButtonActionPerformed(ActionEvent evt) {
		thread.stop();

		Object[] listeners = listenerList.getListenerList();
		for (int i = 0; i < listeners.length; i += 2) {
			if (listeners[i] == JProgressBarDialogEventListener.class) {
				((JProgressBarDialogEventListener) listeners[i + 1]).cancelled();
			}
		}
	}

	public void addCancelEventListener(JProgressBarDialogEventListener listener) {
		listenerList.add(JProgressBarDialogEventListener.class, listener);
	}
	
	private void thisWindowClosing(WindowEvent evt) {
		jCancelButtonActionPerformed(null);
	}

}

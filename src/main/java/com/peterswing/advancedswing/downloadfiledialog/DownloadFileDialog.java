package com.peterswing.advancedswing.downloadfiledialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

import org.apache.commons.io.IOUtils;

import com.peterswing.CommonLib;

public class DownloadFileDialog extends JDialog implements Runnable {
	private final JPanel contentPanel = new JPanel();
	public String url;
	public boolean stop;
	private JProgressBar progressBar;
	File dest;

	public DownloadFileDialog(Frame frame, String title, boolean modal, String url, File dest) {
		super(frame, title, modal);
		this.url = url;
		this.dest = dest;
		setBounds(100, 100, 371, 90);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			progressBar = new JProgressBar();
			contentPanel.add(progressBar);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void setVisible(boolean b) {
		if (b) {
			stop = false;
			new Thread(this).start();
		} else {
			stop = true;
		}
		super.setVisible(b);
	}

	@Override
	public void run() {
		progressBar.setStringPainted(true);
		progressBar.setValue(0);
		int size = CommonLib.getFileSize(url);
		if (size == -1) {
			setVisible(false);
			return;
		}
		progressBar.setMaximum(size);
		InputStream in = null;
		FileOutputStream fo = null;

		try {
			fo = new FileOutputStream(dest);
			in = new URL(url).openStream();
			byte b[] = new byte[1024];
			int len;
			while ((len = in.read(b)) != -1) {
				progressBar.setValue(progressBar.getValue() + len);
				fo.write(b);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (in != null) {
				IOUtils.closeQuietly(in);
			}
			if (fo != null) {
				IOUtils.closeQuietly(fo);
			}
		}
		setVisible(false);
	}

}

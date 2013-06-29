package com.peterswing.white;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JProgressBar;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicProgressBarUI;

public class ProgressBarUI extends BasicProgressBarUI {
	Image bg = new ImageIcon(ButtonUI.class.getResource("images/PProgressBar/bg.png")).getImage();

	public static ComponentUI createUI(JComponent c) {
		return new ProgressBarUI();
	}

	public void paintDeterminate(Graphics g, JComponent c) {
		try {
			JProgressBar jProgressBar = (JProgressBar) c;
			jProgressBar.setForeground(Color.green);
			g.drawImage(bg, 0, 0, c.getWidth() * (jProgressBar.getValue() - jProgressBar.getMinimum()) / (jProgressBar.getMaximum() - jProgressBar.getMinimum()), c.getHeight(),
					null, null);

			Insets b = progressBar.getInsets(); // area for border
			int barRectWidth = progressBar.getWidth() - (b.right + b.left);
			int barRectHeight = progressBar.getHeight() - (b.top + b.bottom);
			int amountFull = getAmountFull(b, barRectWidth * 2, barRectHeight);

			if (progressBar.isStringPainted()) {
				paintString(g, b.left, b.top, barRectWidth, barRectHeight, amountFull, b);
			}
		} catch (Exception ex) {

		}
	}

	int in_x = 0;

	public void paintIndeterminate(Graphics g, JComponent c) {
		// super.paintIndeterminate(g, c);
		try {
			JProgressBar jProgressBar = (JProgressBar) c;
			jProgressBar.setForeground(Color.green);
			// JProgressBar jProgressBar = (JProgressBar) c;
			//
			// g.drawImage(bg, 0, 0, c.getWidth() * (jProgressBar.getValue() - jProgressBar.getMinimum()) / (jProgressBar.getMaximum() - jProgressBar.getMinimum()), c.getHeight(),
			// null, null);

			g.drawImage(bg, in_x, 0, 100, c.getHeight(), null, null);
			//
			Insets b = progressBar.getInsets(); // area for border
			int barRectWidth = progressBar.getWidth() - (b.right + b.left);
			int barRectHeight = progressBar.getHeight() - (b.top + b.bottom);
			int amountFull = getAmountFull(b, barRectWidth * 2, barRectHeight);

			if (progressBar.isStringPainted()) {
				paintString(g, b.left, b.top, barRectWidth, barRectHeight, amountFull, b);
			}
		} catch (Exception ex) {

		}
	}

	public void installUI(JComponent c) {
		super.installUI(c);
		progressBar = (JProgressBar) c;
		if (progressBar.isIndeterminate()) {
			initIndeterminateValues();
		}
	}

	public void uninstallUI(JComponent c) {
		super.uninstallUI(c);
		progressBar = (JProgressBar) c;
		if (progressBar.isIndeterminate()) {
			cleanUpIndeterminateValues();
		}
		progressBar = null;
	}

	private void initIndeterminateValues() {
		if (progressBar.isDisplayable()) {
			startAnimationTimer();
		}
	}

	private void cleanUpIndeterminateValues() {
		// stop the animation thread if necessary
		if (progressBar.isDisplayable()) {
			stopAnimationTimer();
		}
	}

	public void propertyChange(PropertyChangeEvent e) {
		String prop = e.getPropertyName();
		if ("indeterminate" == prop) {
			if (progressBar.isIndeterminate()) {
				initIndeterminateValues();
			} else {
				// clean up
				cleanUpIndeterminateValues();
			}
			progressBar.repaint();
		}
	}

	Thread thread;
	boolean toggle;

	public void startAnimationTimer() {
		thread = new Thread() {
			public void run() {
				while (true) {
					if (!toggle) {
						in_x++;
					} else {
						in_x--;
					}
					progressBar.repaint();

					if (in_x >= progressBar.getWidth() - 100) {
						toggle = true;
					}
					if (in_x <= 0) {
						toggle = false;
					}

					try {
						this.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		thread.start();
	}

	public void stopAnimationTimer() {
		if (thread != null) {
			thread.stop();
		}
	}

	// public void paintIndeterminate(Graphics g, JComponent c) {
	// super.paintIndeterminate(g, c);
	//
	// if (!progressBar.isBorderPainted() || (!(g instanceof Graphics2D))) {
	// return;
	// }
	//
	// Insets b = progressBar.getInsets(); // area for border
	// int barRectWidth = progressBar.getWidth() - (b.left + b.right);
	// int barRectHeight = progressBar.getHeight() - (b.top + b.bottom);
	// int amountFull = getAmountFull(b, barRectWidth, barRectHeight);
	// boolean isLeftToRight = true; // peter
	// int startX, startY, endX, endY;
	// Rectangle box = null;
	// box = getBox(box);
	//
	// // The progress bar border is painted according to a light source.
	// // This light source is stationary and does not change when the
	// // component orientation changes.
	// startX = b.left;
	// startY = b.top;
	// endX = b.left + barRectWidth - 1;
	// endY = b.top + barRectHeight - 1;
	//
	// Graphics2D g2 = (Graphics2D) g;
	// g2.setStroke(new BasicStroke(1.f));
	//
	// if (progressBar.getOrientation() == JProgressBar.HORIZONTAL) {
	// // Draw light line lengthwise across the progress bar.
	// g2.setColor(MetalLookAndFeel.getControlShadow());
	// g2.drawLine(startX, startY, endX, startY);
	// g2.drawLine(startX, startY, startX, endY);
	//
	// // Draw darker lengthwise line over filled area.
	// g2.setColor(MetalLookAndFeel.getPrimaryControlDarkShadow());
	// g2.drawLine(box.x, startY, box.x + box.width - 1, startY);
	//
	// } else { // VERTICAL
	// // Draw light line lengthwise across the progress bar.
	// g2.setColor(MetalLookAndFeel.getControlShadow());
	// g2.drawLine(startX, startY, startX, endY);
	// g2.drawLine(startX, startY, endX, startY);
	//
	// // Draw darker lengthwise line over filled area.
	// g2.setColor(MetalLookAndFeel.getPrimaryControlDarkShadow());
	// g2.drawLine(startX, box.y, startX, box.y + box.height - 1);
	// }
	// }

}

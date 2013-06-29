package com.peterswing.white;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JToolTip;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicHTML;
import javax.swing.plaf.basic.BasicToolTipUI;
import javax.swing.text.View;

import sun.swing.SwingUtilities2;

public class PeterToolTipUI extends BasicToolTipUI {
	static PeterToolTipUI sharedInstance = new PeterToolTipUI();
	private Font smallFont;
	private JToolTip tip;
	public static final int padSpaceBetweenStrings = 12;
	private String acceleratorDelimiter;

	Image topLeft = new ImageIcon(PeterToolTipUI.class.getResource("images/ToolTip/blue/topLeft.png")).getImage();
	Image topMiddle = new ImageIcon(PeterToolTipUI.class.getResource("images/ToolTip/blue/topMiddle.png")).getImage();
	Image topRight = new ImageIcon(PeterToolTipUI.class.getResource("images/ToolTip/blue/topRight.png")).getImage();
	Image middleLeft = new ImageIcon(PeterToolTipUI.class.getResource("images/ToolTip/blue/middleLeft.png")).getImage();
	Image center = new ImageIcon(PeterToolTipUI.class.getResource("images/ToolTip/blue/center.png")).getImage();
	Image middleRight = new ImageIcon(PeterToolTipUI.class.getResource("images/ToolTip/blue/middleRight.png")).getImage();
	Image bottomLeft = new ImageIcon(PeterToolTipUI.class.getResource("images/ToolTip/blue/bottomLeft.png")).getImage();
	Image bottomMiddle = new ImageIcon(PeterToolTipUI.class.getResource("images/ToolTip/blue/bottomMiddle.png")).getImage();
	Image bottomRight = new ImageIcon(PeterToolTipUI.class.getResource("images/ToolTip/blue/bottomRight.png")).getImage();

	public PeterToolTipUI() {
		super();
	}

	public static ComponentUI createUI(JComponent c) {
		return sharedInstance;
	}

	public void installUI(JComponent c) {
		super.installUI(c);
		tip = (JToolTip) c;
		Font f = c.getFont();
		smallFont = new Font(f.getName(), f.getStyle(), f.getSize() - 2);
		acceleratorDelimiter = UIManager.getString("MenuItem.acceleratorDelimiter");
		if (acceleratorDelimiter == null) {
			acceleratorDelimiter = "-";
		}
	}

	public void uninstallUI(JComponent c) {
		super.uninstallUI(c);
		tip = null;
	}

	public void paint(Graphics g, JComponent c) {
		JToolTip tip = (JToolTip) c;
		Font font = c.getFont();
		FontMetrics metrics = SwingUtilities2.getFontMetrics(c, g, font);
		Dimension size = c.getSize();

		g.drawImage(topLeft, 0, 0, null);
		g.drawImage(middleLeft, 0, topLeft.getHeight(null), middleLeft.getWidth(null), (int) size.getHeight() - topLeft.getHeight(null) - bottomLeft.getHeight(null), null);
		g.drawImage(bottomLeft, 0, (int) size.getHeight() - bottomLeft.getHeight(null), null);

		g.drawImage(center, topLeft.getWidth(null), topLeft.getHeight(null), (int) size.getWidth() - topLeft.getWidth(null) - topRight.getWidth(null), (int) size.getHeight()
				- -topLeft.getHeight(null) - bottomLeft.getHeight(null), null);

		g.drawImage(topMiddle, topLeft.getWidth(null), 0, (int) size.getWidth() - topLeft.getWidth(null) - topRight.getWidth(null), topMiddle.getHeight(null), null);
		g.drawImage(bottomMiddle, bottomLeft.getWidth(null), (int) size.getHeight() - bottomMiddle.getHeight(null), (int) size.getWidth() - -bottomLeft.getWidth(null)
				- bottomRight.getWidth(null), bottomMiddle.getHeight(null), null);

		g.drawImage(topRight, (int) size.getWidth() - topRight.getWidth(null), 0, null);
		g.drawImage(middleRight, (int) size.getWidth() - middleRight.getWidth(null), topRight.getHeight(null), middleRight.getWidth(null),
				(int) size.getHeight() - topRight.getHeight(null) - bottomRight.getHeight(null), null);
		g.drawImage(bottomRight, (int) size.getWidth() - bottomRight.getWidth(null), (int) size.getHeight() - bottomRight.getHeight(null), null);
		int accelBL;

		g.setColor(c.getForeground());
		String tipText = tip.getTipText();
		if (tipText == null) {
			tipText = "";
		}

		String accelString = getAcceleratorString(tip);
		FontMetrics accelMetrics = SwingUtilities2.getFontMetrics(c, g, smallFont);
		int accelSpacing = calcAccelSpacing(c, accelMetrics, accelString);

		Insets insets = tip.getInsets();
		Rectangle paintTextR = new Rectangle(insets.left + 3, insets.top, size.width - (insets.left + insets.right) - 6 - accelSpacing, size.height - (insets.top + insets.bottom));
		View v = (View) c.getClientProperty(BasicHTML.propertyKey);
		if (v != null) {
			v.paint(g, paintTextR);
			accelBL = BasicHTML.getHTMLBaseline(v, paintTextR.width, paintTextR.height);
		} else {
			g.setFont(font);
			SwingUtilities2.drawString(tip, g, tipText, paintTextR.x, paintTextR.y + metrics.getAscent());
			accelBL = metrics.getAscent();
		}

		if (!accelString.equals("")) {
			g.setFont(smallFont);
			g.setColor(Color.pink);
			SwingUtilities2.drawString(tip, g, accelString, tip.getWidth() - 1 - insets.right - accelSpacing + padSpaceBetweenStrings - 3, paintTextR.y + accelBL);
		}

	}

	private int calcAccelSpacing(JComponent c, FontMetrics fm, String accel) {
		return accel.equals("") ? 0 : padSpaceBetweenStrings + SwingUtilities2.stringWidth(c, fm, accel);
	}

	public Dimension getPreferredSize(JComponent c) {
		Dimension d = super.getPreferredSize(c);

		String key = getAcceleratorString((JToolTip) c);
		if (!(key.equals(""))) {
			d.width += calcAccelSpacing(c, c.getFontMetrics(smallFont), key);
		}
		return d;
	}

	protected boolean isAcceleratorHidden() {
		Boolean b = (Boolean) UIManager.get("ToolTip.hideAccelerator");
		return b != null && b.booleanValue();
	}

	private String getAcceleratorString(JToolTip tip) {
		this.tip = tip;

		String retValue = getAcceleratorString();

		this.tip = null;
		return retValue;
	}

	// NOTE: This requires the tip field to be set before this is invoked.
	// As PeterToolTipUI is shared between all JToolTips the tip field is
	// set appropriately before this is invoked. Unfortunately this means
	// that subclasses that randomly invoke this method will see varying
	// results. If this becomes an issue, PeterToolTipUI should no longer be
	// shared.
	public String getAcceleratorString() {
		if (tip == null || isAcceleratorHidden()) {
			return "";
		}
		JComponent comp = tip.getComponent();
		if (!(comp instanceof AbstractButton)) {
			return "";
		}

		KeyStroke[] keys = comp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).keys();
		if (keys == null) {
			return "";
		}

		String controlKeyStr = "";

		for (int i = 0; i < keys.length; i++) {
			int mod = keys[i].getModifiers();
			controlKeyStr = KeyEvent.getKeyModifiersText(mod) + acceleratorDelimiter + KeyEvent.getKeyText(keys[i].getKeyCode());
			break;
		}

		return controlKeyStr;
	}
}

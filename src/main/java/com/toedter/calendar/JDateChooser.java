package com.toedter.calendar;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.MenuElement;
import javax.swing.MenuSelectionManager;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JDateChooser extends JPanel implements ActionListener, PropertyChangeListener {
	private static final long serialVersionUID = -4306412745720670722L;
	protected IDateEditor dateEditor;
	protected JButton calendarButton;
	protected JCalendar jcalendar;
	protected JPopupMenu popup;
	protected boolean isInitialized;
	protected boolean dateSelected;
	protected Date lastSelectedDate;
	private ChangeListener changeListener;

	public JDateChooser() {
		this(null, null, null, null);
	}

	public JDateChooser(IDateEditor dateEditor) {
		this(null, null, null, dateEditor);
	}

	public JDateChooser(Date date) {
		this(date, null);
	}

	public JDateChooser(Date date, String dateFormatString) {
		this(date, dateFormatString, null);
	}

	public JDateChooser(Date date, String dateFormatString, IDateEditor dateEditor) {
		this(null, date, dateFormatString, dateEditor);
	}

	public JDateChooser(String datePattern, String maskPattern, char placeholder) {
		this(null, null, datePattern, new JTextFieldDateEditor(datePattern, maskPattern, placeholder));
	}

	public JDateChooser(JCalendar jcal, Date date, String dateFormatString, IDateEditor dateEditor) {
		setName("JDateChooser");

		this.dateEditor = dateEditor;
		if (this.dateEditor == null) {
			this.dateEditor = new JTextFieldDateEditor();
		}
		this.dateEditor.addPropertyChangeListener("date", this);

		if (jcal == null) {
			jcalendar = new JCalendar(date);
		} else {
			jcalendar = jcal;
			if (date != null) {
				jcalendar.setDate(date);
			}
		}

		setLayout(new BorderLayout());

		jcalendar.getDayChooser().addPropertyChangeListener("day", this);
		// always fire"day" property even if the user selects
		// the already selected day again
		jcalendar.getDayChooser().setAlwaysFireDayProperty(true);

		setDateFormatString(dateFormatString);
		setDate(date);

		// Display a calendar button with an icon
		URL iconURL = getClass().getResource("/com/toedter/calendar/images/JDateChooserIcon.gif");
		ImageIcon icon = new ImageIcon(iconURL);

		calendarButton = new JButton(icon) {
			private static final long serialVersionUID = -1913767779079949668L;

			public boolean isFocusable() {
				return false;
			}
		};
		calendarButton.setMargin(new Insets(0, 0, 0, 0));
		calendarButton.addActionListener(this);

		// Alt + 'C' selects the calendar.
		calendarButton.setMnemonic(KeyEvent.VK_C);

		add(calendarButton, BorderLayout.EAST);
		add(this.dateEditor.getUiComponent(), BorderLayout.CENTER);

		calendarButton.setMargin(new Insets(0, 0, 0, 0));
		// calendarButton.addFocusListener(this);

		popup = new JPopupMenu() {
			private static final long serialVersionUID = -6078272560337577761L;

			public void setVisible(boolean b) {
				Boolean isCanceled = (Boolean) getClientProperty("JPopupMenu.firePopupMenuCanceled");
				if (b || (!b && dateSelected) || ((isCanceled != null) && !b && isCanceled.booleanValue())) {
					super.setVisible(b);
				}
			}
		};

		popup.setLightWeightPopupEnabled(true);

		popup.add(jcalendar);

		lastSelectedDate = date;

		// Corrects a problem that occurred when the JMonthChooser's combobox is
		// displayed, and a click outside the popup does not close it.

		// The following idea was originally provided by forum user
		// podiatanapraia:
		changeListener = new ChangeListener() {
			boolean hasListened = false;

			public void stateChanged(ChangeEvent e) {
				if (hasListened) {
					hasListened = false;
					return;
				}
				if (popup.isVisible() && JDateChooser.this.jcalendar.monthChooser.getComboBox().hasFocus()) {
					MenuElement[] me = MenuSelectionManager.defaultManager().getSelectedPath();
					MenuElement[] newMe = new MenuElement[me.length + 1];
					newMe[0] = popup;
					for (int i = 0; i < me.length; i++) {
						newMe[i + 1] = me[i];
					}
					hasListened = true;
					MenuSelectionManager.defaultManager().setSelectedPath(newMe);
				}
			}
		};
		MenuSelectionManager.defaultManager().addChangeListener(changeListener);
		// end of code provided by forum user podiatanapraia

		isInitialized = true;
	}

	public void actionPerformed(ActionEvent e) {
		int x = calendarButton.getWidth() - (int) popup.getPreferredSize().getWidth();
		int y = calendarButton.getY() + calendarButton.getHeight();

		Calendar calendar = Calendar.getInstance();
		Date date = dateEditor.getDate();
		if (date != null) {
			calendar.setTime(date);
		}
		jcalendar.setCalendar(calendar);
		popup.show(calendarButton, x, y);
		dateSelected = false;
	}

	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("day")) {
			if (popup.isVisible()) {
				dateSelected = true;
				popup.setVisible(false);
				if (((Integer) evt.getNewValue()).intValue() > 0) {
					setDate(jcalendar.getCalendar().getTime());
				} else {
					setDate(null);
				}
			}
		} else if (evt.getPropertyName().equals("date")) {
			if (evt.getSource() == dateEditor) {
				firePropertyChange("date", evt.getOldValue(), evt.getNewValue());
			} else {
				setDate((Date) evt.getNewValue());
			}
		}
	}

	public void updateUI() {
		super.updateUI();
		setEnabled(isEnabled());

		if (jcalendar != null) {
			SwingUtilities.updateComponentTreeUI(popup);
		}
	}

	public void setLocale(Locale l) {
		super.setLocale(l);
		dateEditor.setLocale(l);
		jcalendar.setLocale(l);
	}

	public String getDateFormatString() {
		return dateEditor.getDateFormatString();
	}

	public void setDateFormatString(String dfString) {
		dateEditor.setDateFormatString(dfString);
		invalidate();
	}

	public Date getDate() {
		return dateEditor.getDate();
	}

	public void setDate(Date date) {
		dateEditor.setDate(date);
		if (getParent() != null) {
			getParent().invalidate();
		}
	}

	public Calendar getCalendar() {
		Date date = getDate();
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		if (calendar == null) {
			dateEditor.setDate(null);
		} else {
			dateEditor.setDate(calendar.getTime());
		}
	}

	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		if (dateEditor != null) {
			dateEditor.setEnabled(enabled);
			calendarButton.setEnabled(enabled);
		}
	}

	public boolean isEnabled() {
		return super.isEnabled();
	}

	public void setIcon(ImageIcon icon) {
		calendarButton.setIcon(icon);
	}

	public void setFont(Font font) {
		if (isInitialized) {
			dateEditor.getUiComponent().setFont(font);
			jcalendar.setFont(font);
		}
		super.setFont(font);
	}

	public JCalendar getJCalendar() {
		return jcalendar;
	}

	public JButton getCalendarButton() {
		return calendarButton;
	}

	public IDateEditor getDateEditor() {
		return dateEditor;
	}

	public void setSelectableDateRange(Date min, Date max) {
		jcalendar.setSelectableDateRange(min, max);
		dateEditor.setSelectableDateRange(jcalendar.getMinSelectableDate(), jcalendar.getMaxSelectableDate());
	}

	public void setMaxSelectableDate(Date max) {
		jcalendar.setMaxSelectableDate(max);
		dateEditor.setMaxSelectableDate(max);
	}

	public void setMinSelectableDate(Date min) {
		jcalendar.setMinSelectableDate(min);
		dateEditor.setMinSelectableDate(min);
	}

	public Date getMaxSelectableDate() {
		return jcalendar.getMaxSelectableDate();
	}

	public Date getMinSelectableDate() {
		return jcalendar.getMinSelectableDate();
	}

	public void cleanup() {
		MenuSelectionManager.defaultManager().removeChangeListener(changeListener);
		changeListener = null;
	}

	public boolean requestFocusInWindow() {
		if (dateEditor instanceof JComponent) {
			return ((JComponent) dateEditor).requestFocusInWindow();
		}
		return super.requestFocusInWindow();
	}

	public static void main(String[] s) {
		JFrame frame = new JFrame("JDateChooser");
		JDateChooser dateChooser = new JDateChooser();
		frame.getContentPane().add(dateChooser);
		frame.pack();
		frame.setVisible(true);
		dateChooser.requestFocusInWindow();
	}
}

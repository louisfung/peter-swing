package com.toedter.calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.toedter.components.UTF8ResourceBundle;

@SuppressWarnings("serial")
public class JCalendar extends JPanel implements PropertyChangeListener {
	private Calendar calendar;
	private boolean initialized = false;
	private final JPanel monthYearPanel;
	private final JPanel specialButtonPanel;
	private boolean isTodayButtonVisible;
	private boolean isNullDateButtonVisible;
	private final String defaultTodayButtonText = "Today";
	private final String defaultNullDateButtonText = "No Date";
	private String todayButtonText;
	private String nullDateButtonText;
	protected JDayChooser dayChooser;
	protected boolean weekOfYearVisible = true;
	protected Locale locale;
	protected JMonthChooser monthChooser;
	protected JYearChooser yearChooser;
	private final JButton todayButton;
	private final JButton nullDateButton;

	public JCalendar() {
		this(null, null, true, true);
	}

	public JCalendar(Date date) {
		this(date, null, true, true);
	}

	public JCalendar(Calendar calendar) {
		this(null, null, true, true);
		setCalendar(calendar);
	}

	public JCalendar(Locale locale) {
		this(null, locale, true, true);
	}

	public JCalendar(Date date, Locale locale) {
		this(date, locale, true, true);
	}

	public JCalendar(Date date, boolean monthSpinner) {
		this(date, null, monthSpinner, true);
	}

	public JCalendar(Locale locale, boolean monthSpinner) {
		this(null, locale, monthSpinner, true);
	}

	public JCalendar(boolean monthSpinner) {
		this(null, null, monthSpinner, true);
	}

	public JCalendar(Date date, Locale locale, boolean monthSpinner, boolean weekOfYearVisible) {
		setName("JCalendar");
		dayChooser = null;
		monthChooser = null;
		yearChooser = null;
		this.weekOfYearVisible = weekOfYearVisible;

		if (locale == null) {
			this.locale = Locale.getDefault();
		} else {
			this.locale = locale;
		}

		calendar = Calendar.getInstance(this.locale);

		setLayout(new BorderLayout());

		monthYearPanel = new JPanel();
		monthYearPanel.setLayout(new BorderLayout());

		monthChooser = new JMonthChooser(monthSpinner);
		yearChooser = new JYearChooser();
		monthChooser.setYearChooser(yearChooser);
		monthChooser.setLocale(this.locale);
		monthYearPanel.add(monthChooser, BorderLayout.WEST);
		monthYearPanel.add(yearChooser, BorderLayout.CENTER);
		monthYearPanel.setBorder(BorderFactory.createEmptyBorder());

		dayChooser = new JDayChooser(weekOfYearVisible);
		dayChooser.addPropertyChangeListener(this);
		dayChooser.setLocale(this.locale);

		monthChooser.setDayChooser(dayChooser);
		monthChooser.addPropertyChangeListener(this);
		yearChooser.setDayChooser(dayChooser);
		yearChooser.addPropertyChangeListener(this);
		add(monthYearPanel, BorderLayout.NORTH);
		add(dayChooser, BorderLayout.CENTER);

		specialButtonPanel = new JPanel();
		todayButton = new JButton();
		todayButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setDate(new Date());
			}
		});
		nullDateButton = new JButton();
		nullDateButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dayChooser.firePropertyChange("day", 0, -1);
			}
		});
		specialButtonPanel.setVisible(false);
		add(specialButtonPanel, BorderLayout.SOUTH);

		// Set the initialized flag before setting the calendar. This will
		// cause the other components to be updated properly.
		if (date != null) {
			calendar.setTime(date);
		}

		initialized = true;

		setCalendar(calendar);
	}

	public static void main(String[] s) {
		JFrame frame = new JFrame("JCalendar");

		JCalendar jcalendar = new JCalendar();
		frame.getContentPane().add(jcalendar);
		frame.pack();
		frame.setVisible(true);
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public JDayChooser getDayChooser() {
		return dayChooser;
	}

	public Locale getLocale() {
		return locale;
	}

	public JMonthChooser getMonthChooser() {
		return monthChooser;
	}

	public JYearChooser getYearChooser() {
		return yearChooser;
	}

	public boolean isWeekOfYearVisible() {
		return dayChooser.isWeekOfYearVisible();
	}

	public void propertyChange(PropertyChangeEvent evt) {
		if (calendar != null) {
			Calendar c = (Calendar) calendar.clone();

			if (evt.getPropertyName().equals("day")) {
				c.set(Calendar.DAY_OF_MONTH, ((Integer) evt.getNewValue()).intValue());
				setCalendar(c, false);
			} else if (evt.getPropertyName().equals("month")) {
				c.set(Calendar.MONTH, ((Integer) evt.getNewValue()).intValue());
				setCalendar(c, false);
			} else if (evt.getPropertyName().equals("year")) {
				c.set(Calendar.YEAR, ((Integer) evt.getNewValue()).intValue());
				setCalendar(c, false);
			} else if (evt.getPropertyName().equals("date")) {
				c.setTime((Date) evt.getNewValue());
				setCalendar(c, true);
			}
		}
	}

	/**
	 * Sets the background color.
	 * 
	 * @param bg
	 *            the new background
	 */
	public void setBackground(Color bg) {
		super.setBackground(bg);

		if (dayChooser != null) {
			dayChooser.setBackground(bg);
		}
	}

	/**
	 * Sets the calendar property. This is a bound property.
	 * 
	 * @param c
	 *            the new calendar
	 * @throws NullPointerException
	 *             - if c is null;
	 * @see #getCalendar
	 */
	public void setCalendar(Calendar c) {
		setCalendar(c, true);
	}

	/**
	 * Sets the calendar attribute of the JCalendar object
	 * 
	 * @param c
	 *            the new calendar value
	 * @param update
	 *            the new calendar value
	 * @throws NullPointerException
	 *             - if c is null;
	 */
	private void setCalendar(Calendar c, boolean update) {
		if (c == null) {
			setDate(null);
		}
		Calendar oldCalendar = calendar;
		calendar = c;

		if (update) {
			// Thanks to Jeff Ulmer for correcting a bug in the sequence :)
			yearChooser.setYear(c.get(Calendar.YEAR));
			monthChooser.setMonth(c.get(Calendar.MONTH));
			dayChooser.setDay(c.get(Calendar.DATE));
		}

		firePropertyChange("calendar", oldCalendar, calendar);
	}

	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);

		if (dayChooser != null) {
			dayChooser.setEnabled(enabled);
			monthChooser.setEnabled(enabled);
			yearChooser.setEnabled(enabled);
		}
	}

	public boolean isEnabled() {
		return super.isEnabled();
	}

	public void setFont(Font font) {
		super.setFont(font);

		if (dayChooser != null) {
			dayChooser.setFont(font);
			monthChooser.setFont(font);
			yearChooser.setFont(font);
		}
	}

	public void setForeground(Color fg) {
		super.setForeground(fg);

		if (dayChooser != null) {
			dayChooser.setForeground(fg);
			monthChooser.setForeground(fg);
			yearChooser.setForeground(fg);
		}
	}

	public void setLocale(Locale l) {
		if (!initialized) {
			super.setLocale(l);
		} else {
			Locale oldLocale = locale;
			locale = l;
			dayChooser.setLocale(locale);
			monthChooser.setLocale(locale);
			relayoutSpecialButtonPanel();
			firePropertyChange("locale", oldLocale, locale);
		}
	}

	public void setWeekOfYearVisible(boolean weekOfYearVisible) {
		dayChooser.setWeekOfYearVisible(weekOfYearVisible);
		setLocale(locale); // hack for doing complete new layout :)
	}

	public boolean isDecorationBackgroundVisible() {
		return dayChooser.isDecorationBackgroundVisible();
	}

	public void setDecorationBackgroundVisible(boolean decorationBackgroundVisible) {
		dayChooser.setDecorationBackgroundVisible(decorationBackgroundVisible);
		setLocale(locale); // hack for doing complete new layout :)
	}

	public boolean isDecorationBordersVisible() {
		return dayChooser.isDecorationBordersVisible();
	}

	public void setDecorationBordersVisible(boolean decorationBordersVisible) {
		dayChooser.setDecorationBordersVisible(decorationBordersVisible);
		setLocale(locale); // hack for doing complete new layout :)
	}

	public Color getDecorationBackgroundColor() {
		return dayChooser.getDecorationBackgroundColor();
	}

	public void setDecorationBackgroundColor(Color decorationBackgroundColor) {
		dayChooser.setDecorationBackgroundColor(decorationBackgroundColor);
	}

	public Color getSundayForeground() {
		return dayChooser.getSundayForeground();
	}

	public Color getWeekdayForeground() {
		return dayChooser.getWeekdayForeground();
	}

	public void setSundayForeground(Color sundayForeground) {
		dayChooser.setSundayForeground(sundayForeground);
	}

	public void setWeekdayForeground(Color weekdayForeground) {
		dayChooser.setWeekdayForeground(weekdayForeground);
	}

	public Date getDate() {
		return new Date(calendar.getTimeInMillis());
	}

	public void setDate(Date date) {
		Date oldDate = calendar.getTime();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);

		yearChooser.setYear(year);
		monthChooser.setMonth(month);
		dayChooser.setCalendar(calendar);
		dayChooser.setDay(day);

		firePropertyChange("date", oldDate, date);
	}

	public void setSelectableDateRange(Date min, Date max) {
		dayChooser.setSelectableDateRange(min, max);
	};

	public Date getMaxSelectableDate() {
		return dayChooser.getMaxSelectableDate();
	}

	public Date getMinSelectableDate() {
		return dayChooser.getMinSelectableDate();
	}

	public void setMaxSelectableDate(Date max) {
		dayChooser.setMaxSelectableDate(max);
	}

	public void setMinSelectableDate(Date min) {
		dayChooser.setMinSelectableDate(min);
	}

	public int getMaxDayCharacters() {
		return dayChooser.getMaxDayCharacters();
	}

	public void setMaxDayCharacters(int maxDayCharacters) {
		dayChooser.setMaxDayCharacters(maxDayCharacters);
	}

	public void setTodayButtonVisible(boolean isTodayButtonVisible) {
		this.isTodayButtonVisible = isTodayButtonVisible;
		relayoutSpecialButtonPanel();
	}

	public boolean isTodayButtonVisible() {
		return isTodayButtonVisible;
	}

	public void setNullDateButtonVisible(boolean isNullDateButtonVisible) {
		this.isNullDateButtonVisible = isNullDateButtonVisible;
		relayoutSpecialButtonPanel();
	}

	public boolean isNullDateButtonVisible() {
		return isNullDateButtonVisible;
	}

	private void relayoutSpecialButtonPanel() {
		ResourceBundle resourceBundle = null;

		try {
			resourceBundle = UTF8ResourceBundle.getBundle("com.toedter.calendar.jcalendar", locale);
		} catch (Exception e) {
			// ignore, fall back to set texts or defaults
			System.out.println(e.getMessage());
		}

		specialButtonPanel.removeAll();
		int buttonCount = 0;
		if (isTodayButtonVisible) {
			String text = todayButtonText;
			if (text == null && resourceBundle != null) {
				try {
					text = resourceBundle.getString("todayButton.text");
				} catch (Exception e) {
					// ignore, fall back to set texts or defaults
				}
			}
			if (text == null) {
				text = defaultTodayButtonText;
			}
			todayButton.setText(text);
			specialButtonPanel.add(todayButton);
			buttonCount++;
		}
		if (isNullDateButtonVisible) {
			String text = nullDateButtonText;
			if (text == null && resourceBundle != null) {
				try {
					text = resourceBundle.getString("nullDateButton.text");
				} catch (Exception e) {
					// ignore, fall back to set texts or defaults
				}
			}
			if (text == null) {
				text = defaultNullDateButtonText;
			}
			nullDateButton.setText(text);
			specialButtonPanel.add(nullDateButton);
			buttonCount++;
		}

		specialButtonPanel.setLayout(new GridLayout(1, buttonCount));
		if (isTodayButtonVisible) {
			specialButtonPanel.add(todayButton);
		}
		if (isNullDateButtonVisible) {
			specialButtonPanel.add(nullDateButton);
		}

		specialButtonPanel.setVisible(isNullDateButtonVisible || isTodayButtonVisible);

		todayButton.invalidate();
		todayButton.repaint();
		nullDateButton.invalidate();
		nullDateButton.repaint();
		specialButtonPanel.invalidate();
		specialButtonPanel.doLayout();
		specialButtonPanel.repaint();
		invalidate();
		repaint();
	}

	public String getTodayButtonText() {
		return todayButtonText;
	}

	public void setTodayButtonText(String todayButtonText) {
		if (todayButtonText != null & todayButtonText.trim().length() == 0) {
			this.todayButtonText = null;
		} else {
			this.todayButtonText = todayButtonText;
		}
		relayoutSpecialButtonPanel();
	}

	public String getNullDateButtonText() {
		return nullDateButtonText;
	}

	public void setNullDateButtonText(String nullDateButtonText) {
		if (nullDateButtonText != null & nullDateButtonText.trim().length() == 0) {
			this.nullDateButtonText = null;
		} else {
			this.nullDateButtonText = nullDateButtonText;
		}
		relayoutSpecialButtonPanel();
	}
}

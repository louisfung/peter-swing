package com.toedter.calendar;

import java.beans.PropertyChangeListener;
import java.util.Date;
import java.util.Locale;

import javax.swing.JComponent;

public interface IDateEditor {
	public Date getDate();

	public void setDate(Date date);

	public void setDateFormatString(String dateFormatString);

	public String getDateFormatString();

	public void setSelectableDateRange(Date min, Date max);

	public Date getMaxSelectableDate();

	public Date getMinSelectableDate();

	public void setMaxSelectableDate(Date max);

	public void setMinSelectableDate(Date min);

	public JComponent getUiComponent();

	public void setLocale(Locale locale);

	public void setEnabled(boolean enabled);

	public void addPropertyChangeListener(PropertyChangeListener listener);

	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener);

	public void removePropertyChangeListener(PropertyChangeListener listener);

	public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener);
}

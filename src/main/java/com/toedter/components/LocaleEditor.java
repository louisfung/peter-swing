package com.toedter.components;

import java.util.Calendar;
import java.util.Locale;

public class LocaleEditor extends java.beans.PropertyEditorSupport {
	private Locale[] locales;
	private String[] localeStrings;
	private Locale locale;
	private int length;

	public LocaleEditor() {
		locale = Locale.getDefault();
		locales = Calendar.getAvailableLocales();
		length = locales.length;
		localeStrings = new String[length];
	}

	public String[] getTags() {
		for (int i = 0; i < length; i++)
			localeStrings[i] = locales[i].getDisplayName();

		return localeStrings;
	}

	public void setAsText(String text) throws IllegalArgumentException {
		for (int i = 0; i < length; i++)
			if (text.equals(locales[i].getDisplayName())) {
				locale = locales[i];
				setValue(locale);

				break;
			}
	}

	public String getAsText() {
		return locale.getDisplayName();
	}
}
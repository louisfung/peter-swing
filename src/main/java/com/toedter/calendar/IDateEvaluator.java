package com.toedter.calendar;

import java.awt.Color;
import java.util.Date;

public interface IDateEvaluator {
	boolean isSpecial(Date date);

	Color getSpecialForegroundColor();

	Color getSpecialBackroundColor();

	String getSpecialTooltip();

	boolean isInvalid(Date date);

	Color getInvalidForegroundColor();

	Color getInvalidBackroundColor();

	String getInvalidTooltip();
}

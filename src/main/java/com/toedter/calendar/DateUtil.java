package com.toedter.calendar;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	protected Date minSelectableDate;

	protected Date maxSelectableDate;

	protected Date defaultMinSelectableDate;

	protected Date defaultMaxSelectableDate;

	public DateUtil() {
		Calendar tmpCalendar = Calendar.getInstance();
		tmpCalendar.set(1, 0, 1, 1, 1);
		defaultMinSelectableDate = tmpCalendar.getTime();
		minSelectableDate = defaultMinSelectableDate;
		tmpCalendar.set(9999, 0, 1, 1, 1);
		defaultMaxSelectableDate = tmpCalendar.getTime();
		maxSelectableDate = defaultMaxSelectableDate;
	}

	public void setSelectableDateRange(Date min, Date max) {
		if (min == null) {
			minSelectableDate = defaultMinSelectableDate;
		} else {
			minSelectableDate = min;
		}
		if (max == null) {
			maxSelectableDate = defaultMaxSelectableDate;
		} else {
			maxSelectableDate = max;
		}
		if (maxSelectableDate.before(minSelectableDate)) {
			minSelectableDate = defaultMinSelectableDate;
			maxSelectableDate = defaultMaxSelectableDate;
		}
	}

	public Date setMaxSelectableDate(Date max) {
		if (max == null) {
			maxSelectableDate = defaultMaxSelectableDate;
		} else {
			maxSelectableDate = max;
		}
		return maxSelectableDate;
	}

	public Date setMinSelectableDate(Date min) {
		if (min == null) {
			minSelectableDate = defaultMinSelectableDate;
		} else {
			minSelectableDate = min;
		}
		return minSelectableDate;
	}

	public Date getMaxSelectableDate() {
		return maxSelectableDate;
	}

	public Date getMinSelectableDate() {
		return minSelectableDate;
	}

	public boolean checkDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		Calendar minCal = Calendar.getInstance();
		minCal.setTime(minSelectableDate);
		minCal.set(Calendar.HOUR_OF_DAY, 0);
		minCal.set(Calendar.MINUTE, 0);
		minCal.set(Calendar.SECOND, 0);
		minCal.set(Calendar.MILLISECOND, 0);

		Calendar maxCal = Calendar.getInstance();
		maxCal.setTime(maxSelectableDate);
		maxCal.set(Calendar.HOUR_OF_DAY, 0);
		maxCal.set(Calendar.MINUTE, 0);
		maxCal.set(Calendar.SECOND, 0);
		maxCal.set(Calendar.MILLISECOND, 0);

		return !(calendar.before(minCal) || calendar.after(maxCal));
	}
}

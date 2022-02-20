package com.made.by.kasih.madebykasih.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static SimpleDateFormat stringMonthOnlyFormat = new SimpleDateFormat("MM");
	private static SimpleDateFormat yearOnlyFormat = new SimpleDateFormat("yyyy");
	
	/*convert from Date to String, format: MM*/
	public static final String dateToStringMonthOnlyFormat(Date date) {
		return date==null ? null : stringMonthOnlyFormat.format(date);
	}
	
	/*convert from Date to String, format: YYYY*/
	public static final String dateToYearOnlyFormat(Date date) {
		return date==null ? null : yearOnlyFormat.format(date);
	}
}
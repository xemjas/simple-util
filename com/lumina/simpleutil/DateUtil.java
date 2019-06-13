package com.lumina.simpleutil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author Xemjas
 *
 */
public class DateUtil {
	
	/**
	 * e.g. 02-Apr-1994
	 * @param ldt - LocalDateTime
	 */
	public static String formatToDdDashMmmDashYyyy(LocalDateTime ldt) {
		return formatDate("dd-MMM-yyyy", ldt, null);
	}
	
	/**
	 * e.g. 02-Apr-1994
	 * @param ldt - LocalDateTime,
	 * 			locale - Locale
	 */
	public static String formatToDdDashMmmDashYyyy(LocalDateTime ldt, Locale locale) {
		return formatDate("dd-MMM-yyyy", ldt, locale);
	}
	
	/**
	 * e.g. 02-02-1994
	 * @param ldt - LocalDateTime
	 */
	public static String formatToDdDashMmDashYyyy(LocalDateTime ldt) {
		return formatDate("dd-MM-yyyy", ldt, null);
	}
	
	/**
	 * e.g. 02-02-1994
	 * @param ldt - LocalDateTime,
	 * 			locale - Locale
	 */
	public static String formatToDdDashMmDashYyyy(LocalDateTime ldt, Locale locale) {
		return formatDate("dd-MM-yyyy", ldt, locale);
	}
	
	/**
	 * e.g. 02041994
	 * @param ldt - LocalDateTime,
	 */
	public static String formatToDdMmYyyy(LocalDateTime ldt) {
		return formatDate("ddMMyyyy", ldt, null);
	}
	
	/**
	 * e.g. 02041994
	 * @param ldt - LocalDateTime,
	 * 			locale - Locale
	 */
	public static String formatToDdMmYyyy(LocalDateTime ldt, Locale locale) {
		return formatDate("ddMMyyyy", ldt, locale);
	}
	
	/**
	 * e.g. 20190402
	 * @param ldt - LocalDateTime,
	 */
	public static String formatToYyyyMmDd(LocalDateTime ldt) {
		return formatDate("yyyyMMdd", ldt, null);
	}
	
	/**
	 * e.g. 20190204
	 * @param ldt - LocalDateTime,
	 * 			locale - Locale
	 */
	public static String formatToYyyyMmDd(LocalDateTime ldt, Locale locale) {
		return formatDate("yyyyMMdd", ldt, locale);
	}
	
	/**
	 * e.g. 02-Apr-1994, 00:01
	 * @param ldt - LocalDateTime,
	 */
	public static String formatToDdDashMmmDashYyyyCommaSpaceHhColonMm(LocalDateTime ldt) {
		return formatDate("dd-MMM-yyyy, HH:mm", ldt, null);
	}
	
	/**
	 * e.g. 02-Apr-1994, 00:01
	 * @param ldt - LocalDateTime,
	 * 			locale - Locale
	 */
	public static String formatToDdDashMmmDashYyyyCommaSpaceHhColonMm(LocalDateTime ldt, Locale locale) {
		return formatDate("dd-MMM-yyyy, HH:mm", ldt, locale);
	}
	
	/**
	 * e.g. 02 Apr 1994, 00:01
	 * @param ldt - LocalDateTime,
	 */
	public static String formatToDdSpaceMmmSpaceYyyyCommaSpaceHhColonMm(LocalDateTime ldt) {
		return formatDate("dd MMM yyyy, HH:mm", ldt, null);
	}
	
	/**
	 * e.g. 02 Apr 1994, 00:01
	 * @param ldt - LocalDateTime,
	 * 			locale - Locale
	 */
	public static String formatToDdSpaceMmmSpaceYyyyCommaSpaceHhColonMm(LocalDateTime ldt, Locale locale) {
		return formatDate("dd MMM yyyy, HH:mm", ldt, locale);
	}
	
	private static String formatDate(String dateFormat, LocalDateTime ldt, Locale locale) {
		DateTimeFormatter format = null;
		if(locale == null) {
			format = DateTimeFormatter.ofPattern(dateFormat);
		} else {
			format = DateTimeFormatter.ofPattern(dateFormat, locale);
		}
		
		return format.format(ldt);
	}
}

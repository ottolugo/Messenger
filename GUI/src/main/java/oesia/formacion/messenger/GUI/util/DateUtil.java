package oesia.formacion.messenger.GUI.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm:ss.SSS");

	/**
	 * Format a date to a string
	 * 
	 * @param date LocalDateTime
	 * @return String with the next format: "yyyy MM dd HH:mm:ss.SSS"
	 */
	public static String format(LocalDateTime date) {
		return date.format(formatter);
	}

	/**
	 * 
	 * @param date String with the next format: "yyyy MM dd HH:mm:ss.SSS"
	 * @return LocalDateTime
	 */
	public static LocalDateTime parse(String date) {
		return LocalDateTime.parse(date, formatter);
	}
}

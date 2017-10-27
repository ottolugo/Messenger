package oesia.formacion.messenger.P2P.domain.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import oesia.formacion.messenger.P2P.domain.entities.LocalConfiguration;

public class DateUtil {
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm:ss.SSS");
	private static int timeout = LocalConfiguration.getMessageTimeout();

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

	/**
	 * check if the message is within the timeout limit, true if ok, false if expired
	 * 
	 * @param message
	 * @return
	 */
	public static boolean isDateValid(LocalDateTime date) {
		return (date.until(LocalDateTime.now(), ChronoUnit.SECONDS) < timeout);
	}
}

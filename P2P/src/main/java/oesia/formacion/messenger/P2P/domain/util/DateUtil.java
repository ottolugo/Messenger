package oesia.formacion.messenger.P2P.domain.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm:ss.SSS");

	public static String format(LocalDateTime date) {
		return date.format(formatter);
	}

	public static LocalDateTime parse(String date) {
		return LocalDateTime.parse(date, formatter);
	}
}

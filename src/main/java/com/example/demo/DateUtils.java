package com.example.demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DateUtils {

	final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	private DateUtils() {
	}

	public static LocalDateTime fromStingWithoutTime(String date) {
		return LocalDateTime.parse(date + " 00:00", FORMATTER);
	}
}

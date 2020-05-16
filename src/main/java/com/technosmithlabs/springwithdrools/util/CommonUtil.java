package com.technosmithlabs.springwithdrools.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class CommonUtil {

	public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MM-d-yyyy");

	public static Long getAge(String dob) {
		final LocalDate date = LocalDate.parse(dob, DATE_FORMATTER);
		final Long age = ChronoUnit.DAYS.between(date, LocalDate.now());
		System.out.println("Age is: " + age);
		return age;
	}
}

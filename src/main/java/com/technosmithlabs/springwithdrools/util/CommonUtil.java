package com.technosmithlabs.springwithdrools.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CommonUtil {
	
	public static Long getAge(LocalDate dob) {
		return ChronoUnit.DAYS.between(dob, LocalDate.now());
	}
}

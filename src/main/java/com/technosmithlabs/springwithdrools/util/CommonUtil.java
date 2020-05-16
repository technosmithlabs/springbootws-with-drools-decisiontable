package com.technosmithlabs.springwithdrools.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;

public class CommonUtil {

	public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MM-d-yyyy");

	public static Long getAge(String dob) {
		final LocalDate date = LocalDate.parse(dob, DATE_FORMATTER);
		final Long age = ChronoUnit.YEARS.between(date, LocalDate.now());
		System.out.println("Age is: " + age);
		return age;
	}

	public static String compileRulesExcelToDrl() throws FileNotFoundException {
		final InputStream is = new FileInputStream(new File(
				"/Users/anshulgautam/anshul-workstation/projects/springbootws-with-drools-decisiontable/src/main/resources/drools/rules.xls"));
		SpreadsheetCompiler comp = new SpreadsheetCompiler();
		String drl = comp.compile(false, is, InputType.XLS);
		System.out.println(drl);
		return drl;
	}
}

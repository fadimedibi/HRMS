package com.practice;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

public class TimeStamp {

	@Test
	public void getTime() {
		Date date = new Date();
		// System.out.println(date.getTime());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/hh:mm:ss");
		String formattedDate = sdf.format(date.getTime());
		System.out.println(formattedDate);

	}
}

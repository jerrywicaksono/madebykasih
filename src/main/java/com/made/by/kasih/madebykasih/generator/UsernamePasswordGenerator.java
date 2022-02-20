package com.made.by.kasih.madebykasih.generator;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.made.by.kasih.madebykasih.util.DateUtil;

@Component
public class UsernamePasswordGenerator {
	
	@Value("${username.length}") 
	private String usernameLength;
	
	public String generateUsername(String name) {
		String username = null;
		String charset = name.toUpperCase().trim().substring(0,4);
		String year = DateUtil.dateToYearOnlyFormat(new Date());
		String month = DateUtil.dateToStringMonthOnlyFormat(new Date());
		username = charset.concat(year).concat(month);
		return username;
	}

	public Long generatePIN() {
		long number = (long) Math.floor(Math.random() * 900000L) + 100000L;
		return number;
	}
}
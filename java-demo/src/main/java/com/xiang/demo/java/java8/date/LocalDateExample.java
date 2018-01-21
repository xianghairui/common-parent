package com.xiang.demo.java.java8.date;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;

/**
 * @author xianghairui@outlook.com
 * @Date 2017年7月14日 下午2:38:28
 */
public class LocalDateExample {
	
	public static void main(String[] args) {
		
		LocalDate today = LocalDate.now();
		System.out.println("current date=" + today);
		
		LocalDate firstDay_2014 = LocalDate.of(2014, Month.JANUARY, 1);
		System.out.println("Specific Date=" + firstDay_2014);
		
		LocalDate dateFromBase = LocalDate.ofEpochDay(365);
		System.out.println("365th day from base date=" + dateFromBase);
		
		LocalTime timeKolKata = LocalTime.now(ZoneId.of("Asia/Kolkata"));
		System.out.println(timeKolKata);
		
		LocalTime specificSecoundTime = LocalTime.ofSecondOfDay(1000);
		System.out.println("1000th second time=" + specificSecoundTime);
	
		/*
		current date=2017-07-14
		Specific Date=2014-01-01
		365th day from base date=1971-01-01
		12:36:16.482
		1000th second time=00:16:40 
		 */
		
	}
	
}

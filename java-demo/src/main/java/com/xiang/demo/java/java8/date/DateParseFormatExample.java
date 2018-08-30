package com.xiang.demo.java.java8.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 解析和格式化：将一个日期格式转换为不同的格式，之后再解析一个字符串，得到日期时间对象，这些都是很常见的。我们来看一下简单的例子。
 * 
 * @author xianghairui@outlook.com
 * @Date 2017年7月14日 下午3:08:26
 */
public class DateParseFormatExample {

	public static void main(String[] args) {
		
		LocalDate date = LocalDate.now();
		System.out.println("Default format of LocalDate=" + date);
		
		System.out.println(date.format(DateTimeFormatter.ofPattern("d::MMM::uuuu")));
		System.out.println(date.format(DateTimeFormatter.ofPattern("MMMddHHmmss")));
		
	}

}

package com.xiang.demo.java.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestIo {
	
	public static void main(String[] args) throws IOException {
		
		File directory = new File("");//参数为空 
		String courseFile = directory.getCanonicalPath() ;
		File file = new File(courseFile);
		System.out.println(readFiles(file)); 
		System.out.println(regexHTML("hh.html"));
	}
	public static int i = 0;
	public static String readFiles(File file){
		StringBuffer s = new StringBuffer();
		s.append("[");
		if(file.isDirectory()){
			s.append(" -- " + file.getName());
			for(File f : file.listFiles()){
				 s.append(readFiles(f));
				 s.append("\n");
			}
		} else {
			s.append(file.getName());
			s.append("\n");
		}
		s.append("]");
		return s.toString();
	}
	
	/**
	 * 匹配html文件
	 * @param html 
	 * @return
	 */
	public static boolean regexHTML(String html){
		String regEx = ".+\\.html$";
		return regex(html, regEx);
	}
	
	/**
	 * 正则验证
	 * @param str 需验证字符串
	 * @param regEx 正则规则
	 * @return
	 */
	public static boolean regex(String str , String regEx){
	    // 编译正则表达式
	    Pattern pattern = Pattern.compile(regEx);
	    // 忽略大小写的写法
	    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(str);
	    // 字符串是否与正则表达式相匹配
		return matcher.matches();
	}
	
	public void createNewJspFeil() throws IOException{
//		String path  = request.getSession().getServletContext().getRealPath("micromarketing" 
//				+ File.separator + "template" + File.separator + user.getVc2uaccount());
		String path = "";
		//上传文件的新文件名
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		String newFile = uuid + ".jsp";//上传文件的新文件名
		File file = new File(path, newFile);
		if(!file.exists()){
			// 先得到文件的上级目录，并创建上级目录，在创建文件
            file.getParentFile().mkdirs();
            file.createNewFile();
		}
		String content = "<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>"
				+ "<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'><html><head></head><body>helloworld!</body></html>";
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(content);
		bw.close();
		
	}
	
}

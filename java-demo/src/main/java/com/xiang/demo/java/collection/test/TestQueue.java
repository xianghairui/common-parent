package com.xiang.demo.java.collection.test;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class TestQueue {
	
	public static final List<String> s = new ArrayList<>();
	
	public static void main(String[] args) {
        WeakReference<String> sr = new WeakReference<String>(new String("hello"));
        System.out.println(sr.get());
        System.gc();                //通知JVM的gc进行垃圾回收
        System.out.println(sr.get());
        
        s.add("a");
        System.out.println(s.toString());
	}
	
}

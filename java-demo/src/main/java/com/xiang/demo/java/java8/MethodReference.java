package com.xiang.demo.java.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MethodReference {
	
	public static void main(String[] args) {
		Consumer<String> consumer = (s) -> System.out.println(s);
		userConsumer(consumer, "Hello World!");
		
		userConsumer(s -> System.out.println(s), "hello world!");
		
		userConsumer(System.out::println, "Hello Lambda");
		
		List<Apple> list = Arrays.asList(new Apple("Green", 110), new Apple("abc", 113), new Apple("Red", 113));
		
		list.sort((a1, a2) -> a1.getColor().compareTo(a2.getColor()));
		System.out.println(list);
	}
	
	private static <T> void userConsumer(Consumer<T> consumer, T t){
		consumer.accept(t);
		consumer.accept(t);
	}
	
}

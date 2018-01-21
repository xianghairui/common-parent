package com.xiang.demo.java.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassNmae FilterApple
 * @Description lambda表达式
 *              <p>
 * @author hairui
 * @Date 2017年3月29日 下午11:31:37
 */
public class FilterApple {

	/**
	 * 
	 * @ClassNmae AppleFilter
	 * @Description FunctionalInterface<p>
	 * 这允许有一个默认方法，允许default ,和static 方法
	 * @author hairui
	 * @Date 2017年3月30日 上午11:38:41
	 */
	@FunctionalInterface
	public interface AppleFilter {
		boolean filter(Apple apple);
		
		default void print(String var){
			System.out.println(var);
		}
	}

	public static List<Apple> findApple(List<Apple> apples, AppleFilter appleFilter) {

		List<Apple> list = new ArrayList<>();
		for (Apple apple : apples) {
			if (appleFilter.filter(apple)) {
				list.add(apple);
			}
		}
		return list;
	}

	public static class GreenAnd150WeightFilter implements AppleFilter {

		@Override
		public boolean filter(Apple apple) {
			return (apple.getColor().equals("green") && apple.getWeight() >= 160);
		}

	}

	public static class YellowAnd1Less50WeightFilter implements AppleFilter {

		@Override
		public boolean filter(Apple apple) {
			return (apple.getColor().equals("yellow") && apple.getWeight() < 150);
		}

	}

	public static List<Apple> findGreenApple(List<Apple> apples) {

		List<Apple> list = new ArrayList<>();

		for (Apple apple : apples) {
			if ("green".equals(apple.getColor())) {
				list.add(apple);
			}
		}
		return list;
	}

	public static List<Apple> findApple(List<Apple> apples, String color) {

		List<Apple> list = new ArrayList<>();

		for (Apple apple : apples) {
			if (color.equals(apple.getColor())) {
				list.add(apple);
			}
		}
		return list;
	}

	public static void main(String[] args) throws InterruptedException {

		List<Apple> list = Arrays.asList(new Apple("green", 180), new Apple("green", 150), new Apple("red", 200));

		// List<Apple> greenApple = findGreenApple(list);
		// assert greenApple.size() == 20;

		/*
		 * List<Apple> greenApple = findApple(list, "green");
		 * System.out.println(greenApple);
		 * 
		 * List<Apple> redApple = findApple(list, "red");
		 * System.out.println(redApple);
		 */

		/*
		 * List<Apple> result = findApple(list, new GreenAnd150WeightFilter());
		 * System.out.println(result);
		 * 
		 * List<Apple> yellowList = findApple(list, new AppleFilter() {
		 * 
		 * @Override public boolean filter(Apple apple) { return
		 * "yellow".equals(apple.getColor()); } });
		 * System.out.println(yellowList);
		 */
		/*
		 * List<Apple> lambdaResult = findApple(list, (Apple apple) ->{ return
		 * apple.getColor().equals("green"); });
 		 */
/*		List<Apple> lambdaResult = findApple(list, apple -> {
			return apple.getColor().equals("green");
		});
		System.out.println(lambdaResult);*/
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		});
		thread.start();
		
		new Thread(()-> System.out.println(Thread.currentThread().getName())).start();
		
		Thread.currentThread().join();
	}

}

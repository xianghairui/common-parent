package com.xiang.demo.java.java8;

public class Apple {

	/**
	 * 颜色
	 */
	private String color;
	
	/**
	 * 重量
	 */
	private long weight;

	
	public Apple() {
		super();
	}

	public Apple(String color, long weight) {
		super();
		this.color = color;
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public long getWeight() {
		return weight;
	}

	public void setWeight(long weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Apple [color=" + color + ", weight=" + weight + "]";
	}
	
	
	
	
}

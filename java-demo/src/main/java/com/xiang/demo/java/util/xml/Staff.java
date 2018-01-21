package com.xiang.demo.java.util.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="staff")
public class Staff {
	
	/**
	 * 职员名称
	 */
	private String name;
	
	/**
	 * 职员年龄
	 */
	private int age;
	
	/**
	 * 是否为烟民
	 */
	private boolean smoker;

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	@XmlElement
	public void setAge(int age) {
		this.age = age;
	}

	public boolean isSmoker() {
		return smoker;
	}

	@XmlAttribute
	public void setSmoker(boolean smoker) {
		this.smoker = smoker;
	}

	@Override
	public String toString() {
		return "Staff [name=" + name + ", age=" + age + ", smoker=" + smoker + "]";
	}
	
	
	
}

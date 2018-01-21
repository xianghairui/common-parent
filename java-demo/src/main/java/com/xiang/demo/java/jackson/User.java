package com.xiang.demo.java.jackson;

import java.util.Date;

public class User {
	
	private String name;
	private String email;
	private int age;
	private Date birthday;
	
	
	public User() {
		super();
	}
	
	public User(String name, String email, int age, Date birthday) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.birthday = birthday;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", age=" + age + ", birthday=" + birthday + "]";
	}


	
}

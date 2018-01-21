package com.xiang.demo.memcached.test;

import java.io.Serializable;

/**
 * @ClassNmae User
 * @Description User<p>
 * @author xianghairui@outlook.com
 * @Date 2017年4月27日 下午5:18:57
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String userName;
	
	private int age;
	
	private String gender;
	
	private String adress;
	
	private String email;
	
	private String phone;

	public User() {
		super();
	}

	public User(String id, String userName, int age, String gender, String adress, String email, String phone) {
		super();
		this.id = id;
		this.userName = userName;
		this.age = age;
		this.gender = gender;
		this.adress = adress;
		this.email = email;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", age=" + age + ", gender=" + gender + ", adress="
				+ adress + ", email=" + email + ", phone=" + phone + "]";
	}
	
}

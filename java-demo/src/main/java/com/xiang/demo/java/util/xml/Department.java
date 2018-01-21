package com.xiang.demo.java.util.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author xianghairui@outlook.com
 * @Date 2017年9月21日 下午3:06:05
 */
@XmlRootElement(name="department")
public class Department {
	
	/**
	 * 部门名称
	 */
	private String name; 
	
	/**
	 * staff是单复同型，这里是假‘s’, 是为了区别staff
	 */
	private List<Staff> staffs;

	public String getName() {
		return name;
	}

	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}

	public List<Staff> getStaffs() {
		return staffs;
	}

	@XmlElement(name="staff")
	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}

	@Override
	public String toString() {
		return "Department [name=" + name + ", staffs=" + staffs + "]";
	}
	
	
	
	
}

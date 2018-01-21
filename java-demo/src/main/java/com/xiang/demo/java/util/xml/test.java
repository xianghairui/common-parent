package com.xiang.demo.java.util.xml;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * 测试xml解析
 * @author xianghairui@outlook.com
 * @Date 2017年9月21日 下午3:17:06
 */
public class test {

	public static void main(String[] args) throws JAXBException {
		
		JAXBContext context = JAXBContext.newInstance(Department.class, Staff.class);
		Marshaller marshaller = context.createMarshaller();// 根据上下文获取marsshaller对象
		
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// 设置编码字符集
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);// 格式化XML输出，有分行和缩进
		
		marshaller.marshal(getSimpleDepartment(), System.out);// 打印到控制台
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		marshaller.marshal(getSimpleDepartment(), baos);
		
		String xmlObj = new String(baos.toByteArray());//生成xml字符串
		System.out.println(xmlObj);
		
	}
	
    /** 
     * 生成一个简单的Department对象 
     * @return 
     */  
    private static Department getSimpleDepartment() {  
        List<Staff> staffs = new ArrayList<Staff>();  
          
        Staff stf = new Staff();  
        stf.setName("周杰伦");  
        stf.setAge(30);  
        stf.setSmoker(false);  
        staffs.add(stf);  
        stf.setName("周笔畅");  
        stf.setAge(28);  
        stf.setSmoker(false);  
        staffs.add(stf);  
        stf.setName("周星驰");  
        stf.setAge(40);  
        stf.setSmoker(true);  
        staffs.add(stf);  
          
        Department dept = new Department();  
        dept.setName("娱乐圈");  
        dept.setStaffs(staffs);  
          
        return dept;  
    }  
	
}

package com.xiang.demo.java.proxy.test;

import com.xiang.demo.java.proxy.CgLibProxy;
import com.xiang.demo.java.proxy.JdkProxy;
import com.xiang.demo.java.proxy.UserManager;
import com.xiang.demo.java.proxy.UserManagerImpl;

/**
 * proxy 代理类
 * @author xianghairui@outlook.com
 * @Date 2017年5月24日 上午10:08:58
 */
public class Client {
	
	public static void main(String[] args) {
		
		UserManager userManager = (UserManager)new CgLibProxy().createProxyObeject(new UserManagerImpl());
		System.out.println("------ CGLibProxy ------");
		userManager.addUser("Macower", "root");
		System.out.println("------ JDKProxy ------");
		JdkProxy jdkProxy = new JdkProxy();
		UserManager userManagerJDK = (UserManager) jdkProxy.newProxy(new UserManagerImpl());
		userManagerJDK.addUser("Macower", "root");
		
	}
	
}

package com.xiang.demo.java.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CgLibProxy implements MethodInterceptor {

	private Object targetObject;//cglib需要代理的目标对象
	
	public Object createProxyObeject(Object obj) {
		this.targetObject = obj;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(obj.getClass());
		enhancer.setCallback(this);
		Object proxyObj = enhancer.create();
		return proxyObj;//返回代理对象
	}
	
	
	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		Object obj = null;
		if("addUser".equals(method.getName())){//过滤方法
			checkPopedom();//检查权限
		}
		obj = method.invoke(targetObject, args);
		return obj;
	}
	
	private void checkPopedom() {
		System.out.println(".:检查权限 checkPopedom()!");
	}

}

package com.xiang.demo.memcached.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
	
	@RequestMapping(value={"/", "index", "index.html"})
	public String index() {
		System.out.println("hello world!");
		return "/index";
	}
	
	@RequestMapping(value={"/helloworld"})
	@ResponseBody
	public String helloWorld() {
		System.out.println("hello world!");
		return "index";
	}
	
	@RequestMapping(value={"/2"})
	public String index2() {
		System.out.println("hello world!");
		return "2";
	}
	
}

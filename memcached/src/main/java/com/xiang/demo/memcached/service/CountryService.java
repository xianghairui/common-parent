package com.xiang.demo.memcached.service;

import java.util.List;

import com.xiang.demo.memcached.entity.Country;

public interface CountryService {
	
	List<Country> query();
	
}

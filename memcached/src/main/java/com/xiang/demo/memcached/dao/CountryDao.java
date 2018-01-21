package com.xiang.demo.memcached.dao;

import java.util.List;

import com.xiang.demo.memcached.entity.Country;

public interface CountryDao {
	
	List<Country> query();
	
}

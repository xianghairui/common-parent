package com.xiang.demo.memcached.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xiang.demo.memcached.dao.CountryDao;
import com.xiang.demo.memcached.entity.Country;

@Service(value = "countryService")
public class CountryServiceImpl implements CountryService {
	
	@Resource
	private CountryDao countryDao;
	
	@Override
	public List<Country> query() {
		return countryDao.query();
	}

}

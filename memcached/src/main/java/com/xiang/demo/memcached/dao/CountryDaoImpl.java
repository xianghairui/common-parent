package com.xiang.demo.memcached.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.xiang.demo.memcached.entity.Country;

@Repository(value="countryDao")
public class CountryDaoImpl implements CountryDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Country> query() {
		String sql = "select * from country";
		RowMapper<Country> rowMapper = new BeanPropertyRowMapper<>(Country.class);
		return jdbcTemplate.query(sql, rowMapper);
	}
	

	
}

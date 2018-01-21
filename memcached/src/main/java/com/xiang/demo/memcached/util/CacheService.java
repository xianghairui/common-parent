package com.xiang.demo.memcached.util;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiang.demo.memcached.dao.CountryDao;
import com.xiang.demo.memcached.entity.Country;

import net.spy.memcached.MemcachedClient;

@Service
public class CacheService {

	private static final Logger logger = LoggerFactory.getLogger(CacheService.class);
	
	@Resource
	private CountryDao countryDao;
	
	@Autowired
	private MemcachedClient memcachedClient;
	
	@Autowired
	private CacheTemplateService cacheTemplateService;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	public List<Country> query() {	
		
		try {
			String key = "test";
			String json = memcachedClient.get(key) + "";
			
			if(StringUtils.isNotBlank(json) && !json.equalsIgnoreCase("null")){
				logger.info("------- for cache ----------");
				return mapper.readValue(json, new TypeReference<List<Country>>() {});
			} else {		
				synchronized (this) {
					json = memcachedClient.get(key) + "";
					if(StringUtils.isNotBlank(json) && !json.equalsIgnoreCase("null")){
						logger.info("------- for cache2 ----------");
						return mapper.readValue(json, new TypeReference<List<Country>>() {});
					} else {
						logger.info("------- for db -------");
						List<Country> result = countryDao.query();
						memcachedClient.set(key, 60, mapper.writeValueAsString(result));
						return result;
					}
				}
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return null;
	}
	
	public List<Country> queryTemplate() {
		String key = "test";
		return cacheTemplateService.findCache(key, 60, new TypeReference<List<Country>>(){}, new CacheLoadBack<List<Country>>() {
			
			@Override
			public List<Country> load() {
				logger.info("------- for db -------");
				return countryDao.query();
			}
			
		});
	}
	
}

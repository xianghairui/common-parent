package com.xiang.demo.memcached.util;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiang.demo.memcached.dao.CountryDao;
import com.xiang.demo.memcached.entity.Country;

import net.spy.memcached.MemcachedClient;

@Repository
public class CacheTemplateService {
	
	private static final Logger logger = LoggerFactory.getLogger(CacheTemplateService.class);
	
	@Autowired
	private MemcachedClient memcachedClient;
	
	@Resource
	private CountryDao countryDao;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	public <T> T findCache(String key, int expire, TypeReference<T> clazz, CacheLoadBack<T> loadBack) {
		
		try {
			String json = memcachedClient.get(key) + "";
			
			if(StringUtils.isNotBlank(json) && !json.equalsIgnoreCase("null")){
				logger.info("------- for cache ----------");
				return mapper.readValue(json, clazz);
			} else {
				synchronized (this) {
					json = memcachedClient.get(key) + "";
					if(StringUtils.isNotBlank(json) && !json.equalsIgnoreCase("null")){
						logger.info("------- for cache2 ----------");
						return mapper.readValue(json, clazz);
					} else {
						logger.info("------- for db -------");
						T result = loadBack.load();
						memcachedClient.set(key, expire, mapper.writeValueAsString(result));
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
	
}

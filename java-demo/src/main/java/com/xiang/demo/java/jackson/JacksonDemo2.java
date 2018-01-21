package com.xiang.demo.java.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @ClassNmae JacksonDemo2
 * @Description JSON转java类[JSON反序列化]<p>
 * @author xianghairui@outlook.com
 * @Date 2017年5月3日 下午5:10:48
 */
public class JacksonDemo2 {
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
		String json = "{\"name\":\"小民\",\"age\":20,\"birthday\":844099200000,\"email\":\"xiaomin@sina.com\"}";
		
		/**
		 * ObjectMapper支持byte[]、File、InputStream、字符串等数据的JSON反序列化
		 */
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(json, User.class);
		System.out.println(user);
	}
	
}

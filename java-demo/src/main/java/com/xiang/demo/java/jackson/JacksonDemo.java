package com.xiang.demo.java.jackson;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @ClassNmae JacksonDemo
 * @Description Java对象转JSON[JSON序列化];JSON转java类[JSON反序列化]<p>
 * @author xianghairui@outlook.com
 * @Date 2017年5月3日 下午5:09:46
 */
public class JacksonDemo {
	
	private ObjectMapper mapper = new ObjectMapper();
	
	public static void main(String[] args) throws ParseException, IOException {
		JacksonDemo jd = new JacksonDemo();
		jd.javaToJson();
		jd.jsonToJava();
	}
	
	/**
	 * Java对象转JSON[JSON序列化]<p>
	 * @throws ParseException
	 * @throws IOException 
	 */
	public void javaToJson() throws ParseException, IOException {
		System.out.println("---------- java to json ----------");
		User user = new User();
		user.setName("相00");
		user.setEmail("xiang00@qq.com");
		user.setAge(20);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		user.setBirthday(dateFormat.parse("1992-10-01"));
		
		/**
		 * ObjectMapper是JSON操作的核心，Jackson的所有JSON操作都是在ObjectMapper中实现的
		 * ObjectMapper有多个JSON序列化的方法，可以把JSON字符串保存File、OutputStream等不同的介质中。
		 * writeValue(File arg0, Ojbect arg1)把arg1转成json序列，并保存到arg0文件中。
		 * writeValue(OutputStream arg0, Object arg1)把arg1转成json序列，并保存到arg0输出流中。
		 * writeValueAsBytes(Ojbect arg0)把arg0转成json序列，并把结果输出成字节数组。
		 * writeValueAsString(Ojbect arg0)把arg0转成json序列，并把结果输出成字符串。
		 */
		
		//User类转JSON
		//输出结果：{"name":"相00","email":"xiang00@qq.com","age":20,"birthday":717868800000}
		String json = mapper.writeValueAsString(user);
		System.out.println(json);
		
		List<User> users = new ArrayList<User>();
		users.add(user);
		String jsonlist = mapper.writeValueAsString(users);
		System.out.println(jsonlist);
		
		System.out.println("------------- String list to Object");
		System.out.println(listJsonToJava(jsonlist));
		
	}
	
	/**
	 * listJson to Object
	 * @param json
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public List<User> listJsonToJava(String json) throws JsonParseException, JsonMappingException, IOException {
		List<User> beanList = mapper.readValue(json, new TypeReference<List<User>>() {});  
		
		//方法二
/*		ObjectMapper mapper = new ObjectMapper();  
		JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, User.class);  
		//如果是Map类型  mapper.getTypeFactory().constructParametricType(HashMap.class,String.class, Bean.class);  
		List<User> beanList =  (List<User>)mapper.readValue(json, javaType);   */
		
		return beanList;
	}
	
	public void jsonToJava() throws JsonParseException, JsonMappingException, IOException {
		System.out.println("---------- json to java ----------");
		String json = "{\"name\":\"小民\",\"age\":20,\"birthday\":844099200000,\"email\":\"xiaomin@sina.com\"}";
		
		/**
		 * ObjectMapper支持byte[]、File、InputStream、字符串等数据的JSON反序列化
		 */
		User user = mapper.readValue(json, User.class);
		System.out.println(user);
	}
	
}

package com.xiang.demo.java.jackson;

import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @ClassNmae JacksonDataBinding
 * @Description Data Binding的使用<p>
 * 1. Full Data Binding<p>
 * 2. Raw data binding<p>
 * 3. Generic data binding<p>
 * @author xianghairui@outlook.com
 * @Date 2017年5月3日 下午5:19:37
 */
public class JacksonDataBinding {
	
	private static final String MODEL_BINDING = 
			"{\"name\":\"name1\",\"type\":1}";
	
	/**
	 * Full Data Binding
	 * @throws Exception
	 */
	public void fullDataBinding() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Model user = mapper.readValue(MODEL_BINDING, Model.class);
		
		System.out.println(user.getName());
		System.out.println(user.getType());
	}
	
	/**
	 * raw data binding
	 * @throws Exception
	 */
	public void rawDataBinding() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		@SuppressWarnings("unchecked")
		HashMap<String, Object> map = mapper.readValue(MODEL_BINDING, HashMap.class);
		
		System.out.println(map.get("name"));
		System.out.println(map.get("type"));
	}
	
	/** 通用 */
	private static final String GENERIC_BINDING = "{\"key1\":{\"name\":\"name2\",\"type\":2},\"key2\":{\"name\":\"name3\",\"type\":3}}";
	
	/**
	 * generic data binding
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void genericDataBinding() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, Model> modelMap = mapper.readValue(GENERIC_BINDING, new TypeReference<HashMap<String, Model>>() {});//readValue到一个范型数据中
		
		Model model = modelMap.get("key2");
		System.out.println(model.getName());
		System.out.println(model.getType());
		
	}
	
	private static final String TREE_MODEL_BINDING = "{\"treekey1\":\"treevalue1\",\"treekey2\":\"treevalue2\",\"children\":[{\"childkey1\":\"childkey1\"}]}";
	
	/**
	 * Tree Model 最灵活
	 * @throws Exception
	 */
	public void treeModelBinding() throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readTree(TREE_MODEL_BINDING);
	
		//path与get作用相同，但是当找不到该节点的时候，返回missing node 而不是null
		String treekey2value = rootNode.path("treekey2").textValue();
		System.out.println("treekey2value: " + treekey2value);
	
		JsonNode childrenNode = rootNode.path("children");
		String childkey1Value = childrenNode.get(0).path("childkey1").textValue();
		System.out.println("childkey1Value:" + childkey1Value);
		
		//创建根节点
		ObjectNode root = mapper.createObjectNode();	
		//创建子节点1
		ObjectNode node1 = mapper.createObjectNode();
		node1.put("nodekey1", 1);
		node1.put("nodekey2", 2);
		//绑定子节点
		root.set("child", node1);
		System.out.println(root.toString());
		
		//数组节点
		ArrayNode arrayNode = mapper.createArrayNode();
		arrayNode.add(node1);
		arrayNode.add(1);
		//绑定子节点1
		root.set("arraynode", arrayNode);
		System.out.println(root.toString());
		
		//JSON读到树节点
		JsonNode valueToTreeNode = mapper.valueToTree(TREE_MODEL_BINDING);
		//绑定json节点
		root.set("valuetotreenode", valueToTreeNode);
		
		//JSON绑定到JSON节点对象
		JsonNode bindJsonNode = mapper.readValue(GENERIC_BINDING, JsonNode.class);//绑定JSON到JSON节点对象.
		root.set("bindJsonNode", bindJsonNode);
		
		System.out.println(mapper.writeValueAsString(root));
	}
	
	
	public static void main(String[] args) throws Exception {
		JacksonDataBinding jdb = new JacksonDataBinding();
		System.out.println("\nfull data binding-------");
		jdb.fullDataBinding();
		
		System.out.println("\nraw data binding-----");
		jdb.rawDataBinding();
		
		System.out.println("\ngeneric data binding-------");
		jdb.genericDataBinding();
		
		System.out.println("\ntree node binding----------");
		jdb.treeModelBinding();
	}
	
}

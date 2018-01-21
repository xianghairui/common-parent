package com.xiang.demo.java.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @ClassNmae JacksonTreeModel
 * @Description Tree Model 最灵活<p>
 * @author xianghairui@outlook.com
 * @Date 2017年5月3日 下午9:33:47
 */
public class JacksonTreeModel {

	private static final String TREE_MODEL_BINDING = "{\"treekey1\":\"treevalue1\",\"treekey2\":\"treevalue2\",\"children\":[{\"childkey1\":\"childkey1\"}]}";
	
	/** 通用 */
	private static final String GENERIC_BINDING = "{\"key1\":{\"name\":\"name2\",\"type\":2},\"key2\":{\"name\":\"name3\",\"type\":3}}";

	
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
		
		JacksonTreeModel treeModel = new JacksonTreeModel();
		treeModel.treeModelBinding();
		
	}
	
}

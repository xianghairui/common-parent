package com.xiang.demo.java.jackson;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/**
 * @ClassNmae JacksonStreamingApi
 * @Description Streaming API
 *              <p>
 *              对于性能要求高的程序，推荐使用流API,否则使用其他方法
 * @author xianghairui@outlook.com
 * @Date 2017年5月3日 下午10:26:21
 */
public class JacksonStreamingApi {

	  //jsonFactory实例，线程安全。
    private static JsonFactory jsonFactory = new JsonFactory();
	
	public static void main(String[] args) throws IOException {

		/** write to file */
		JsonGenerator jsonGenerator = jsonFactory
				.createGenerator(new File("src/main/java/com/xiang/demo/java/jackson/user.json"), JsonEncoding.UTF8);

		jsonGenerator.writeStartObject();// {

		jsonGenerator.writeStringField("name", "xiang");
		jsonGenerator.writeNumberField("age", 29);

		jsonGenerator.writeFieldName("messages");// "messages" :
		jsonGenerator.writeStartArray();// [

		jsonGenerator.writeString("msg 1");// "msg 1"
		jsonGenerator.writeString("msg 2");// "msg 2"
		jsonGenerator.writeString("msg 3");// "msg 3"

		jsonGenerator.writeEndArray();// ]

		jsonGenerator.writeEndObject();// }

		jsonGenerator.close();

		/** read from file */
		JsonParser jsonParser = jsonFactory
				.createParser(new File("src/main/java/com/xiang/demo/java/jackson/user.json"));

		// loop until token equal to "}"
		while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
			String fieldName = jsonParser.getCurrentName();
			if ("name".equals(fieldName)) {
				// current token is "name"
				// move to next, which is "name"'s value

				jsonParser.nextToken();
				System.out.println(jsonParser.getText()); // display xiang
			}

			if ("age".equals(fieldName)) {
				// current token is "age",
				// move to next, which is "name"'s value
				jsonParser.nextToken();
				System.out.println(jsonParser.getIntValue());
			}
			
			if("messages".equals(fieldName)) {
				jsonParser.nextToken();// currect token is "[", move next
				
				// messages is array, loop until token equal to "]"
				while(jsonParser.nextToken() != JsonToken.END_ARRAY) {
					// display msg1, msg2, msg3
					System.out.println(jsonParser.getText());
				}
			}

		}
		jsonParser.close();
	}

}

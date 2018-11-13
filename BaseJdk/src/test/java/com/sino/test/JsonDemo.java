package com.sino.test;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/***
 * 
 * @author lonny
 *
 */
public class JsonDemo {

	public static void main(String[] args) {

		User user = new User();
		user.setAddress("长宁区");
		user.setAge(24);
		user.setAuth(true);
		user.setCity("sh");
		user.setCountry("china");
		user.setName("zhangsan");
		user.setPhone("1231231231");
		user.setProvince("SH");

		String jsonString = com.alibaba.fastjson.JSONObject.toJSONString(user);

		System.out.println("JSON 字符串：" + jsonString);

		UserParsed parseObject = com.alibaba.fastjson.JSONObject.parseObject(jsonString, UserParsed.class);

		System.out.println("fastJson 不完全解析结果：" + parseObject);

		User user2 = com.alibaba.fastjson.JSONObject.parseObject(jsonString, User.class);

		System.out.println("fastJson 完全解析结果：" + user2);

		Gson gson = new Gson();
		
		JSONObject jsonObject = new JSONObject();
		
		UserParsed fromJson = gson.fromJson(jsonString, UserParsed.class);
		
		System.out.println("gson 不完全解析结果：" + fromJson);

		User fromJson2 = gson.fromJson(jsonString, User.class);

		System.out.println("gson 完全解析结果：" + fromJson2);
		
		
		
	}

}

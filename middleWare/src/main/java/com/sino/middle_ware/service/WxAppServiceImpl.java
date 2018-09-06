package com.sino.middle_ware.service;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WxAppServiceImpl implements WxAppService{
	
	@Value("${third.wechart.sessionUrl}")
	private String sessionUrl;
	@Value("${third.wechart.appid}")
	private String appid;
	@Value("${third.wechart.secret}")
	private String secret;
	
	@Resource(name = "sslRestTemplate")
	RestTemplate sslRestTemplate ;
	
//	appid	是	小程序唯一标识
//	secret	是	小程序的 app secret
//	js_code	是	登录时获取的 code
//	grant_type	是	填写为 authorization_code
	
	@Override
	public String getSesseionkey(String code) {
		HashMap<String,String> hashMap = new HashMap<String,String>();
		hashMap.put("appid", appid);
		hashMap.put("secret", secret);
		hashMap.put("js_code", code);
		hashMap.put("grant_type", "authorization_code");
		ResponseEntity<String> forEntity = sslRestTemplate.getForEntity(sessionUrl, String.class, hashMap);
		String body = forEntity.getBody();
		return body;
		
	}
	
	
	
	

}

package com.sino.middle_ware.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sino.middle_ware.service.WxAppServiceImpl;

@RestController
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	WxAppServiceImpl wxAppServiceImpl;
	
	@PostMapping("/profile/login")
	public String login(@RequestParam("code")String code) {
		logger.info("获取code:"+code);
		wxAppServiceImpl.getSesseionkey(code);
		
		return "";
	}
	
	
}

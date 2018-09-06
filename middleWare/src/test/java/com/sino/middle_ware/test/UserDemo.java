package com.sino.middle_ware.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sino.middle_ware.service.WxAppServiceImpl;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDemo {
	
	@Autowired
	WxAppServiceImpl wxAppServiceImpl;
	
	
	@Test
	public void callWx() {
		String code="12312";
		String sesseionkey = wxAppServiceImpl.getSesseionkey(code);
		System.out.println("sesseionkey:"+sesseionkey);//{"errcode":40013,"errmsg":"invalid appid, hints: [ req_id: 50kD30024hc60 ]"}
	}
	
	
}

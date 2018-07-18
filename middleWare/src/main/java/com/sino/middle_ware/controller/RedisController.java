//package com.sino.middle_ware.controller;
//
//import java.util.concurrent.TimeUnit;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.HashOperations;
//import org.springframework.data.redis.core.ReactiveRedisTemplate;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.sino.middle_ware.service.RedisService;
//
//@RestController
//@RequestMapping("/redis")
//public class RedisController {
//	@Autowired
//	private RedisService redisServiceImpl;
//	
//	
//	@Autowired
//	private RedisTemplate redisTemplate;
//	
//	@Autowired
//	StringRedisTemplate stringRedisTemplate;
//	
//	@GetMapping("/test")
//	public String test(){
//		String test = redisServiceImpl.test();
//		return test;
//	}
//	
//	
//	@GetMapping("/test2")
//	public void test2(){
//		//操作字符串
//		ValueOperations opsForValue = redisTemplate.opsForValue();
//		opsForValue.set("sino.redis.string.name", "zhangsan");
//		String name = (String) opsForValue.get("sino.redis.string.name");
//		System.out.println("name:"+name);
//		
//		redisTemplate.opsForHash();//操作hash
//		redisTemplate.opsForList();//操作list
//		redisTemplate.opsForSet();//操作set
//		redisTemplate.opsForZSet();//操作有序set
//		
//	}
//	
//	
//	@GetMapping("/test/string")
//	public void test3(){
//		//操作字符串
//		ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
//		
//		opsForValue.set("sino.redis.string.name", "zhangsan");
//		String name = opsForValue.get("sino.redis.string.name");
//		opsForValue.set("sino.redis.string.age","23", 12L,TimeUnit.SECONDS);
//		String age = opsForValue.get("sino.redis.string.age");
//		System.out.println("name: "+name+"age: "+age);
//	
//	}
//	
//	
//	
//	
//	
//	
//	
//}

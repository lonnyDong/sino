package com.sino.middle_ware.test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 模拟session操作
 * @author lonny
 *
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisSession {

	/* 锁前缀 */
	public static String PERFIX_KEY_OF_SESSION = "session";

	@Autowired
	RedisTemplate<String, Object> redisTemplate;

	
	@Test
	public void hashTest() {
		
		HashOperations<String, Object, Object> opsForHash = redisTemplate.opsForHash();
		//1.用户登录 返回用户id
		String sessionId  = "sessionid" ;
		opsForHash.put(sessionId, "userName", "zhangsan");
		opsForHash.put(sessionId, "nickName", "xinxin");
		redisTemplate.expire(sessionId, 5, TimeUnit.SECONDS);
		Boolean hasKey = true;
		while (hasKey) {
			hasKey = redisTemplate.hasKey(sessionId);
			System.out.println(hasKey);
		}
	
	}

}

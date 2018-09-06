package com.sino.middle_ware.test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.netflix.discovery.converters.Auto;

/**
 * 分布式限流--实现原理
实现原理其实很简单。既然要达到分布式全局限流的效果，那自然需要一个第三方组件来记录请求的次数。
其中 Redis 就非常适合这样的场景。
	每次请求时将当前时间(精确到秒)作为 Key 写入到 Redis 中，超时时间设置为 2 秒，Redis 
将该 Key 的值进行自增。当达到阈值时返回错误。写入 Redis 的操作用 Lua 脚本来完成，利用 Redis 
的单线程机制可以保证每个 Redis 请求的原子性。
 *
 */

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class DistributeLimit {
	/*
	 *自增脚本
	 */
	@Auto
	private RedisTemplate redisTemplate;
	
	private final String script = "";
	
	
	
	public static void main(String[] args) {
		
		
		
		
		
	}
	
//	public boolean limit() {
//	    String key = String.valueOf(System.currentTimeMillis() / 1000);
//	    Object result = null;
//	    redisTemplate.execute(script, argsSerializer, resultSerializer, keys, args);
//	    if (jedis instanceof Jedis) {
//	        result = ((Jedis) this.jedis).eval(script, Collections.singletonList(key), Collections.singletonList(String.valueOf(limit)));
//	    } else if (jedis instanceof JedisCluster) {
//	        result = ((JedisCluster) this.jedis).eval(script, Collections.singletonList(key), Collections.singletonList(String.valueOf(limit)));
//	    } else {
//	      
//	        return false;
//	    }
//	    if (FAIL_CODE != (Long) result) {
//	        return true;
//	    } else {
//	        return false;
//	    }
//	}
	
}

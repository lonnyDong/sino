package com.sino.middle_ware.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.integration.redis.util.RedisLockRegistry;

@Configuration
public class RedisLockRegistryConfig {
	
	private static Logger logger = LoggerFactory.getLogger(RedisLockRegistryConfig.class);
	
	 private static volatile RedisLockRegistry redisLockRegistry = null;
	
	private static final String PRE_CACHE_LOCK = "cache_lock";

	@Autowired
	RedisConnectionFactory luttuceConnectionFactory;
	
	
	@Bean
	public RedisLockRegistry createRedisLock() {
	    RedisLockRegistry lock = new RedisLockRegistry(luttuceConnectionFactory, PRE_CACHE_LOCK,1000);
	    redisLockRegistry = lock;
	    return lock;
	}
	
	public  static RedisLockRegistry getRedisLockRegistry() {
	    if (redisLockRegistry == null) {
	        while (true) {
	            try {
	                Thread.sleep(100);
	                if (redisLockRegistry != null) {
	                    break;
	                }
	            } catch (Exception e) {
	                logger.error(e.getMessage());
	            }
	        }
	    }
	    return redisLockRegistry;
	}
	

	
	
}


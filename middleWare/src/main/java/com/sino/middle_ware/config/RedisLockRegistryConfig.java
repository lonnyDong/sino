package com.sino.middle_ware.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.integration.redis.util.RedisLockRegistry;

@Configuration
public class RedisLockRegistryConfig {
	
	private static Logger logger = LoggerFactory.getLogger(RedisLockRegistryConfig.class);
	
	 private static volatile RedisLockRegistry redisLockRegistry = null;
	
	private static final String PRE_CACHE_LOCK = "cache_lock";

	
	@Bean
	public RedisLockRegistry createRedisLock(RedisConnectionFactory factory) {
	    RedisLockRegistry lock = new RedisLockRegistry(factory, PRE_CACHE_LOCK);
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


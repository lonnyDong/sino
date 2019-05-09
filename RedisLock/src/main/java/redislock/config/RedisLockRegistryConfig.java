package redislock.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.integration.redis.util.RedisLockRegistry;

@Configuration
public class RedisLockRegistryConfig {

	private static Logger logger = LoggerFactory.getLogger(RedisLockRegistryConfig.class);

	 private static volatile RedisLockRegistry redisLockRegistry = null;

	private static final String PRE_CACHE_LOCK = "redlock";


	@Bean
	public RedisLockRegistry createRedisLock(LettuceConnectionFactory lettuceConnectionFactory) {
		return new RedisLockRegistry(lettuceConnectionFactory, PRE_CACHE_LOCK,300000L);
	}

	public  static RedisLockRegistry getRedisLockRegistry() {
		logger.info("加载静态方法 ....");
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


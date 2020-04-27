package redislock.config;

import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisTemplateConfig {

	@Autowired
	private RedisTemplate redisTemplate;

	@Bean
	public RedisTemplate<String, Object> redisCacheTemplate(RedisConnectionFactory redisConnectionFactory) {
		// 设置序列化
		FastJsonRedisSerializer fastJsonRedisSerializer = new FastJsonRedisSerializer(Object.class);
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		ParserConfig parserConfig = new ParserConfig();
		parserConfig.setAutoTypeSupport(true);
		fastJsonConfig.setParserConfig(parserConfig);
		fastJsonRedisSerializer.setFastJsonConfig(fastJsonConfig);
		RedisSerializer stringSerializer = new StringRedisSerializer();
		// key序列化
		redisTemplate.setKeySerializer(stringSerializer);
		// value序列化
		redisTemplate.setValueSerializer(fastJsonRedisSerializer);
		// Hash key序列化
		redisTemplate.setHashKeySerializer(stringSerializer);
		// Hash value序列化
		redisTemplate.setHashValueSerializer(fastJsonRedisSerializer);

		return redisTemplate;
	}
}

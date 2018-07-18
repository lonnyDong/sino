/*package com.sino.middle_ware.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class JedisRedisConfig {
	@Value("${spring.redis.cluster.nodes}")
	private String nodes;
	@Value("${spring.redis.password}")
	private String password;
	@Value("${spring.redis.timeout}")
	private int timeout;
	@Value("${spring.redis.jedis.pool.max-idle}")
	private int maxIdle;
	@Value("${spring.redis.jedis.pool.max-wait}")
	private long maxWaitMillis;

	@Bean
	public JedisPoolConfig jedisPoolConf() {
		JedisPoolConfig jp = new JedisPoolConfig();
		jp.setMaxIdle(maxIdle);
		jp.setMaxWaitMillis(maxWaitMillis);
		return jp;
	}

	
	
	@Bean
	public JedisCluster redisPoolFactory() {
		// 获取服务器数组(这里要相信自己的输入，所以没有考虑空指针问题)
		String[] serverArray = nodes.split(",");
		Set<HostAndPort> nodes = new HashSet<>();

		for (String ipPort : serverArray) {
			String[] ipPortPair = ipPort.split(":");
			nodes.add(new HostAndPort(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));
		}

		JedisCluster jedisCluster = new JedisCluster(nodes, jedisPoolConf());
		return jedisCluster;
	}

}*/
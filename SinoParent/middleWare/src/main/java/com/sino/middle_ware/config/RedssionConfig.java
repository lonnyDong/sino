//package com.sino.middle_ware.config;
//
//import org.redisson.Redisson;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.ClusterServersConfig;
//import org.redisson.config.Config;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RedssionConfig {
//
//	@Value("${spring.redis.cluster.nodes}")
//	private String nodes;
//	
//	@Bean
//	public RedissonClient getRedissonClient() {
//		Config config = new Config();
//		ClusterServersConfig setScanInterval = config.useClusterServers().setScanInterval(2000);
//		String[] nodeArr = nodes.split(",");
//		for (String node : nodeArr) {
//			setScanInterval.addNodeAddress("redis://"+node);
//		}
//		
//		// cluster state scan interval in milliseconds
//		// use "rediss://" for SSL connection
//		// .addNodeAddress("redis://127.0.0.1:7000", "redis://127.0.0.1:7001")
//		// .addNodeAddress("redis://127.0.0.1:7002");
//
//		RedissonClient redisson = Redisson.create(config);
//		return redisson;
//	}
//
//}

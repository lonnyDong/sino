package redislock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Administrator
 */
@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@MapperScan("redislock.dao")
public class RedisLockApplications {
	public static void main(String[] args) {
		SpringApplication.run(RedisLockApplications.class, args);
	}
}
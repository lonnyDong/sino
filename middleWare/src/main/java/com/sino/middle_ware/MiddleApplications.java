package com.sino.middle_ware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@MapperScan("com.sino.middle_ware.dao")
public class MiddleApplications {
	public static void main(String[] args) {
		SpringApplication.run(MiddleApplications.class, args);
	}
}
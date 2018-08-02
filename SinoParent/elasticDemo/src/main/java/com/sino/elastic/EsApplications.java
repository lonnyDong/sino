package com.sino.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class EsApplications {
	public static void main(String[] args) {
		SpringApplication.run(EsApplications.class, args);
	}
}
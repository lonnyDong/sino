package com.sino.middle_ware.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class DataSourceConfig {
	@Bean
	//默认数据源
	@Primary
	//将properties中以mysql为前缀的参数值，写入方法返回的对象中
//	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource mysqDataSource() {
		// 通过DataSourceBuilder构建数据源
		DataSource build = DataSourceBuilder.create().build();
		return build;
	}
	
}


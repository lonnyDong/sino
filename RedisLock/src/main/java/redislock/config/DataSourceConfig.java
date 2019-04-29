package redislock.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author Administrator
 */
public class DataSourceConfig {
	@Bean
	@Primary
	/**
	 *
	 /将properties中以mysql为前缀的参数值，写入方法返回的对象中
	 */
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource mysqlDataSource() {
		return  DataSourceBuilder.create().build();
	}
	
}


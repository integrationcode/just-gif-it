package com.boot.DasBoot.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PersistenceConfiguration {

	@Bean(name = "dataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	@Primary
	public DataSource tomcatDataSource() {
		return DataSourceBuilder.create().build();
	}
	
//	@Bean
//	@ConfigurationProperties(prefix = "datasource.flyway")
//	@FlywayDataSource
//	public DataSource flywayDatasource() {
//		return DataSourceBuilder.create().build();
//	}
}

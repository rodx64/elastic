package com.rb.elasticspring.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class DataSourceConfig {

	@Value("${oracle.username:}")
	private String username;
	@Value("${oracle.password:}")
	private String password;
	@Value("${oracle.host:}")
	private String host;
	@Value("${oracle.port:}")
	private String port;
	@Value("${oracle.service:}")
	private String service;
	@Value("${oracle.schema:}")
	private String schema;

	@Bean("dataSource")
    public HikariDataSource dataSource(){
		final HikariConfig hikariConfig = new HikariConfig();
		HikariDataSource hikariDataSource = null;
		final String driverClassName = "oracle.jdbc.OracleDriver";
		final String url = String.format("jdbc:oracle:thin:@%s:%s/%s", host, port, service);

		hikariConfig.setDriverClassName(driverClassName);
		hikariConfig.setJdbcUrl(url);
		hikariConfig.setUsername(username);
		hikariConfig.setPassword(password);
		hikariConfig.setSchema(schema);
		hikariDataSource = new HikariDataSource(hikariConfig);

		return hikariDataSource;
    }



}

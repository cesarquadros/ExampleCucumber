package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.b2w.b2wconta")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class AppConfigTest {
	
	@Value("${spring.datasource.driverClassName}")
	private String driverClassName;
	
	@Value("${spring.datasource.url}")
	private String urlH2;
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(urlH2);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}

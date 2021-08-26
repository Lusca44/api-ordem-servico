package com.lucas.orderService.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lucas.orderService.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {
 
	@Autowired
	private DBService service;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String ddl;

	@Bean
	public boolean instaciaDB() {
		if (ddl.equals("create")) {
			this.service.instanciaDB();
		}
		return false;
	}

}

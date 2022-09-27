package com.pichincha.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**
 * @author renso.valencia
 * @since 27/09/2022
 * @version 1.0
 */
@SpringBootApplication
@ComponentScan({"com.pichincha.controller", "com.pichincha.service"})
@EntityScan("com.pichincha.entity")
@EnableJpaRepositories("com.pichincha.repository")
public class ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}
}
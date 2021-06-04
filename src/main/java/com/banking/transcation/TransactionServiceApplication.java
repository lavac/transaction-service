package com.banking.transcation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Configuration
@EnableJpaRepositories("com.banking.transcation.repository")
public class TransactionServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(TransactionServiceApplication.class, args);
	}
}

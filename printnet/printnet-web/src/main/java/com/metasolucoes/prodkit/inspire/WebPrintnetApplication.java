package com.metasolucoes.prodkit.inspire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import com.github.mxab.thymeleaf.extras.dataattribute.dialect.DataAttributeDialect;

@SpringBootApplication
@EnableAsync
public class WebPrintnetApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebPrintnetApplication.class, args);
	}

	@Bean
	public DataAttributeDialect config() {
		return new DataAttributeDialect();
	}
}

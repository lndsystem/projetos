package com.metasolucoes.prodkit.inspire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import com.metasolucoes.prodkit.inspire.dialect.DataAttributeDialect;
import com.metasolucoes.prodkit.inspire.thymeleaf.MetaDialect;

@SpringBootApplication
@EnableAsync
public class WebPrintnetApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebPrintnetApplication.class, args);
	}

	@Bean
	public DataAttributeDialect dialectDataAttribute() {
		return new DataAttributeDialect();
	}

	@Bean
	public MetaDialect dialectThymeleaf() {
		return new MetaDialect();
	}
}

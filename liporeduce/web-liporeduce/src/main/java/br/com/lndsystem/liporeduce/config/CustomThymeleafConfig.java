package br.com.lndsystem.liporeduce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.lndsystem.liporeduce.thymeleaf.LiporeduceDialect;

@Configuration
public class CustomThymeleafConfig {

	@Bean
	public LiporeduceDialect liporeduceDialect() {
		return new LiporeduceDialect();
	}
}

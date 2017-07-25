package com.metasolucoes.prodkit.inspire.config;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource({ "classpath:env/mail-${ambiente:local}.properties" })
@PropertySource(value = { "file://${HOME}/.inspire-mail.properties" }, ignoreResourceNotFound = true) // recuperar_por_arquivo
public class MailConfig {

	@Autowired
	private Environment env;

	@Bean
	public Session mailSender() {
		System.setProperty("mail.mime.charset", "UTF-8");

		Properties props = System.getProperties();
		props.put("mail.smtp.host", env.getProperty("url.email"));
		props.put("mail.transport.protocol", "smtps");
		props.put("mail.smtp.port", env.getProperty("porta.email"));
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.starttls.required", "true");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(env.getProperty("username.email"), env.getProperty("password.email"));
			}
		});

		return session;
	}
}
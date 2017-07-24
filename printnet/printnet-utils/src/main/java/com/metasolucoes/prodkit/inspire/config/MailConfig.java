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

		/** Parâmetros de conexão com servidor Gmail */
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(env.getProperty("username"), env.getProperty("password"));
			}
		});
		session.setDebug(false);
		return session;
	}
}

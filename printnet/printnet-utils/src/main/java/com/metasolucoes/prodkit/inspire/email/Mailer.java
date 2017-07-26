package com.metasolucoes.prodkit.inspire.email;

import java.io.File;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.google.common.base.Throwables;
import com.metasolucoes.prodkit.inspire.dto.RecuperarSenhaDto;

@Component
@PropertySource({ "classpath:env/mail-${ambiente:casa}.properties" })
@PropertySource(value = { "file://${HOME}/.inspire-mail.properties" }, ignoreResourceNotFound = true) 
public class Mailer {

	@Autowired
	private Environment env;

	@Autowired
	private Session mailSender;

	@Async
	public void recuperarSenha(RecuperarSenhaDto recuperarSenhaDto) {
		StringBuilder sb = new StringBuilder();
		sb.append(
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
		sb.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
		sb.append("	<head>\n");
		sb.append("		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n");
		sb.append("		<title>Demystifying Email Design</title>\n");
		sb.append("		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n");
		sb.append("	</head>\n");
		sb.append("	<body style=\"margin: 0; padding: 0;\">\n");
		sb.append(
				"		<table  align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border-collapse: collapse;\">\n");
		sb.append("			<tr style=\"background-color: rgba(0, 0, 0, 0.3);\">\n");
		sb.append("				<td style=\"text-align: center\" colspan=\"2\">\n");
		sb.append("					<div>\n");
		sb.append("						<img src=\"cid:img_meta_logo\" alt=\"logo\" width=\"258\" height=\"82\"/>\n");
		sb.append("					</div>\n");
		sb.append("				</td>\n");
		sb.append("			</tr>\n");
		sb.append("			<tr>\n");
		sb.append("				<td colspan=\"2\">\n");
		sb.append("					<div style=\"height: 350px; padding: 20px;\">\n");
		sb.append("						<h3>Recuperação de Senha - Inspire Monitor</h3>\n");
		sb.append("						<br/>\n");
		sb.append("						<p>Conforme solicitado às ")
				.append(recuperarSenhaDto.getDataSolicitacao()
						.format(DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy")))
				.append(", segue a nova senha para acesso:</p>\n");
		sb.append("						<br/>\n");
		sb.append("						<p>Senha: <strong>").append(recuperarSenhaDto.getNovaSenha())
				.append("</strong></p>\n");
		sb.append("					</div>\n");
		sb.append("					<div style=\"padding-left: 20px; padding-bottom: 10px\">\n");
		sb.append("						Mensagem enviada automáticamente.\n");
		sb.append("					</div>\n");
		sb.append("				</td>\n");
		sb.append("			</tr>\n");
		sb.append("			<tr style=\"background-color: rgba(0, 0, 0, 0.3)\">\n");
		sb.append("				<td>\n");
		sb.append(
				"					<div style=\"padding-top: 18px; padding-bottom: 18px; vertical-align: middle; font-size: 15px\">\n");
		sb.append("						<div style=\"padding-left: 20px;\">\n");
		sb.append("							© 2017 Meta Solutions All rights reserved\n");
		sb.append("						</div>\n");
		sb.append("					</div>\n");
		sb.append("				</td>\n");
		sb.append("				<td style=\"text-align: right;\">\n");
		sb.append("					<div style=\"padding-right: 20px\">\n");
		sb.append(
				"						<a href=\"http://facebook.com/hipprintsocial\"><img src=\"cid:face\" style=\"width: 24px; height: 24px\" /></a>\n");
		sb.append(
				"						<a href=\"http://twitter.com/hipprint\"><img src=\"cid:twitter\" style=\"width: 24px; height: 24px\"/></a>\n");
		sb.append(
				"						<a href=\"https://www.linkedin.com/company-beta/1132328\"><img src=\"cid:link\" style=\"width: 24px; height: 24px\"/></a>\n");
		sb.append("					</div>\n");
		sb.append("				</td>\n");
		sb.append("			</tr>\n");
		sb.append("		</table>\n");
		sb.append("	</body>\n");
		sb.append("</html>\n");

		List<MimeBodyPart> imgs = new ArrayList<>();
		imgs.add(createBodyPart("img_meta_logo", "/imagem/img_meta_logo.png"));
		imgs.add(createBodyPart("face", "/imagem/face.png"));
		imgs.add(createBodyPart("twitter", "/imagem/twitter.png"));
		imgs.add(createBodyPart("link", "/imagem/link.png"));

		enviarEmail(recuperarSenhaDto.getEmail(), sb, imgs);
	}

	private void enviarEmail(String destinatario, StringBuilder corpo, List<MimeBodyPart> imgs, File... anexo) {
		try {
			Message message = new MimeMessage(mailSender);
			message.setFrom(new InternetAddress(env.getProperty("remetente.email")));

			Address[] toUser = InternetAddress.parse(destinatario);

			message.setReplyTo(new InternetAddress[] { new InternetAddress(env.getProperty("endereco.email")) });
			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("[MetaSolutions - Inspire Monitor] Recuperação de Senha");

			/** Corpo do e-mail em HTML */
			Multipart multipart = new MimeMultipart();
			MimeBodyPart attachment0 = new MimeBodyPart();
			attachment0.setContent(corpo.toString(), "text/html; charset=UTF-8");
			multipart.addBodyPart(attachment0);

			/** Anexo */
			if (anexo != null && anexo.length > 0) {
				for (File file : anexo) {
					if (file.exists() && file.length() > 0) {
						MimeBodyPart attachment1 = new MimeBodyPart();
						attachment1.setDataHandler(new DataHandler(new FileDataSource(file)));
						attachment1.setFileName(file.getName());
						multipart.addBodyPart(attachment1);
					}
				}
			}

			if (imgs != null) {
				for (MimeBodyPart m : imgs) {
					multipart.addBodyPart(m);
				}
			}
			message.setContent(multipart);

			/** Método para enviar a mensagem criada */
			Transport.send(message);
		} catch (MessagingException e) {
			System.out.println(Throwables.getStackTraceAsString(e));
		}
	}

	private MimeBodyPart createBodyPart(String cid, String recurso) {
		try {
			URL resource = getClass().getResource(recurso);
			File file = new File(resource.toURI());

			MimeBodyPart messageBodyPart = new MimeBodyPart();
			DataSource img = new FileDataSource(file);
			messageBodyPart.setDataHandler(new DataHandler(img));
			messageBodyPart.setHeader("Content-ID", "<" + cid + ">");
			messageBodyPart.setFileName(new File(recurso).getName());

			return messageBodyPart;
		} catch (Exception e) {
			System.out.println(Throwables.getStackTraceAsString(e));
		}
		return null;
	}
}
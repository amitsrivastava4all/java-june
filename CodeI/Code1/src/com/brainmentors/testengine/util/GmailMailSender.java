package com.brainmentors.testengine.util;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class GmailMailSender {
	
	private static Properties gmailProps(){
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		return props;
	}
	public static void sendMail(String from, String subject, String mailText){
		

		Session session = Session.getDefaultInstance(gmailProps(),
			new javax.mail.Authenticator() {
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("gmailuserid","gmailpassword");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("yourmailid"));
			message.setSubject(subject);
			message.setText(mailText);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
	public static void main(String[] args) {
		sendMail("abcd@yahoo.com","Test Mail","Hello How are You");
	}
}

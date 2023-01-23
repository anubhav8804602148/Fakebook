package com.ashar.fakebook.serviceImpl;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class CustomEmailService {
	
	@Value("${mail.username}")
	private static String username;
	@Value("${mail.password}")
	private static String password;
	@Value("${mail.host}")
	private static String host;
	@Value("${mail.port}")
	private static int port;
	
    public boolean sendNewMail(String toUser, String subject, String body) throws AddressException, MessagingException {
    	Properties properties = new Properties();
    	properties.put("mail.smtp.starttls.enable", true);
    	properties.put("mail.smtp.auth", true);
    	properties.put("mail.smtp.host", host);
    	
    	MimeMessage simpleMailMessage = new MimeMessage(Session.getInstance(properties, null));
    	simpleMailMessage.setFrom(new InternetAddress(username));
    	simpleMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toUser));
    	simpleMailMessage.setText(body);
    	simpleMailMessage.setSubject(subject);
    	
    	Transport.send(simpleMailMessage,username,password);
    	return true;
    }
}

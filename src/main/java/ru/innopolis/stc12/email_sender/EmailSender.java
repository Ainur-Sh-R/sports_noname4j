package ru.innopolis.stc12.email_sender;

import java.io.*;
import java.util.Properties;

public class EmailSender {
	private final static String PROPS_FILE = "email.properties";

	public static void sendEmail(String emailTo, String thema, String text) {

		try {
			InputStream is = new FileInputStream(PROPS_FILE);
			if (is != null) {
				Reader reader = new InputStreamReader(is, "UTF-8");
				Properties props = new Properties();
				props.load(reader);
				EmailService.SMTP_SERVER = props.getProperty("server");
				EmailService.SMTP_Port = props.getProperty("port");
				EmailService.EMAIL_FROM = props.getProperty("from");
				EmailService.SMTP_AUTH_USER = props.getProperty("user");
				EmailService.SMTP_AUTH_PWD = props.getProperty("pass");
				is.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		EmailService se = new EmailService(emailTo, thema);
		se.sendMessage(text);
		System.out.println("Сообщение отправлено");

	}

}

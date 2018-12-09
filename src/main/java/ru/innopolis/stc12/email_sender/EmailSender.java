package ru.innopolis.stc12.email_sender;

import java.io.*;
import java.util.Properties;

public class EmailSender {
	//private final static String PROPS_FILE = "email.properties";

	public static void sendEmail(String emailTo, String thema, String text) {

//		try {
//			InputStream is = EmailSender.class.getResourceAsStream(PROPS_FILE);
		//	if (is != null) {
			//	Reader reader = new InputStreamReader(is, "UTF-8");
//				Properties props = new Properties();
//				props.load(reader);
				EmailService.SMTP_SERVER = "smtp.yandex.ru";
				EmailService.SMTP_Port = "465";
				EmailService.EMAIL_FROM = "sportsnoname4j@yandex.ru";
				EmailService.SMTP_AUTH_USER = "sportsnoname4j@yandex.ru";
				EmailService.SMTP_AUTH_PWD = "spsnn4jmail";
				//is.close();
		//	}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		EmailService se = new EmailService(emailTo, thema);
		se.sendMessage(text);
	}

}

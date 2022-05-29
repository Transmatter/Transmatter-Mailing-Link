package transmatter.project.security.email.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@Service
public class EmailServiceImpl implements EmailService{
    @Override
    @SneakyThrows
    public void sendMail() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("transmatter.team@gmail.com", "Tmat@1739");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("tutorialspoint@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("oat431@gmail.com"));
        msg.setSubject("TP2 Mailing link");
        msg.setContent("<h1>Hi You just receive this email</h1>", "text/html");
        msg.setSentDate(new Date());

        Transport.send(msg);
    }
}

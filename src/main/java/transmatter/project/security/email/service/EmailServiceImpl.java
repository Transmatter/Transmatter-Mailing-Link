package transmatter.project.security.email.service;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Service
public class EmailServiceImpl implements EmailService{

    @Value("${spring.mail.username}")
    private String username;

    @Autowired
    JavaMailSender javaMailSender;

    @Override
    @SneakyThrows
    public void sendMail(String email) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        String subject = "TP2: Registration Link";
        helper.setSubject(subject);
        helper.setText("<h1>Hi This is the link</h1><br/><a href=https://www.youtube.com/watch?v=KGgOz_gRD_c>this link</a>", true);
        helper.setTo(email);
        helper.setFrom(username);
        javaMailSender.send(mimeMessage);
    }
}

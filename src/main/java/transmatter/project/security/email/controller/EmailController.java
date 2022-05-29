package transmatter.project.security.email.controller;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import transmatter.project.security.email.service.EmailService;

@Controller
public class EmailController {
    @Autowired
    EmailService emailService;
    @GetMapping(value = "/send-email")
    @SneakyThrows
    public ResponseEntity<?> sendEmail(){
        emailService.sendMail();
        return ResponseEntity.ok("Email was sent");
    }
}

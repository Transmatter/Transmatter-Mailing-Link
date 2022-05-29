package transmatter.project.security.email.service;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.IOException;

public interface EmailService {
    void sendMail() throws AddressException, MessagingException, IOException;
}

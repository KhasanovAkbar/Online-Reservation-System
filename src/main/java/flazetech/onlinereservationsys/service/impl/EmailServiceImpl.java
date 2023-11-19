package flazetech.onlinereservationsys.service.impl;

import flazetech.onlinereservationsys.model.User;
import flazetech.onlinereservationsys.repository.UserRepository;
import flazetech.onlinereservationsys.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class EmailServiceImpl implements EmailService {
    //
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private UserRepository userRepository;
    @Override
    public void sendActivationEmail(String to, String activationLink) {
        //
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("akbar.hasanov0630@gmail.com");
        mailMessage.setTo(to);
        mailMessage.setSubject("Bus Ticket Reservation System Activation");
        mailMessage.setText("Click the link below to activate your account:\n" + activationLink);

        try {
            javaMailSender.send(mailMessage);
        } catch (MailException e) {
            // Handle exception appropriately (log, etc.)
            e.printStackTrace();
        }
    }

    @Override
    public String generateActivationLink(User user) {
        // You can customize the activation link format as needed
        LocalDateTime expirationTime = LocalDateTime.now().plusHours(24);
        String formattedExpirationTime = expirationTime.format(DateTimeFormatter.ISO_DATE_TIME);

        user.setActivationLinkExpiration(expirationTime);

        userRepository.save(user);

        return "http://localhost:8080/auth/activate?user=" + user.getEmail() + "&expire=" + formattedExpirationTime;
    }
}

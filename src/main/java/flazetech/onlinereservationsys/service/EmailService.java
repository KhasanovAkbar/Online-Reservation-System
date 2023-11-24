package flazetech.onlinereservationsys.service;


public interface EmailService {
    //
    void sendActivationEmail(String to, String activationLink);

    String generateActivationLink(Long id);
}

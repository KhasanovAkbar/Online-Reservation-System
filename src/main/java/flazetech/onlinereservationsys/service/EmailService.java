package flazetech.onlinereservationsys.service;


import flazetech.onlinereservationsys.model.User;

public interface EmailService {
    //
    void sendActivationEmail(String to, String activationLink);
    String generateActivationLink(User user);
}

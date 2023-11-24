package flazetech.onlinereservationsys.service;

import flazetech.onlinereservationsys.dto.request.LoginRequest;

public interface AuthenticationService {

    String generateToken(String username, String password);

    boolean validateToken(String token, LoginRequest userDetails);
}

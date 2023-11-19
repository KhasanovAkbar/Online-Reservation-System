package flazetech.onlinereservationsys.service;

import flazetech.onlinereservationsys.dto.LoginDTO;

public interface AuthenticationService {

    String generateToken(String username, String password);

    boolean validateToken(String token, LoginDTO userDetails);
}

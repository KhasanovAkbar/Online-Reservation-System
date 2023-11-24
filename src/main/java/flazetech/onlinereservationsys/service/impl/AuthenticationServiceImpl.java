package flazetech.onlinereservationsys.service.impl;

import flazetech.onlinereservationsys.dto.request.LoginRequest;
import flazetech.onlinereservationsys.security.JwtTokenUtil;
import flazetech.onlinereservationsys.service.AuthenticationService;
import flazetech.onlinereservationsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    //
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;
    @Override
    public String generateToken(String username, String password) {
        //
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return jwtTokenUtil.generateToken(userDetails);
    }

    @Override
    public boolean validateToken(String token, LoginRequest userDetails) {
        //
        final String username = jwtTokenUtil.getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !jwtTokenUtil.isTokenExpired(token));

    }
}

package flazetech.onlinereservationsys.controller;

import flazetech.onlinereservationsys.dto.UserDTO;
import flazetech.onlinereservationsys.dto.request.LoginRequest;
import flazetech.onlinereservationsys.dto.response.LoginResponse;
import flazetech.onlinereservationsys.helper.APIResponse;
import flazetech.onlinereservationsys.helper.FailureMessage;
import flazetech.onlinereservationsys.helper.ResponseBuilder;
import flazetech.onlinereservationsys.model.User;
import flazetech.onlinereservationsys.model.enums.ActivationStatus;
import flazetech.onlinereservationsys.service.EmailService;
import flazetech.onlinereservationsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {
    //
    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/register")
    public ResponseEntity<APIResponse> registerUser(@RequestBody UserDTO userDTO) {
        //
        User registeredUser = userService.registerUser(userDTO);

        // Generate activation link
        String activationLink = emailService.generateActivationLink(registeredUser.getId());

        // Send activation email to the user
        emailService.sendActivationEmail(registeredUser.getEmail(), activationLink);
        FailureMessage failureMessage = new FailureMessage();
        failureMessage.setExceptionMessage("Test Register");
        failureMessage.setExceptionName("Registration Error");

        return ResponseBuilder.buildOK("Registration successful! Activation link sent to your email.", failureMessage, HttpStatus.OK);
    }

    @GetMapping("/activate")
    public ResponseEntity<APIResponse> activateUser(@RequestParam String user, @RequestParam String expire) {
        // Validate the activation link (check expiration time, etc.)
        // ... (You need to implement this logic)

        // Activate the user in the UserService
        userService.activateUser(user);

        return ResponseBuilder.buildOK("Account activated successfully!", null, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<APIResponse> loginUser(@RequestBody LoginRequest loginRequest) {
        // Retrieve the user by email

        User existingUser = userService.findByEmail(loginRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));;
        // Check if the provided password matches the stored hashed password
        if (userService.checkPassword(loginRequest.getPassword(), existingUser.getPassword())) {
            // Check the activation status
            if (existingUser.getActivationStatus() == ActivationStatus.ACTIVATED) {
                LoginResponse loginResponse = userService.saveLoginUser(existingUser.getId());
                return ResponseBuilder.buildOK(loginResponse, null, HttpStatus.OK);

            } else if (existingUser.getActivationStatus() == ActivationStatus.PENDING) {
                FailureMessage failureMessage = new FailureMessage();
                failureMessage.setExceptionMessage("Account not activated. Check your email for activation link.");
                failureMessage.setExceptionName("Login Error");
                return ResponseBuilder.buildOK(existingUser, failureMessage, HttpStatus.BAD_REQUEST);
            } else {
                FailureMessage failureMessage = new FailureMessage();
                failureMessage.setExceptionMessage("Activation link expired. Please register again.");
                failureMessage.setExceptionName("Login Error");
                return ResponseBuilder.buildOK(existingUser, failureMessage, HttpStatus.BAD_REQUEST);

            }
        } else {
            FailureMessage failureMessage = new FailureMessage();
            failureMessage.setExceptionMessage("Invalid credentials");
            failureMessage.setExceptionName("Login Error");
            return ResponseBuilder.buildOK(null, failureMessage, HttpStatus.BAD_REQUEST);
        }
    }
}

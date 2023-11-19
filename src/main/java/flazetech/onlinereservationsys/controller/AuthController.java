package flazetech.onlinereservationsys.controller;

import flazetech.onlinereservationsys.dto.LoginDTO;
import flazetech.onlinereservationsys.dto.UserDTO;
import flazetech.onlinereservationsys.model.User;
import flazetech.onlinereservationsys.model.enums.ActivationStatus;
import flazetech.onlinereservationsys.service.EmailService;
import flazetech.onlinereservationsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
        //
        User registeredUser = userService.registerUser(userDTO);

        // Generate activation link
        String activationLink = emailService.generateActivationLink(registeredUser);

        // Send activation email to the user
        emailService.sendActivationEmail(registeredUser.getEmail(), activationLink);


        return ResponseEntity.ok("Registration successful! Activation link sent to your email.");
    }

    @GetMapping("/activate")
    public ResponseEntity<String> activateUser(@RequestParam String user, @RequestParam String expire) {
        // Validate the activation link (check expiration time, etc.)
        // ... (You need to implement this logic)

        // Activate the user in the UserService
        userService.activateUser(user);

        return ResponseEntity.ok("Account activated successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginDTO loginDTO) {
        // Retrieve the user by email

        User existingUser = userService.findByEmail(loginDTO.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Check if the provided password matches the stored hashed password
        if (userService.checkPassword(loginDTO.getPassword(), existingUser.getPassword())) {
            // Check the activation status
            if (existingUser.getActivationStatus() == ActivationStatus.ACTIVATED) {
                return ResponseEntity.ok("Login successful!");


            } else if (existingUser.getActivationStatus() == ActivationStatus.PENDING) {
                return ResponseEntity.badRequest().body("Account not activated. Check your email for activation link.");
            } else {
                return ResponseEntity.badRequest().body("Activation link expired. Please register again.");
            }
        } else {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }
}

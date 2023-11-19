package flazetech.onlinereservationsys.service.impl;

import flazetech.onlinereservationsys.dto.UserDTO;
import flazetech.onlinereservationsys.model.User;
import flazetech.onlinereservationsys.model.enums.ActivationStatus;
import flazetech.onlinereservationsys.repository.UserRepository;
import flazetech.onlinereservationsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    //
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Optional<User> findByEmail(String email) {
        //
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findById(Long id) {
        //
        return userRepository.findById(id);
    }

    @Override
    public User saveUser(User user) {
        // Encode the password before saving it to the database
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User registerUser(UserDTO userDTO) {
        //
        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email is already in use");
        }

        // Check if the password and confirm password match (client-side validation)
        if (!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
            throw new IllegalArgumentException("Password and confirm password do not match");
        }
        String encode = passwordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(encode);
        // Map UserDTO to User entity
        User user = mapUserDTOToUser(userDTO);

        // Save the user after encoding the password and mark as not activated
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActivationStatus(ActivationStatus.PENDING); // Set activation status to pending

        return userRepository.save(user);
    }

    @Override
    public boolean checkPassword(String rawPassword, String encodedPassword) {
        //
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    @Override
    public void activateUser(String email) {
        //
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Check if the activation link is still valid (not expired)
        LocalDateTime expirationTime = user.getActivationLinkExpiration();
        if (expirationTime == null || expirationTime.isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Activation link has expired");
        }

        // Update the user's activation status
        user.setActivationStatus(ActivationStatus.ACTIVATED);
        userRepository.save(user);
    }

    private User mapUserDTOToUser(UserDTO userDTO) {
        //
        User user = new User();
        user.setFullName(userDTO.getFullName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return user;
    }
}

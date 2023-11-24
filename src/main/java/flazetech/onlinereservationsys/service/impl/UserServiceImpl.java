package flazetech.onlinereservationsys.service.impl;

import flazetech.onlinereservationsys.dto.UserDTO;
import flazetech.onlinereservationsys.dto.response.LoginResponse;
import flazetech.onlinereservationsys.model.User;
import flazetech.onlinereservationsys.model.enums.ActivationStatus;
import flazetech.onlinereservationsys.repository.UserRepository;
import flazetech.onlinereservationsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
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
    public void saveUser(User user) {
        //
        userRepository.save(user);
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
        // Save the user after encoding the password and mark as not activated
        userDTO.setActivationStatus(ActivationStatus.PENDING); // Set activation status to pending

        // UserDTO to User entity
        User user = User.fromDomain(userDTO);

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
        String responseMsg;
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        ;
        // Check if the activation link is still valid (not expired)
        LocalDateTime expirationTime = user.getActivationLinkExpiration();
        if (expirationTime == null || expirationTime.isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Activation link has expired");
        }

        // Update the user's activation status
        user.setActivationStatus(ActivationStatus.ACTIVATED);
        userRepository.save(user);

    }

    @Override
    public LoginResponse saveLoginUser(Long id) {
        //
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User id not found"));
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        user.setLonginDate(dateFormat.format(date));
        saveUser(user);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUserId(user.getId());
        loginResponse.setFullName(user.getFullName());
        loginResponse.setEmail(user.getEmail());
        loginResponse.setLoginDate(user.getLonginDate());
        loginResponse.setUserStatus(user.getStatus());

        return loginResponse;
    }
}

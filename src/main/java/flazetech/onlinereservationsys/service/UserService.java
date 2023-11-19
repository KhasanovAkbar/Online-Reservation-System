package flazetech.onlinereservationsys.service;


import flazetech.onlinereservationsys.dto.UserDTO;
import flazetech.onlinereservationsys.model.User;

import java.util.Optional;

public interface UserService {
    //
    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);
    User saveUser(User user);
    User registerUser(UserDTO userDTO);
    boolean checkPassword(String rawPassword, String encodedPassword);

    void activateUser(String username);
}

package flazetech.onlinereservationsys.service;


import flazetech.onlinereservationsys.dto.response.LoginResponse;
import flazetech.onlinereservationsys.dto.UserDTO;
import flazetech.onlinereservationsys.model.User;

import java.util.Optional;

public interface UserService {
    //
    Optional<User> findByEmail(String email);
    void saveUser(User user);
    User registerUser(UserDTO userDTO);
    boolean checkPassword(String rawPassword, String encodedPassword);
    void activateUser(String username);
    LoginResponse saveLoginUser(Long id);


}

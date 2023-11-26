package flazetech.onlinereservationsys.service;


import flazetech.onlinereservationsys.dto.response.AllReservation;
import flazetech.onlinereservationsys.dto.response.LoginResponse;
import flazetech.onlinereservationsys.dto.UserDTO;
import flazetech.onlinereservationsys.dto.response.ReservationResponse;
import flazetech.onlinereservationsys.model.Reservation;
import flazetech.onlinereservationsys.model.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {
    //
    Optional<User> findByEmail(String email);
    void saveUser(User user);
    User registerUser(UserDTO userDTO);
    boolean checkPassword(String rawPassword, String encodedPassword);
    void activateUser(String username);
    LoginResponse saveLoginUser(Long id);
    AllReservation getAllReservationsByUserId(Long userId);


}

package flazetech.onlinereservationsys.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDTO {
    //
    private String fullName;
    private String email;
    private String password;
    private String confirmPassword;
    private String userStatus;

}

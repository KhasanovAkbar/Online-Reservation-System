package flazetech.onlinereservationsys.dto;

import flazetech.onlinereservationsys.model.enums.UserStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    //
    private String fullName;
    private String email;
    private String password;
    private String confirmPassword;
    private String longinDate;
    private UserStatus status;

}

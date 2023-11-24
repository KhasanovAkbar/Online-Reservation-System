package flazetech.onlinereservationsys.dto;

import flazetech.onlinereservationsys.model.enums.ActivationStatus;
import flazetech.onlinereservationsys.model.enums.UserStatus;
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
    private String longinDate;
    private UserStatus status;
    private LocalDateTime activationLinkExpiration;
    private ActivationStatus activationStatus;


}

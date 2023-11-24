package flazetech.onlinereservationsys.dto.response;

import flazetech.onlinereservationsys.model.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    //
    private Long userId;
    private String fullName;
    private String email;
    private String loginDate;
    private UserStatus userStatus;
}

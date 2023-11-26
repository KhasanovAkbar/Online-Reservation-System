package flazetech.onlinereservationsys.dto.response;

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
    private String userId;
    private String fullName;
    private String email;
    private String loginDate;
    private String userStatus;
}

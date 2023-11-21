package flazetech.onlinereservationsys.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO {

    public ResponseDTO() {
    }

    private Long userId;
    private String fullName;
    private String email;
    private String loginDate;
}

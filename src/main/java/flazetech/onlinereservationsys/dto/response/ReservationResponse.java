package flazetech.onlinereservationsys.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ReservationResponse {
    //
    private Long id;
    private String firstName;
    private String lastName;
    private String fromCity;
    private String toCity;
    private String reservationTime;
    private String userStatus;


}

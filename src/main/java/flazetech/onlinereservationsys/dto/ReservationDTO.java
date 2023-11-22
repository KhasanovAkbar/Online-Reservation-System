package flazetech.onlinereservationsys.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationDTO {
    //
    private String userId;
    private String firstName;
    private String lastName;
    private String fromCity;
    private String toCity;
    private String reservationTime;
}

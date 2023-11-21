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
    private PolandCity fromCity;
    private PolandCity toCity;
    private String reservationTime;
}

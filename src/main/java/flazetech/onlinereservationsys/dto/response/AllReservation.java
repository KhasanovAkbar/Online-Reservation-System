package flazetech.onlinereservationsys.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class AllReservation {
    //
    private String fullName;
    private String email;
    private String status;
    private List<ReservationResponse> reservations;
}

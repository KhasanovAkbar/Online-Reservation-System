package flazetech.onlinereservationsys.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationDTO {
    private Long userId;
    private String fromCity;
    private String toCity;
    private LocalDateTime reservationTime;
}

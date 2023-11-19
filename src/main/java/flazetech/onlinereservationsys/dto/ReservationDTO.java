package flazetech.onlinereservationsys.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import flazetech.onlinereservationsys.model.enums.PolandCity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationDTO {
    //
    private Long userId;
    private PolandCity fromCity;
    private PolandCity toCity;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime reservationTime;
}

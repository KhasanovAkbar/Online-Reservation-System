package flazetech.onlinereservationsys.service;

import flazetech.onlinereservationsys.dto.ReservationDTO;
import flazetech.onlinereservationsys.model.Reservation;

import java.time.LocalDateTime;

public interface ReservationService {
    //
    Reservation makeReservation(ReservationDTO reservationDTO);

}

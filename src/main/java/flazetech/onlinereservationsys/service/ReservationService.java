package flazetech.onlinereservationsys.service;

import flazetech.onlinereservationsys.dto.ReservationDTO;
import flazetech.onlinereservationsys.model.Reservation;

import java.util.Set;

public interface ReservationService {
    //
    void makeReservation(ReservationDTO reservationDTO);

    Set<Reservation> getAllReservations();

}

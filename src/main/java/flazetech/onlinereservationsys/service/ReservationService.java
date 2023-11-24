package flazetech.onlinereservationsys.service;

import flazetech.onlinereservationsys.dto.ReservationDTO;
import flazetech.onlinereservationsys.model.Reservation;

import java.util.List;

public interface ReservationService {
    //
    void makeReservation(ReservationDTO reservationDTO);

    List<ReservationDTO> getAllReservations(Long userId);

}

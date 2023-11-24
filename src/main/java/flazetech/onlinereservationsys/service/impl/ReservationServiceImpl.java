package flazetech.onlinereservationsys.service.impl;


import flazetech.onlinereservationsys.dto.ReservationDTO;
import flazetech.onlinereservationsys.model.Reservation;
import flazetech.onlinereservationsys.repository.ReservationRepository;
import flazetech.onlinereservationsys.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    //
    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public void makeReservation(ReservationDTO reservationDTO) {
        //
        Reservation reservation = mapReservationDTOToReservation(reservationDTO);
        reservationRepository.save(reservation);
    }

    @Override
    public List<ReservationDTO> getAllReservations(Long userId) {
        //
        List<Reservation> allByUserId = reservationRepository.getAllByUserId(userId);
        return Reservation.toDomain(allByUserId);
    }

    private Reservation mapReservationDTOToReservation(ReservationDTO reservationDTO) {
        //
        Reservation reservation = new Reservation();
        reservation.setUserId(Long.valueOf(reservationDTO.getUserId()));
        reservation.setFirstName(reservationDTO.getFirstName());
        reservation.setLastName(reservationDTO.getLastName());
        reservation.setFromCity(reservationDTO.getFromCity());
        reservation.setToCity(reservationDTO.getToCity());
        reservation.setReservationDate(reservationDTO.getReservationTime());

        return reservation;
    }
}

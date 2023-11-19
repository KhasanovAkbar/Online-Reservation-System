package flazetech.onlinereservationsys.service.impl;


import flazetech.onlinereservationsys.dto.ReservationDTO;
import flazetech.onlinereservationsys.model.Reservation;
import flazetech.onlinereservationsys.repository.ReservationRepository;
import flazetech.onlinereservationsys.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public Reservation makeReservation(ReservationDTO reservationDTO) {
        //
        Reservation reservation = mapReservationDTOToReservation(reservationDTO);
        return reservationRepository.save(reservation);
    }

    private Reservation mapReservationDTOToReservation(ReservationDTO reservationDTO) {
        //
        Reservation reservation = new Reservation();
        reservation.setUserId(reservationDTO.getUserId());
        reservation.setFromCity(reservationDTO.getFromCity());
        reservation.setToCity(reservationDTO.getToCity());
        reservation.setReservationDate(reservationDTO.getReservationTime());

        return reservation;
    }
}

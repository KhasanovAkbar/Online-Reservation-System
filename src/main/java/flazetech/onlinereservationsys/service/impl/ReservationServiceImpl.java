package flazetech.onlinereservationsys.service.impl;


import flazetech.onlinereservationsys.dto.ReservationDTO;
import flazetech.onlinereservationsys.model.Reservation;
import flazetech.onlinereservationsys.model.User;
import flazetech.onlinereservationsys.repository.ReservationRepository;
import flazetech.onlinereservationsys.repository.UserRepository;
import flazetech.onlinereservationsys.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ReservationServiceImpl implements ReservationService {
    //
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void makeReservation(ReservationDTO reservationDTO) {
        //
        Long userId = reservationDTO.getUserId();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Reservation reservation = Reservation.fromDomain(reservationDTO);
        reservation.setUser(user);
        reservationRepository.save(reservation);
    }

    @Override
    public Set<Reservation> getAllReservations() {
        //
        return new HashSet<>(reservationRepository.findAll());

       /* User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return reservationRepository.getAllByUser(user);*/
    }
}

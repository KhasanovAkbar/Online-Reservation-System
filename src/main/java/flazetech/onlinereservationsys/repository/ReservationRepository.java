package flazetech.onlinereservationsys.repository;

import flazetech.onlinereservationsys.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> getAllByUserId(Long userId);
}

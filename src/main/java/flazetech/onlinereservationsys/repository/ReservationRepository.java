package flazetech.onlinereservationsys.repository;

import flazetech.onlinereservationsys.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}

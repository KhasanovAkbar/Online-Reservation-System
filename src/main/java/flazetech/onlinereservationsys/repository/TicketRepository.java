package flazetech.onlinereservationsys.repository;

import flazetech.onlinereservationsys.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    //
}

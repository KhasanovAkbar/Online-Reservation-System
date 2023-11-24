package flazetech.onlinereservationsys.service;

import flazetech.onlinereservationsys.dto.TicketDTO;
import flazetech.onlinereservationsys.model.enums.SeatType;

import java.util.List;

public interface TicketService {
    //
//    double calculateTicketPrice(String seatType, UserDTO userDTO);
    TicketDTO getTicketById(Long ticketId);

    TicketDTO createTicket(SeatType seatType, double price);

    TicketDTO updateTicket(Long ticketId, SeatType seatType, double price);

    void deleteTicket(Long ticketId);

    List<TicketDTO> getAllTickets();
}

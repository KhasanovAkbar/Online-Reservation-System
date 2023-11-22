package flazetech.onlinereservationsys.service;

import flazetech.onlinereservationsys.dto.UserDTO;
import flazetech.onlinereservationsys.model.Ticket;
import flazetech.onlinereservationsys.model.enums.SeatType;

public interface TicketService {
    //
//    double calculateTicketPrice(String seatType, UserDTO userDTO);
    Ticket createTicket(SeatType seatType, double price);
    Ticket updateTicket(Long ticketId, SeatType seatType, double price);
    void deleteTicket(Long ticketId);
}

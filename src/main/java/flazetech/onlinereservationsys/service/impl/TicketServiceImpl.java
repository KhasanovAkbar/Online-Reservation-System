package flazetech.onlinereservationsys.service.impl;

import flazetech.onlinereservationsys.dto.TicketDTO;
import flazetech.onlinereservationsys.model.Ticket;
import flazetech.onlinereservationsys.model.enums.SeatType;
import flazetech.onlinereservationsys.repository.TicketRepository;
import flazetech.onlinereservationsys.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {
    //
    @Autowired
    TicketRepository ticketRepository;

   /* private static final double BASE_PRICE_STANDARD = 50.0;
    private static final double BASE_PRICE_PREMIUM = 100.0;
    private static final double STUDENT_DISCOUNT = 0.2;
    private static final double SENIOR_DISCOUNT = 0.15;

    @Override
    public double calculateTicketPrice(String seatType, UserDTO userDTO) {
        double basePrice = getBasePrice(seatType);
        double discount = getDiscount(userDTO.getStatus());
        return basePrice * (1 - discount);
    }

    private double getBasePrice(String seatType) {
        // Adjust the base prices based on seat type
        if ("premium".equalsIgnoreCase(seatType)) {
            return BASE_PRICE_PREMIUM;
        } else {
            return BASE_PRICE_STANDARD;
        }
    }

    private double getDiscount(UserStatus status) {
        return switch (status) {
            case STUDENT -> STUDENT_DISCOUNT;
            case SENIOR -> SENIOR_DISCOUNT;
            default -> 0.0; // No discount for regular status
        };
    }*/

    @Override
    public TicketDTO getTicketById(Long ticketId) {
        //
        return ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found")).toDomain();

    }

    @Override
    public TicketDTO createTicket(SeatType seatType, double price) {
        //
        TicketDTO ticketDTO = new TicketDTO(seatType, price);
        Ticket ticket = Ticket.fromDomain(ticketDTO);
        return ticketRepository.save(ticket).toDomain();
    }

    @Override
    public TicketDTO updateTicket(Long ticketId, SeatType seatType, double price) {
        //
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();
            ticket.setSeatType(seatType);
            ticket.setPrice(price);
            return ticketRepository.save(ticket).toDomain();
        }
        return null;
    }

    @Override
    public void deleteTicket(Long ticketId) {
        //
        ticketRepository.deleteById(ticketId);
    }

    @Override
    public List<TicketDTO> getAllTickets() {
        //
        List<Ticket> all = ticketRepository.findAll();
        return Ticket.toDomain(all);
    }
}

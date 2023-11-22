package flazetech.onlinereservationsys.model;

import flazetech.onlinereservationsys.dto.TicketDTO;
import flazetech.onlinereservationsys.model.enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tickets")
public class Ticket {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_type", nullable = false)
    private SeatType seatType;

    @Column(name = "price", nullable = false)
    private double price;

    public Ticket(TicketDTO ticketDTO) {
        BeanUtils.copyProperties(ticketDTO, this);
    }

    public TicketDTO toDomain() {
        //
        TicketDTO ticketDTO = new TicketDTO();
        BeanUtils.copyProperties(this, ticketDTO);
        return ticketDTO;
    }

    public static Ticket fromDomain(TicketDTO ticketDTO) {
        //
        Ticket ticket = new Ticket();
        BeanUtils.copyProperties(ticketDTO, ticket);
        return ticket;
    }
}

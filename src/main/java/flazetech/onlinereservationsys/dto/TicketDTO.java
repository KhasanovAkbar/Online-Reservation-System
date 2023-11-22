package flazetech.onlinereservationsys.dto;

import flazetech.onlinereservationsys.model.Ticket;
import flazetech.onlinereservationsys.model.enums.SeatType;
import flazetech.onlinereservationsys.service.TicketService;
import org.springframework.beans.BeanUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO {
    //
    private SeatType seatType;
    private double price;
    }

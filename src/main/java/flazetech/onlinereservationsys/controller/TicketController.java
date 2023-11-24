package flazetech.onlinereservationsys.controller;

import flazetech.onlinereservationsys.dto.TicketDTO;
import flazetech.onlinereservationsys.helper.APIResponse;
import flazetech.onlinereservationsys.helper.ResponseBuilder;
import flazetech.onlinereservationsys.model.Ticket;
import flazetech.onlinereservationsys.model.enums.SeatType;
import flazetech.onlinereservationsys.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {
    //
    @Autowired
    private TicketService ticketService;

    @GetMapping("/tickets")
    public ResponseEntity<APIResponse> getAllTickets() {
        //
        Stream<Ticket> tickets = ticketService.getAllTickets().stream().map(Ticket::fromDomain);
        return ResponseBuilder.buildOk(Collections.singletonList(tickets));
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<APIResponse> getTicketById(@PathVariable Long ticketId) {
        //
        TicketDTO ticketDTO = ticketService.getTicketById(ticketId);
        Ticket ticket = Ticket.fromDomain(ticketDTO);
        return ResponseBuilder.buildOK(ticket, null, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<APIResponse> createTicket(@RequestParam SeatType seatType, @RequestParam double price) {
        //
        TicketDTO ticketDTO = ticketService.createTicket(seatType, price);
        Ticket ticket = Ticket.fromDomain(ticketDTO);
        return ResponseBuilder.buildOK(ticket, null, HttpStatus.OK);
    }

    @DeleteMapping("/{ticketId}")
    public ResponseEntity<APIResponse> deleteTicket(@PathVariable Long ticketId) {
        //
        ticketService.deleteTicket(ticketId);
        return ResponseBuilder.buildOK("Ticket successfully deleted", null, HttpStatus.OK);
    }
}

package flazetech.onlinereservationsys.controller;

import flazetech.onlinereservationsys.dto.ReservationDTO;
import flazetech.onlinereservationsys.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/reservations")
    public ResponseEntity<String> makeReservation(@RequestBody ReservationDTO reservationRequest) {
        //
        reservationService.makeReservation(
                reservationRequest
        );

        return ResponseEntity.ok("Buss successfully reserved");
    }

}

package flazetech.onlinereservationsys.controller;

import flazetech.onlinereservationsys.dto.ReservationDTO;
import flazetech.onlinereservationsys.helper.APIResponse;
import flazetech.onlinereservationsys.helper.ResponseBuilder;
import flazetech.onlinereservationsys.model.Reservation;
import flazetech.onlinereservationsys.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/reservations")
    public ResponseEntity<APIResponse> makeReservation(@RequestBody ReservationDTO reservationRequest) {
        //
        reservationService.makeReservation(reservationRequest);
        return ResponseBuilder.buildOK("Buss successfully reserved", null, HttpStatus.OK);
    }

    @GetMapping("/reservations/user/{userId}")
    public ResponseEntity<APIResponse> getAllReservations(@PathVariable String userId) {
        //
        List<ReservationDTO> allReservations = reservationService.getAllReservations(Long.valueOf(userId));
        return ResponseBuilder.buildOk(Collections.singletonList(allReservations));
    }

}

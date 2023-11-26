package flazetech.onlinereservationsys.controller;

import flazetech.onlinereservationsys.dto.ReservationDTO;
import flazetech.onlinereservationsys.dto.response.AllReservation;
import flazetech.onlinereservationsys.helper.APIResponse;
import flazetech.onlinereservationsys.helper.ResponseBuilder;
import flazetech.onlinereservationsys.service.ReservationService;
import flazetech.onlinereservationsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<APIResponse> makeReservation(@RequestBody ReservationDTO reservationDTO) {
        //
        reservationService.makeReservation(reservationDTO);
        return ResponseBuilder.buildOK("Buss successfully reserved", null, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<APIResponse> getAllReservations(@PathVariable String userId) {
        //
        AllReservation allReservationsByUserId = userService.getAllReservationsByUserId(Long.valueOf(userId));
        return ResponseBuilder.buildOK(allReservationsByUserId, null, HttpStatus.OK);
    }

}

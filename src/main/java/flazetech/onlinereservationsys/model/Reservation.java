package flazetech.onlinereservationsys.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "reservations")
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "from_city")
    private String fromCity;

    @Column(name = "to_city")
    private String toCity;

    @Column(name = "bus_service")
    private String busService;

    @Column(name = "reservation_date")
    private Date reservationDate;
}

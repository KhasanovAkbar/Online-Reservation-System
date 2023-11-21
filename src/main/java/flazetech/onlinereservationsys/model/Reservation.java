package flazetech.onlinereservationsys.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private PolandCity fromCity;

    @Enumerated(EnumType.STRING)
    private PolandCity toCity;

    @Column(name = "reservation_date")
    private String reservationDate;
}

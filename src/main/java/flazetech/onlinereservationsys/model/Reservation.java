package flazetech.onlinereservationsys.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import flazetech.onlinereservationsys.model.enums.PolandCity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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

    @Enumerated(EnumType.STRING)
    private PolandCity fromCity;

    @Enumerated(EnumType.STRING)
    private PolandCity toCity;

    @Column(name = "reservation_date")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime reservationDate;
}

package flazetech.onlinereservationsys.model;

import flazetech.onlinereservationsys.dto.ReservationDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "reservations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String fromCity;

    private String toCity;

    @Column(name = "status")
    private String userStatus;

    @Column(name = "reservation_date")
    private String reservationDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public Reservation(ReservationDTO reservationDTO) {
        //
        BeanUtils.copyProperties(reservationDTO, this);
    }

    public ReservationDTO toDomain() {
        //
        ReservationDTO responseDTO = new ReservationDTO();
        BeanUtils.copyProperties(this, responseDTO);
        return responseDTO;
    }

    public static Reservation fromDomain(ReservationDTO reservationDTO) {
        //
        Reservation reservation = new Reservation();
        BeanUtils.copyProperties(reservationDTO, reservation);
        return reservation;
    }

    public static List<ReservationDTO> toDomain(List<Reservation> reservationList) {
        //
        return reservationList.stream().map(Reservation::toDomain).collect(Collectors.toList());
    }

}

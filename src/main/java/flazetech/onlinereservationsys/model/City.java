package flazetech.onlinereservationsys.model;

import flazetech.onlinereservationsys.model.enums.PolandCity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class City {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PolandCity cityName;
    public City() {
    }

    public City(PolandCity cityName) {
        this.cityName = cityName;
    }
}

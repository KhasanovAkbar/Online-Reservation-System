package flazetech.onlinereservationsys.repository;

import flazetech.onlinereservationsys.model.City;
import flazetech.onlinereservationsys.model.enums.PolandCity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
    //
    City findByCityName(PolandCity cityName);
}

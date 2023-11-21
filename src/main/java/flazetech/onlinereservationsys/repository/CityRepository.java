package flazetech.onlinereservationsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
    //
    City findByCityName(PolandCity cityName);
}

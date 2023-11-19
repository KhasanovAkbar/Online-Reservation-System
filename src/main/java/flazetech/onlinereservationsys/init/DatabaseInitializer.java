package flazetech.onlinereservationsys.init;

import flazetech.onlinereservationsys.model.City;
import flazetech.onlinereservationsys.model.enums.PolandCity;
import flazetech.onlinereservationsys.repository.CityRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DatabaseInitializer {
    //
    @Autowired
    private CityRepository cityRepository;

    @PostConstruct
    public void initializeDatabase() {
        // Add Poland cities to the database
        Arrays.stream(PolandCity.values())
                .forEach(cityName -> {
                    City city = new City(cityName);
                    if (cityRepository.findByCityName(cityName) == null) {
                        cityRepository.save(city);
                    }
                });
    }
}

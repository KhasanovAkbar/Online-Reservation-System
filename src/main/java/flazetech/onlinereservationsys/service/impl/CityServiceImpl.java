package flazetech.onlinereservationsys.service.impl;

import flazetech.onlinereservationsys.model.City;
import flazetech.onlinereservationsys.model.enums.PolandCity;
import flazetech.onlinereservationsys.repository.CityRepository;
import flazetech.onlinereservationsys.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {
    //
    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<PolandCity> getAllCities() {
        //
        List<City> cities = cityRepository.findAll();
        return cities.stream().map(City::getCityName).collect(Collectors.toList());

    }
}

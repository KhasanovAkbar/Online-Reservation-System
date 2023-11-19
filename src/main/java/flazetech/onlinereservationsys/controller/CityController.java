package flazetech.onlinereservationsys.controller;

import flazetech.onlinereservationsys.model.enums.PolandCity;
import flazetech.onlinereservationsys.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CityController {
    //
    @Autowired
    private CityService cityService;

    @GetMapping("/cities")
    public List<PolandCity> getAllCities() {
        //
        return cityService.getAllCities();
    }
}

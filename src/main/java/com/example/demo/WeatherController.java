package com.example.demo;

import com.example.demo.domain.Weather;
import com.example.demo.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@CrossOrigin
@RestController
public class WeatherController {

    Logger logger = LoggerFactory.getLogger(WeatherController.class);

    @Value("${app.defaultcity}")
    private String defaultCity;
    @Value("${app.defaultcountry}")
    private String defaultCountry;

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    /**
     * Gets the current temperature for the specified city and country.
     * The parameter are optional. If not specified the default values provided in application.properties are taken.
     *
     * @param city
     * @param country If city is specified and country is empty, the search will be made with empty country.
     * @return The current weather information
     */
    @GetMapping("/temperature")
    public Weather getCurrentTemperature(@RequestParam Optional<String> city, @RequestParam Optional<String> country) {
        logger.info("getCurrentTemperature called for city " + city.orElse("not specified") + " and country " + country.orElse("not specified") + "...");

        String cityString = city.orElse(defaultCity);
        Optional<String> countryString;

        if (city.isPresent()) {
            countryString = country;
        } else {
            // If city not specified take default country
            countryString = Optional.ofNullable(defaultCountry);
        }

        return weatherService.getCurrentTemperature(cityString, countryString);
    }
}

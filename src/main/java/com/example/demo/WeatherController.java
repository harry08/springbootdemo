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
import java.util.StringTokenizer;

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
     * The parameter is optional. If not specified the default value provided in application.properties is taken.
     * @param q city name and country code divided by comma, use ISO 3166 country codes.
     * @return The current weather information
     */
    @GetMapping("/temperature")
    public Weather getCurrentTemperature(@RequestParam(required = false) String q) {
        if (q == null) {
            logger.info("getCurrentTemperature called...");
        } else {
            logger.info("getCurrentTemperature called for city " + q + "...");
        }

        String city;
        Optional<String> country = Optional.empty();
        if (q != null) {
            StringTokenizer tokenizer = new StringTokenizer(q, ",");
            city = tokenizer.nextToken();
            if (tokenizer.hasMoreTokens()) {
                country = Optional.of(tokenizer.nextToken());
            }
        } else {
            city = defaultCity;
            country = Optional.ofNullable(defaultCountry);
        }
        return weatherService.getCurrentTemperature(city, country);
    }
}

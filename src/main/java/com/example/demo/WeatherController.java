package com.example.demo;

import com.example.demo.domain.Weather;
import com.example.demo.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class WeatherController {

    Logger logger = LoggerFactory.getLogger(WeatherController.class);

    private final WeatherService weatherService;
    
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/temperature")
    public Weather getCurrentTemperature() {
        logger.info("getCurrentTemperature called...");

        return weatherService.getCurrentTemperature();
    }
}

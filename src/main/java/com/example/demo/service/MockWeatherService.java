package com.example.demo.service;

import com.example.demo.domain.TemperatureScale;
import com.example.demo.domain.Weather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Mock implementation of WeatherService.
 * Returns static values.
 */
@Service
@Profile("!prod")
public class MockWeatherService implements WeatherService {

    Logger logger = LoggerFactory.getLogger(MockWeatherService.class);
    
    @Override
    public Weather getCurrentTemperature(String city, Optional<String> country) {
        logger.info("getCurrentTemperature called for city " + city + "," + country.orElse("country not specified") + "...");
        return new Weather(37D, TemperatureScale.CELSIUS, 75, city);
    }
}

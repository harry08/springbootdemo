package com.example.demo.service;

import com.example.demo.domain.TemperatureScale;
import com.example.demo.domain.Weather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("!prod")
public class MockWeatherService implements WeatherService {

    Logger logger = LoggerFactory.getLogger(MockWeatherService.class);
    
    @Override
    public Weather getCurrentTemperature() {
        logger.info("getCurrentTemperature called...");
        Weather weather = new Weather();
        weather.setTemperatureScale(TemperatureScale.CELSIUS);
        weather.setTemperature(37D);
        weather.setHumidity(75);

        return weather;
    }
}

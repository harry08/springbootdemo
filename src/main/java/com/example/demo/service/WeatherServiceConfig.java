package com.example.demo.service;

import com.example.demo.service.openweather.OWMWeatherService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * the OWMWeatherService is potentially available in a module outside of this project.
 * Therefore it can not be annotated with profile annotation.
 * This annotation is done in this configuration class.
 */
@Configuration
public class WeatherServiceConfig {

    @Bean
    @Profile("prod")
    public WeatherService getOWMWeatherService() {
        return new OWMWeatherService();
    }
}

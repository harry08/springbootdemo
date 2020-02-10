package com.example.demo.service;

import com.example.demo.domain.Weather;

import java.util.Optional;

public interface WeatherService {
    
    /**
     * Gets the current temperature for the specified city and country
     */
    public Weather getCurrentTemperature(String city, Optional<String> country);
}

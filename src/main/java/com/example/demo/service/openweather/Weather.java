package com.example.demo.service.openweather;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor
@ToString
public class Weather {
    private int id;
    private String main;
    private String description;
    /**
     * Icon from OpenWeatherMap
     * See https://openweathermap.org/weather-conditions
     */
    private String icon;
}

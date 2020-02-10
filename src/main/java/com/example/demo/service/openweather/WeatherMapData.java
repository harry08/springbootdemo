package com.example.demo.service.openweather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter @Setter
// @NoArgsConstructor
@ToString
public class WeatherMapData {

    /**
     * City name
     */
    private String name;

    /**
     * City id
     */
    private int id;
    
    /**
     * Time of data calculation, Unix, UTC
     */
    private int dt;
    private Main main;

    @JsonProperty("weather")
    private List<Weather> weather;

    public WeatherMapData() {
        weather = new ArrayList<>();
    }
}

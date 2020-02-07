package com.example.demo.service.openweather;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor
@ToString
public class Main {
    /**
     * Temperature in Kelvin
     */
    private Double temp;
    /**
     * Humidity in %
     */
    private int humidity;
}

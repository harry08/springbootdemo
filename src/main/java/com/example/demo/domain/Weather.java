package com.example.demo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Weather {
    private Double temperature;
    private TemperatureScale temperatureScale;
    private int humidity;
}

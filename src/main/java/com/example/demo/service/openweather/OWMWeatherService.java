package com.example.demo.service.openweather;

import com.example.demo.domain.TemperatureScale;
import com.example.demo.domain.Weather;
import com.example.demo.service.WeatherService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

/**
 * Implementation of WeatherService.
 * Runs in prod profile. Configured in WeatherServiceConfig.
 *
 * Connects to the OpenWeatherMap current weather Data service
 * See https://openweathermap.org/current
 *
 * The developer key is read from appliction.properties
 */
public class OWMWeatherService implements WeatherService {

    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather";
   
    @Value("${integration.owm.appid}")
    private String owmAppId;

    Logger logger = LoggerFactory.getLogger(OWMWeatherService.class);

    private MeterRegistry meterRegistry;

    private Counter counter;

    @Autowired
    public void setMeterRegistry(MeterRegistry meterRegistry) {
        logger.info("Register MeterRegistry...");
        this.meterRegistry = meterRegistry;
        counter = this.meterRegistry.counter("getcurrenttemperature.count");
    }

    @Override
    public Weather getCurrentTemperature(String city, Optional<String> country) {
        logger.info("getCurrentTemperature called for city " + city + "," + country.orElse("country not specified")  + "...");
        counter.increment();

        String url = getUrl(city, country);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<WeatherMapData> weatherMapDataEntity = restTemplate.getForEntity(url, WeatherMapData.class);
        WeatherMapData weatherMapData = weatherMapDataEntity.getBody();
        logger.info("Data read from openweathermap service: " + weatherMapData.toString());

        Weather weather = new Weather();
        weather.setTemperatureScale(TemperatureScale.CELSIUS);
        Double tempKelvin = weatherMapData.getMain().getTemp();
        weather.setTemperature(convertKelvinToCelsius(tempKelvin));
        weather.setHumidity(weatherMapData.getMain().getHumidity());
        weather.setCity(weatherMapData.getName());

        return weather;
    }

    private String getUrl(String city, Optional<String> country) {
        StringBuilder str = new StringBuilder(BASE_URL);
        if (country.isPresent()) {
            str.append("?q=" + city + "," + country);
        } else {
            str.append("?q=" + city);
        }
        str.append("&appid=" + owmAppId);
        str.append("&lang=de");

        return str.toString();
    }

    private Double convertKelvinToFahrenheit(Double kelvin) {
        return kelvin * 9 / 5 - 459.67;
    }

    private Double convertKelvinToCelsius(Double kelvin) {
        return kelvin - 273.15;
    }
}

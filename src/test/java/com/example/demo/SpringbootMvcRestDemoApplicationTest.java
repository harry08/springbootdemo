package com.example.demo;

import com.example.demo.domain.Weather;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringbootMvcRestDemoApplicationTest {

    Logger logger = LoggerFactory.getLogger(SpringbootMvcRestDemoApplicationTest.class);
    
    private static final String ROOT_URL = "http://localhost:8080";

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void testGetCurrentTemperature() {
        ResponseEntity<Weather> temperature = restTemplate.getForEntity(ROOT_URL + "/temperature", Weather.class);
        assertNotNull(temperature);
        assertThat(temperature.getStatusCode()).isEqualTo(HttpStatus.OK);
        logger.info("Temperature from Service: " + temperature.getBody().getTemperature() + " " + temperature.getBody().getTemperatureScale());
    }
}

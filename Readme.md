# Spring Boot REST Service Demo application

Provides a service to get the current temperature for a specific location.
The temperature is read from an external service.

The applicatiion can be executed in 2 modes:
* Prod mode - The external service is called to read the temperature.
* Mock mode - The external service is mocked

## Run the application

### With Maven

Mock mode:
`mvn spring-boot:run -Dspring-boot.run.profiles=mock`

Prod mode: 
`mvn spring-boot:run -Dspring-boot.run.profiles=prod`
  
### With Command Line
In the project directory call
`java -jar -Dspring.profiles.active=prod target/demo.jar` 
  
## REST endpoints

### Temperature
                                                                          
* Read the current temperature for the default city: `http://localhost:8080/temperature` 
The default city is specified in application.properties
* Read the current temperature for the specified city and country: `http://localhost:8080/temperatur?city=Basel&country=ch`
* Read the current temperature for the specified city without country: `http://localhost:8080/temperatur?city=London`

### Actuator

* Shows a list of all Actuator endpoints: `http://localhost:8080/actuator`
* Shows a counter for all http requests: `http://localhost:8080/actuator/metrics/http.server.requests`
* Shows the infos of a custom metric: `http://localhost:8080/actuator/metrics/getcurrenttemperature.count`
* Shows application information: `http://localhost:8080/actuator/info`

### General

* Provides an info page about this application via HomeController: `http://localhost:8080/`

## OpenWeatherMap

Uses OpenWeatherMap internally: `https://openweathermap.org/current`

To access OpenWeatherMap an AppId is required. 
Can be received via https://openweathermap.org/appid.

The AppId needs to be configured in application.properties with the key `integration.owm.appid` 

## Spring Initializer
The basic maven project is created with Spring initializer.
See start.spring.io

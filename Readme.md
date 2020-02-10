# Spring Boot REST Service Demo application

Provides a service to get the current temperature.

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
                                                                          
* Read the current temperature for the default city: http://localhost:8080/temperature
The default city is specified in application.properties
* Read the current temperature for the specified city and country: http://localhost:8080/temperatur?q=Basel,ch
* Provides an info page about this application via HomeController: http://localhost:8080/

## OpenWeatherMap

Uses OpenWeatherMap internally: `https://openweathermap.org/current`

To access OpenWeatherMap an AppId is required. 
Can be received via https://openweathermap.org/appid.

The AppId needs to be configured in application.properties with the key `integration.owm.appid` 

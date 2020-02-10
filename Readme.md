# Spring Boot REST Service Demo application

###

Provides a service to get the current temperature.

Uses OpenWeatherMap internally.

### How to run the application via Maven

Mock mode:
`mvn spring-boot:run -Dspring-boot.run.profiles=mock`

Prod mode: 
`mvn spring-boot:run -Dspring-boot.run.profiles=prod`
  
### How to run the application via Command Line
In the project directory call
`java -jar -Dspring.profiles.active=prod target/demo.jar` 
  
### REST endpoints
                                                                          
* Read the current temperature: http://localhost:8080/temperature
* Provides an info page about this application via HomeController: http://localhost:8080/

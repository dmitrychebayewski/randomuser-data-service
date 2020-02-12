# randomuser-demo
Spring Boot REST consumer application written in Kotlin.
The app is potential microservice built using Spring Boot (v.2.2.4).
The app is consuming the [Random User](https://randomuser.me/) REST web service,
and it is providing the data that could be useful for on-boarding process testing.
I aim on Docker and Integration testing part of the exercise.

## Software Stack
* Java JDK 8+/Kotlin as main execution environment
* Gradle 6
* Swagger 2
* Cucumber 5
* Docker is potentially supported if you intend trying out the demo on Mac / Linux 
## Setup
You need to have Java 8 SDK set up.
## IDE
This project was created in IntelliJ Community edition.

## Analysing The Solution
One can find the definition of features written in given-when-then Gherkin language at:
```
src/test/resources/randomuser-integration.feature
```
In order to navigate from .feature files to steps definitions code,
[Cucumber For Java](https://plugins.jetbrains.com/search?search=Cucumber) IDE plugin should be installed.

## Running Tests
This project uses [Gradle Wrapper](https://docs.gradle.org/current/userguide/gradle_wrapper.html).
Use one the following command to run the integration tests:
```
$./gradlew cucumber 
```
or
```
>.\gradlew.bat cucumber
```
## Starting the Application
Use one the following commands to start the application listening on your requests at port 8080.
```
$./gradlew bootRun 
```
or
``` 
>.\gradlew.bat bootRun
```
And open the link in browser to see the randomly generated user data.
http://localhost:8080/randomuser

## Swagger API
Open this link in browser to read the API 
```
http://localhost:8080/swagger-ui.html
```
## Docker
Docker part is not supported on Windows.
The following approach is recommended if you're using Spring Boot v. 2.2.4:
* Build Spring boot application jar;
* Unzip the jar. This is beneficial
   if the application dependencies don’t change, so the build will be faster, and so will the startup of the container at runtime,
    as long as the base layers are already cached;
* Build docker image;
* Run docker image.
The docker file has been provided to build the image and wrap the Spring Boot app.
To build the boot jar, use the following command:
```
$./gradlew bootJar
```
To unpack the jar, use the following command:
```
$cd build/libs/ && unzip *.jar 
$cd ../..
```
To build the Docker image and run it, use the following commands:
```
$docker build -t com.minskrotterdam/randomuser . 
$docker run -p 8080:8080 com.minskrotterdam/randomuser --server.port=8080
```
## Guides:
* [Spring Boot RESTful API Documentation with Swagger 2](https://springframework.guru/spring-boot-restful-api-documentation-with-swagger-2/)
* [Testing Spring MVC Controllers](https://dzone.com/articles/unit-and-integration-tests-in-spring-boot)
* [Consuming a RESTful Web Service](https://spring.io/guides/gs/consuming-rest/)
* [To run Cucumber with Gradle](https://cucumber.io/docs/installation/java/#gradle)
* [Spring Boot Docker](https://spring.io/guides/topicals/spring-boot-docker/)
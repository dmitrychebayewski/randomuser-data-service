# randomuser-demo
Spring Boot REST consumer application written in Kotlin.
The app is potential microservice built using Spring Boot (v.2.2.4).
The app is consuming the [Random User](https://randomuser.me/) REST web service,
and it is providing the data that could be useful for on-boarding process testing.

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
##Starting the Application
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
```
##Swagger API
```
Open this link in browser to read the API 
```
http://localhost:8080/swagger-ui.html
```
##Docker
The docker file has been provided to build the image and wrap the Spring Boot app.
The structure of dockerfile is helpful when working with special Spring Boot layered jars.
To use docker, run one of the following commands:
```
$./gradlew bootJar
```
or
```
>.\gradlew.bat bootJar
```
The command generates the JAR to 
build/libs/randomuser-demo-${version}.jar
To unpack the jar, use the commands:
```
$ mkdir build/dependency
$ (cd build/dependency; jar -xf ../libs/*.jar)
$ docker build -t myorg/myapp .
```
##Guides:
* [Spring Boot RESTful API Documentation with Swagger 2](https://springframework.guru/spring-boot-restful-api-documentation-with-swagger-2/)
* [Testing Spring MVC Controllers](https://dzone.com/articles/unit-and-integration-tests-in-spring-boot)
* [Consuming a RESTful Web Service](https://spring.io/guides/gs/consuming-rest/)
* [To run Cucumber with Gradle](https://cucumber.io/docs/installation/java/#gradle)
* [Spring Boot Docker](https://spring.io/guides/topicals/spring-boot-docker/)
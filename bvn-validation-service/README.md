# BVN VALIDATION SERVICE

The web service exposes 1 or more endpoints for handling several business processes.


### Technologies

- Java
- Maven
- MongoDB
- Spring Boot
- Spring Data JPA

### Requirements

You need the following to build and run the application:

- [JDK 17](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven 3.8.6](https://maven.apache.org) (This is the build tool used.)

## How to run Application(s)
### step 1 - clone project with Terminal from [here](https://gitlab.com/TryG70/MusalaSoft-DroneService)

```
git clone git@github.com:TryG70/MusalaSoft-DroneService.git
```

### step 2 - move into the project directory
```
cd bvn-validation-service/
```

### step 3 - Open the bvn-validation-service folder in an IDE, As a maven Project.

```
mvn spring-boot:run
```


### step 6 - Generate the .jar files with Terminal

```
mvn clean install 
```
OR
```
./mvnw clean install
```


## PostMan Collection for Integration Tests.
- Musala-Soft Drone-Service [here](https://api.postman.com/collections/22955162-fb9f2b60-07ec-4f00-aa32-aefd7227aebd?access_key=PMAT-01GM2YMXAX1AES3HQRHKQVPQ1X)


## Running The Tests with Maven

To run the tests with maven, you would need to run the maven command for testing, after the code has been compiled.
```
mvn <option> test
```

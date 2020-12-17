# Wine API

## Description
Provides product details of various wines.

## Getting Started
### Dependencies
* Java 8

### Executing program
1. Run `./mvnw spring-boot:run`
2. The API will run at [http://localhost:8080](http://localhost:8080)

### Executing tests
1. Run `/mvnw test`

### Executing build release
1. `./mvnw package`
2. The production jar will be in the `target` folder.

## Design
The structure follows a Clean Architecture approach, by separating domain from integrations concerns. 
However, the following compromises made to reduce code:
- Use cases and break down strategies are using Spring annotations for the instantiation & configuration.
    - This coupling on spring makes it harder to move to other frameworks. The solution to decouple this is to remove 
    the annotations in the domain packages and move the configuration the separate Config classes.
- The `BreakDownUseCase` class uses Spring Exceptions for propagating errors.
    - This couples the use case to Spring. The solution for this is to create and throw domain exceptions instead or
     make use of a presenter for converting to the right errors.
- The `BreakDownType` enum has a jackson annotation for converting it to a JSON string.
    - This can be decoupled by converting the enum to DTO in the web integration.

Other improvements that can be made:
- Remove the code duplication in the breakdown strategies.
- Use a database as storage implementation.
- Endpoints are exposing more information than what is needed in the UI. This can have a performance and cost impact.
- Add static code analysis.
- Add a CI and CD pipeline.
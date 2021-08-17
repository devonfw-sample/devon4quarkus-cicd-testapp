# devon4quarkus-cicd-testapp-service-a
Service which calls synchronously REST-services from the devon4quarkus-cicd-testapp-service-b.
For calling the REST-services the RESTEasy library is used.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode using: `shell script ./mvnw compile quarkus:dev `

## Access your REST endpoint

For this application to be able to run the service-b from https://github.com/devonfw-sample/devon4quarkus-cicd-testapp-service-b must be up and running and accessable for this service instance. Per default the configured base url for service-b within service-a is `http://localhost:8081`. If you want to change this because your service-b-instance is running somewhere else but locally, you can change it in the `application.properties` file.


`curl -w "\n" http://localhost:8080/greeting/hello`

or

`curl -w "\n" http://localhost:8080/greeting/hello/Florian`

## Running tests

You can run tests from your IDE or via Maven. Simply run ./mvnw test or ./mvnw package
The JUnit tests use a Mock (Wiremock) to mock the service b.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar

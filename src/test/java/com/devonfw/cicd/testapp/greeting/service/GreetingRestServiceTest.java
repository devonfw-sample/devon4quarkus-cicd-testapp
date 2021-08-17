package com.devonfw.cicd.testapp.greeting.service;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import com.devonfw.cicd.testapp.greeting.common.wiremock.HelloWorldServiceMock;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@QuarkusTestResource(HelloWorldServiceMock.class)
public class GreetingRestServiceTest {

  @Test
  public void testHelloEndpoint() {

    given().when().get("/greeting/hello").then().statusCode(200).body(is("Hello World!"));
  }

  @Test
  public void testHelloNameEndpoint() {

    given().when().get("/greeting/hello/Florian").then().statusCode(200).body(is("Hello Florian!"));
  }

}
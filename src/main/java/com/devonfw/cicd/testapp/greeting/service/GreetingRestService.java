package com.devonfw.cicd.testapp.greeting.service;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.devonfw.cicd.testapp.greeting.domain.dao.HelloWorldClient;

/**
 * Greeting REST endpoint.
 *
 */
@Path("/greeting")
public class GreetingRestService {

  @Inject
  @RestClient
  HelloWorldClient helloWorldClient;

  /**
   * Returns the String "Hello world!".
   *
   * @return The String "Hello world!".
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/hello")
  public String hello() {

    return this.helloWorldClient.getHelloWorld();
  }

  /**
   * Return the String "Hello <<name>>!".
   *
   * @param name The name to greet.
   * @return The String "Hello <<name>>!".
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/hello/{name}")
  public String greeting(@PathParam String name) {

    return this.helloWorldClient.getHelloName(name);
  }

}
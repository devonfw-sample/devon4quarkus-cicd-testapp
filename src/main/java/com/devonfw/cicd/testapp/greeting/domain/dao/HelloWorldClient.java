package com.devonfw.cicd.testapp.greeting.domain.dao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

/**
 * Interface for the Rest client to HelloWorldService.
 *
 */
@Path("/hello")
@RegisterRestClient(configKey = "hello-api")
public interface HelloWorldClient {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  String getHelloWorld();

  @GET
  @Path("/{name}")
  @Produces(MediaType.APPLICATION_JSON)
  String getHelloName(@PathParam String name);

}

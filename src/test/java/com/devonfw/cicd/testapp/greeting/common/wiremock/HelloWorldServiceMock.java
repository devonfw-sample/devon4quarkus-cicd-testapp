package com.devonfw.cicd.testapp.greeting.common.wiremock;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;

import java.util.Collections;
import java.util.Map;

import com.devonfw.cicd.testapp.greeting.domain.dao.HelloWorldClient;
import com.github.tomakehurst.wiremock.WireMockServer;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

/**
 * Mock server of the {@link HelloWorldClient}.
 *
 */
public class HelloWorldServiceMock implements QuarkusTestResourceLifecycleManager {

  private WireMockServer wireMockServer;

  @Override
  public Map<String, String> start() {

    this.wireMockServer = new WireMockServer();
    this.wireMockServer.start();

    stubFor(get(urlEqualTo("/hello"))
        .willReturn(aResponse().withHeader("Content-Type", "application/json").withBody("Hello World!")));

    stubFor(get(urlEqualTo("/hello/Florian"))
        .willReturn(aResponse().withHeader("Content-Type", "application/json").withBody("Hello Florian!")));

    stubFor(get(urlMatching(".*")).atPriority(10).willReturn(aResponse().proxiedFrom("http://localhost:8081")));

    return Collections.singletonMap("hello-api/mp-rest/url", this.wireMockServer.baseUrl());
  }

  @Override
  public void stop() {

    if (null != this.wireMockServer) {
      this.wireMockServer.stop();
    }
  }
}
package com.devonfw.cicd.testapp.greeting.service;

import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativeGreetingResourceIT extends GreetingRestServiceTest {

    // Execute the same tests but in native mode.
}
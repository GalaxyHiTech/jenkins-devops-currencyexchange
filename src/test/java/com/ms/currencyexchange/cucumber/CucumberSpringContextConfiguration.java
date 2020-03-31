package com.ms.currencyexchange.cucumber;

import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;

import com.ms.currencyexchange.DemoApplication;

import cucumber.api.java.Before;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = DemoApplication.class, loader = SpringBootContextLoader.class)
public class CucumberSpringContextConfiguration {

  @Before
  public void setUp() {
  }
}
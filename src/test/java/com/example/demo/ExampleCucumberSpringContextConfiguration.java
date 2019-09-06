package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.Before;


@ActiveProfiles("test") 
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT, classes = {ExampleCucumberTest.class, AppConfigTest.class})
@ContextConfiguration(classes = ExampleCucumberApplicationTest.class, loader = SpringBootContextLoader.class)
public class ExampleCucumberSpringContextConfiguration {

	  private static final Logger LOG = LoggerFactory.getLogger(ExampleCucumberSpringContextConfiguration.class);

	  /**
	   * Need this method so the cucumber will recognize this class as glue and load spring context configuration
	   */
	  @Before
	  public void setUp() {
	    LOG.info("-------------- Spring Context Initialized For Executing Cucumber Tests --------------");
	  }
}

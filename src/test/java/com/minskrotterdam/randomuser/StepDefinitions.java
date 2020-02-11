package com.minskrotterdam.randomuser;

import com.minskrotterdam.randomuser.model.UserData;
import io.cucumber.java8.En;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Ignore
public class StepDefinitions implements En {
  private final String SERVER_URL = "http://localhost";
  private final String RANDOMUSER_ENDPOINT = "/randomuser";
  private RestTemplate restTemplate;

  @LocalServerPort protected int port;

  private String endpoint() {
    return SERVER_URL + ":" + port + RANDOMUSER_ENDPOINT;
  }

  private UserData getContents() {
    return restTemplate.getForObject(endpoint(), UserData.class);
  }

  public StepDefinitions() {

    this.restTemplate = new RestTemplate();
    Given(
        "I get valid response from getRandomUser",
        () -> assertNotNull(getContents().getResults().get(0).getName()));
  }
}

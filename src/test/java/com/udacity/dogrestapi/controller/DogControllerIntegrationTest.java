package com.udacity.dogrestapi.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc(addFilters = false)
public class DogControllerIntegrationTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getDogs() {
        ResponseEntity<List> response = restTemplate.withBasicAuth("admin", "1234")
                .getForEntity("http://localhost:" + port + "/dogs", List.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void getDogBreeds() {
        ResponseEntity<List> response = restTemplate.withBasicAuth("admin", "1234")
                .getForEntity("http://localhost:" + port + "/dogs/breeds", List.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void getDogBreedById() {
        ResponseEntity<String> response = restTemplate.withBasicAuth("admin", "1234")
                .getForEntity("http://localhost:" + port + "/dogs/breeds/1", String.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void getDogNames() {
        ResponseEntity<List> response = restTemplate.withBasicAuth("admin", "1234")
                .getForEntity("http://localhost:" + port + "/dogs/names", List.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }
}

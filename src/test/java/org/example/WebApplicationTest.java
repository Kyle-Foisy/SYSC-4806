package org.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WebApplicationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private AddressbookController controller;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    void homePageDefaultMessage() {
        ResponseEntity<String> response
                = restTemplate.getForEntity("http://localhost:" + port, String.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        assertThat(response.getBody().contains("View book here"));
    }

    @Test
    void addressBookPageDefaultMessage() {
        ResponseEntity<String> response
                = restTemplate.getForEntity("http://localhost:" + port + "/book", String.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertTrue(response.getBody().contains("AddressBook 1: <br>John 1234567893 <br> Jane 1234567891 <br> Henry 1234567892 <br>"));
    }
}

package com.example.cicd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;


import javax.sql.DataSource;
import java.sql.Connection;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CicdApplicationTests {



	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private DataSource dataSource;

	// Test 1: Check REST endpoint


	// Test 2: Check database connection
	@Test
	void databaseConnectionShouldBeValid() throws Exception {
		try (Connection connection = dataSource.getConnection()) {
			assertThat(connection.isValid(2)).isTrue();
			System.out.println("connected to databse");// checks if connection is valid (2 sec timeout)
		}
	}

	// Optional: Default context load test
	@Test
	void contextLoads() {
		// Just checks if Spring context starts successfully
	}
}

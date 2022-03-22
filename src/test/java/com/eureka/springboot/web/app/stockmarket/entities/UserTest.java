package com.eureka.springboot.web.app.stockmarket.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserTest {
	
	@Test
	void createUserByConstructorProperly() {
		User userTest = new User("Juan","Perez","jperez@gmail.com");
		
		assertEquals("Juan", userTest.getFirstName());
		assertEquals("Perez", userTest.getLastName());
		assertEquals("jperez@gmail.com", userTest.getEmail());
	}
	
	@Test
	void createUserByConstructorWithoutFirstNameAndLastName() {
		User userTest = new User("","","emptynames@gmail.com");
		
		assertEquals("", userTest.getFirstName());
		assertEquals("", userTest.getLastName());
		assertEquals("emptynames@gmail.com", userTest.getEmail());
	}
	
	@Test
	void createUserByConstructorWithoutMail() {
		User userTest = new User("Gabriel","Luna","");
		
		assertEquals("Gabriel", userTest.getFirstName());
		assertEquals("Luna", userTest.getLastName());
		assertEquals("", userTest.getEmail());
	}
}

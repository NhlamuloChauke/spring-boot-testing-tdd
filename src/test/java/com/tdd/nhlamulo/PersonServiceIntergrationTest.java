package com.tdd.nhlamulo;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class PersonServiceIntergrationTest {
	
	@Autowired
	PersonService personService;
	
	@Test
	public void testAddPersonHappyPath() {
		
		// Create person
		Person person = new Person();
		person.setFirstName("Nhlamulo");
		person.setLastName("Chauke");
		
		//Test adding person
		Person newPerson = personService.addPerson(person);
		
		
		//Verify the addition
		assertNotNull(newPerson);
		assertNotNull(newPerson.getId());
		assertEquals("Chauke", person.getLastName());
	}

}

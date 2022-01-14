package com.tdd.nhlamulo;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class PersonServiceUnitTest {

	@Mock
	private PersonRepository personRepository;

	@InjectMocks
	private PersonService personService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAddPersonHappyPath() {
		// Create a contact
		Person aMockPerson = new Person();
		aMockPerson.setFirstName("Nhlamulo");
		aMockPerson.setLastName("Chauke");
				
		when(personRepository.save(any(Person.class))).thenReturn(aMockPerson);
						
		// Save the contact
		Person newContact = personService.addPerson(aMockPerson);
				
				
		// Verify the save
		assertEquals("Nhlamulo", newContact.getFirstName());

	}
}

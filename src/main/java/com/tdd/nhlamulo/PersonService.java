package com.tdd.nhlamulo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository personRepository;
	
	public Person addPerson(Person person) {
		Person newPerson = personRepository.save(person);
		return newPerson;
	}

}

package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.model.Person;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.PersonRepository;



@Service
public class PersonService {
	@Autowired
	PersonRepository personRepo;
	
	
	@Autowired
	AddressRepository addressRepo;
		public Person savePerson(Person p)
		{
			return personRepo.save(p);
		}

			public List<Person> getAllPersons() {
			
			return personRepo.getPersons();
		}
			
		 public void delete(Long id)
		 	{
			 personRepo.deleteById(id);
			}
		 
		 public Person Update(Person mc)
			{
			 return personRepo.saveAndFlush(mc);
			}
		 
		

}



package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
public class PersonController {
	@Autowired
	PersonService pservice;
	
	@Autowired
	PersonRepository prep;
	
	
	@PostMapping("/savePerson")
	//http://localhost:9080/savePerson
	public Person savePerson(@RequestBody Person p)
	{
	
		return pservice.savePerson(p);
			
	}
	@GetMapping("/getAllPersons")
	//http://localhost:9080/getAllPersons
	public List<Person> getAllPersons()
	{
	
		return pservice.getAllPersons();
		
	}
	
	 @DeleteMapping("/delete/{id}")
	   public String Deleteoption(@PathVariable Long id)
	   {
		  pservice.delete(id);
		   return "deleted";
	   }
	 @PutMapping("/update")
	  public Person Update(@RequestBody Person mc)
		{
		   return pservice.Update(mc);
		}
	 
	 
	 
	 //query
	 @Tag( name="Native query",description="Getting details")
	 @GetMapping("/saveir")
	 public List<Person> getD()
	 {
	 	return prep.getAllData();
	 }

	 @Tag( name="Native query",description="Getting details by id")
	 @GetMapping("byName/{id}")
	 public List<Person> getName(@PathVariable ("id") int pid )
	 {
	 	return prep.byid(pid);
	 }

	 @Tag( name="Native query",description="Getting details by start end method")
	 @GetMapping("startend/{start}/{end}")
	 public List<Person> getStart(@PathVariable ("start")int start,@PathVariable ("end")int end)
	 {
	 	return prep.startEnd(start, end);
	 }

	 @Tag( name="Native query",description="Deleting details by id and name")
	 @DeleteMapping("/del/{id}/{name}")
	 public String delD(@PathVariable ("id") int id,@PathVariable ("name")String name)
	 {
	 	prep.deleteD(id, name);
	 	return "deleted";
	 }

	 @Tag( name="Native query",description="Posting details")
	 @PutMapping("updatee/{pid}/{pname}")
	 public void updateQue(@PathVariable("pid")int pid,@PathVariable("pname") String pname)
	 {
	 	prep.updateByQuery(pid, pname);
	 }

	 @Tag( name="JPQL",description="Getting details by methods")
	 @GetMapping("jp")
	 public List<Person> jplQuery()
	 {
	 	return prep.jpqlQ();
	 }

	 @Tag( name="JPQL",description="Getting details by id")
	 @GetMapping("/upp/{id}")
	 public List<Person> jpqUp(@PathVariable ("id") int id)
	 {
	 	return prep.jqBYCon(id);
	 }

	 
	
		


}

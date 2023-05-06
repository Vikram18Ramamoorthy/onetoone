package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Person;

import jakarta.transaction.Transactional;

public interface PersonRepository extends JpaRepository<Person,Long>{

	//join query to retrieve person and address
		@Query(value="SELECT p FROM Person p  join p.address a ")
		List<Person> getPersons();

		List<Person> getCusByName(String custname);
		
		
	//query
		
		@Query(value="select * from Person ",nativeQuery=true)
        public List<Person> getAllData();
        
        @Query(value="select * from Person where id=:id",nativeQuery=true)
        public List<Person> byid (@Param("id")int id);
        
        @Query(value="select * from Person where id between :start and :end",nativeQuery=true)
        public List<Person> startEnd(@Param("start") int start,@Param("end")int end);
        
        @Modifying
        @Transactional
        @Query(value="delete from Person where id=?1 and id=?2",nativeQuery = true)
        Integer deleteD(@Param("id") int pid,@Param ("name") String pname);
        
        @Modifying
        @Transactional
        @Query(value="update Person set id=:pid where id=:pname",nativeQuery=true)
        public void updateByQuery(@Param ("pid")int pid,@Param ("pname")String pname);
        
        @Query(value="select c from Person c")
        List<Person> jpqlQ();
        
        @Query(value="select c from Person c where c.id=?1")
        public List<Person> jqBYCon(@Param ("id")int sid);
		
		
		
 
		
		
		
}


package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Person {
	 @Id
	 @GeneratedValue
	 
	    private Long id;
	    private String name;
	    private String designation;
	    private String email;
	    private String joindate;
	    private String updatedate;
	    
	    
	    
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "address_id")
	  
	    private Address address;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getDesignation() {
			return designation;
		}
		public void setDesignation(String designation) {
			this.designation = designation;
		}
		public String getJoindate() {
			return joindate;
		}
		public void setJoindate(String joindate) {
			this.joindate = joindate;
		}
		public String getUpdatedate() {
			return updatedate;
		}
		public void setUpdatedate(String updatedate) {
			this.updatedate = updatedate;
		}
		
		@Override
		public String toString() {
			return "Person [id=" + id + ", name=" + name + ", designation=" + designation + ", email=" + email
					+ ", joindate=" + joindate + ", updatedate=" + updatedate + ", address=" + address + "]";
		}
		
		
		
}






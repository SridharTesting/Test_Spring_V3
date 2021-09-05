package com.slk.dsl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slk.dsl.model.BusinessProcess1;
import com.slk.dsl.model.Org;
import com.slk.dsl.repository.BusinessProcess1Dao;

@Service
public class BusinessProcess1Service {

	@Autowired
	BusinessProcess1Dao busProc1Repo;
	
	//all http methods will be declared here
	
		public BusinessProcess1 savebusinessprocess1(BusinessProcess1 businessProcess1Details) {
			return busProc1Repo.save(businessProcess1Details);
		}
		
		public List<BusinessProcess1> getbusinessprocess1() {  
		        return busProc1Repo.findAll();  
		} 
		
		public Optional<BusinessProcess1> findByID(int id) {  
	        return busProc1Repo.findById(id) ;
	    }
	  
		 public void delete(int id) {
			 busProc1Repo.deleteById(id);
		 }
		  
}

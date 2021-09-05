package com.slk.dsl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.slk.dsl.dto.BusinessProcess1AndOrgJoinResponse;
import com.slk.dsl.model.BusinessProcess1;
import com.slk.dsl.repository.BusinessProcess1MappingDao;
import com.slk.dsl.services.BusinessProcess1Service;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BusinessProcess1Controller {
	
	@Autowired
	BusinessProcess1Service service;
	

	 @RequestMapping(value = "/createBusProc1", method = RequestMethod.POST)
		public BusinessProcess1 createBusinessProcess1(@RequestBody BusinessProcess1 businessProcess1Details) {
			return service.savebusinessprocess1(businessProcess1Details);
		}
	 
	 
	  @GetMapping("businessprocess1-list")  
	    public List<BusinessProcess1> allbusprocs1() {  
	         return service.getbusinessprocess1(); 
	    }
	  
	  
	  @PutMapping("businessprocess1")
		public BusinessProcess1 update(@RequestBody BusinessProcess1 businessProcess1Details) {
		  return service.savebusinessprocess1(businessProcess1Details);
	  }
	  	
	  
	  @GetMapping("getbusproc1byid/{id}")
		 public BusinessProcess1 getBusProc1ByID(@PathVariable int id) {
		  return service.findByID(id).get();
	  }
	  
	  
	  @DeleteMapping("businessprocess1/{id}")
	  public String delete(@PathVariable int id) {
		  service.delete(id);
		  return "Process1 deleted";
	  }
	  
	  
}

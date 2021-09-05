package com.slk.dsl.controller;

import java.sql.SQLException;
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

import com.slk.dsl.exceptions.SQLIntegrityConstraintViolationException;
import com.slk.dsl.model.Org;
import com.slk.dsl.services.OrganizationService;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrganizationController {
	
	@Autowired
	OrganizationService service;
	
	 @RequestMapping(value = "/createOrg", method = RequestMethod.POST)
		public Org createOrganisation(@RequestBody Org orgDetails) {

			

			return service.saveOrganization(orgDetails);
		}
	 
	 
	  @GetMapping("org-list")  
	    public List<Org> allstudents() {  
	         return service.getorg();
	          
	    }
	  
	  @PutMapping("org")
		public Org update(@RequestBody Org orgDetails) {
		  return service.saveOrganization(orgDetails);
		  
	  }
	  
	  
	  @GetMapping("getorgbyid/{id}")
		 public Org getUserByID(@PathVariable int id) {
		  return service.findByID(id).get();
	  }
	  @DeleteMapping("org/{id}")
	  public String delete(@PathVariable int id)  {
		  
		  try {
		   service.delete(id);
		   return "Org deleted";
		  }catch(Exception e) {
			  if(e instanceof java.sql.SQLIntegrityConstraintViolationException) {
	            return e.getMessage();
	            }
			  return e.getMessage();
		  }
		  
		 
	  }
}
	  
		
		/*
		 * @GetMapping("getLobname") public List<OrgAndLobJoinResponse>
		 * getLobNameFromOrg() { return service.getLobName(); }
		 * 
		 * }
		 */


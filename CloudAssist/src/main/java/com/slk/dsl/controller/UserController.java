package com.slk.dsl.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.mail.MessagingException;

import com.slk.dsl.dto.AddInfraDTO;
import com.slk.dsl.dto.Email_passwordDTO;
import com.slk.dsl.dto.OrgNameDTO;
import com.slk.dsl.dto.UserRole;
import com.slk.dsl.dto.migrationdto;
import com.slk.dsl.model.Application;
import com.slk.dsl.model.Role;
import com.slk.dsl.model.UserSetup;
import com.slk.dsl.services.UserService;

import io.swagger.v3.oas.models.media.MediaType;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	@Autowired
	UserService service;
	 @RequestMapping(value = "/createUser", method = RequestMethod.POST)
		public UserSetup createOrganisation(@RequestBody UserSetup userDetails) {

			

			return service.saveUser(userDetails);
		}
	 
	 @GetMapping("user-list")  
	    public List<UserSetup> alllobs() {  
	         return service.getUsers();
	          
	    }
	 
	 
	 @GetMapping("role-list")  
	    public List<Role> role() {  
	         return service.getrolelist();
	          
	    }
	 
	 
	 
	 
	  @PutMapping("users")
		public void update(@RequestBody UserSetup userDetails) {
		   service.updateUser(userDetails);
		  
	  }
	  
	  
	  @GetMapping("getuserbyid/{id}")
		 public UserSetup getUserByID(@PathVariable int id) {
		  return service.getUserByID(id).get();
	  }
		  
	  
	  @DeleteMapping("user/{id}")
	  public String delete(@PathVariable int id)  {
		  service.delete(id);
		  
		  return "Org deleted";
	  }
	  
	  @PostMapping("mail")
	  public void triggerMail(@RequestBody List<Email_passwordDTO> email) throws MessagingException {

			service.sendSimpleEmail(email,"Access your Cloud Strategy Builder");

		}
	  
	  
//	  @RequestMapping(value ="/mail", method = RequestMethod.POST) 
//	  public void triggerMail(@RequestBody List<Email_passwordDTO> email) throws MessagingException {
//
//			service.sendSimpleEmail(email,"Access your Cloud Strategy Builder");
//
//		}
	

	
	   
		@RequestMapping(value="/orgname" ,method=RequestMethod.POST)
		public List<OrgNameDTO> gettotalapp(@RequestBody String emailId) {  
			return service.getorgname(emailId);
			
			

		}
		@GetMapping("getLobnameforusersnew/{orgId}")
		public List<UserRole> getLOBMappedToUsers(@PathVariable int orgId){
			return service.getLOBUserMapping(orgId);
		}
		  @GetMapping("loginvalidation")
			 public List<migrationdto> loginvalidation(){
			  return service.loginvalidation();
		  }
	
}

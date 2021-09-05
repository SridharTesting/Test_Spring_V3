package com.slk.dsl.controller;
import java.sql.SQLException;
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

import com.slk.dsl.dto.Lob_List_Dto;
import com.slk.dsl.dto.rlanedto;
import com.slk.dsl.exceptions.SQLIntegrityConstraintViolationException;
import com.slk.dsl.model.LOB;
import com.slk.dsl.model.Rlane;
import com.slk.dsl.model.override;
import com.slk.dsl.services.RlaneService;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RlaneController {
	@Autowired
	RlaneService service;
	
	
	
	
	 @GetMapping("rlane/{id}")
	 public Rlane getrlane(@PathVariable int id) {
	  return service.getrlane(id).get();
  }

	  @GetMapping("rlane-list")  
	    public List<Rlane> allrlanes() {  
	         return service.getRlane();
	          
	    }
}

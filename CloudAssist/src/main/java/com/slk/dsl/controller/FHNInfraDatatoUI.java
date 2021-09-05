package com.slk.dsl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.slk.dsl.model.Application;
import com.slk.dsl.model.fhn_infrastructure_dataTable;
import com.slk.dsl.services.FhnInfraDataService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FHNInfraDatatoUI {
	
	@Autowired
	FhnInfraDataService service;

	  
	    
	    
	    
	    
	    @PutMapping("infraData")
  		public fhn_infrastructure_dataTable update(@RequestBody fhn_infrastructure_dataTable appData) {
  		  return service.updateFhnInfraData(appData);
  		  
  	  }
	    
	    @DeleteMapping("/deleteinfradata/{appId}")  
	    private void deleteBook(@PathVariable("appId") int appId)   
	    {  
	    	service.delete(appId);  
	    } 
	    
}

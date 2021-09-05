package com.slk.dsl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.slk.dsl.model.Ca_infra_app_mapping;
import com.slk.dsl.services.CaInfraMappingService;
import com.slk.dsl.services.CompareVersionService;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CaInfraMappingController {
	@Autowired
	CaInfraMappingService service;
	 @GetMapping("CAInframapping")  
	    public List<Ca_infra_app_mapping> CAInfradatamapping() {  
	         return service.CAInframapping();
	          
	 }


		 @DeleteMapping("/deleteappdata/{appId}")  
		    private void deleteBook(@PathVariable("appId") int appId)   
		    {  
		    	service.delete(appId);  
		    } 
		



}







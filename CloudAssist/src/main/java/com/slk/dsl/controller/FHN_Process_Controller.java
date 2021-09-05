package com.slk.dsl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.slk.dsl.jsonFormatter.JsonArg;
import com.slk.dsl.model.FHNAppBaseTable;
import com.slk.dsl.model.FHN_Process_Data;
import com.slk.dsl.services.FHNProcessData;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FHN_Process_Controller {
	@Autowired
	FHNProcessData service;
	  @PostMapping("/processData")
			public List<FHN_Process_Data> bookTicket(@RequestBody List<FHN_Process_Data> processData) {
				service.saveProcess(processData);
				return processData;
			}
			
			 @GetMapping("process-list")  
			    public List<FHN_Process_Data> allProcessApps() {  
			         return service.getfhnProcessData();
			          
			    }
}

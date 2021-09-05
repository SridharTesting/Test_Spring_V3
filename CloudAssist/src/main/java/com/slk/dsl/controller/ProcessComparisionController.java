package com.slk.dsl.controller;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.slk.dsl.services.ProcessCompareService;


import com.slk.dsl.services.ProcessCompareService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProcessComparisionController {

	@Autowired
	ProcessCompareService service;
	
	@RequestMapping(value = "/compareFileBasedOnVerProcess/{id1}/{id2}")
	public ResponseEntity<Object> CompareFileOnGivenVer(@PathVariable int id1,@PathVariable int id2) {
		
		JSONArray arr=new JSONArray();
		
		arr=service.CompareFileOnGivenVerProcess(id1, id2);
		//System.out.println(arr.);
		return new ResponseEntity<>(arr.toList(), HttpStatus.OK);
		
		
	}
}

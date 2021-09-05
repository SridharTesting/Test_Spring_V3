package com.slk.dsl.controller;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slk.dsl.services.ApplicationCompareService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ApplicationCompareController {

	@Autowired
	ApplicationCompareService service;
	
	@RequestMapping(value = "/compareFileBasedOnVerApplication/{id1}/{id2}")
	public ResponseEntity<Object> CompareFileOnGivenVer(@PathVariable int id1,@PathVariable int id2) {
		
		JSONArray arr=new JSONArray();
		
		arr=service.CompareFileOnGivenVer(id1, id2);
		return new ResponseEntity<>(arr.toList(), HttpStatus.OK);
		
		
	}
}

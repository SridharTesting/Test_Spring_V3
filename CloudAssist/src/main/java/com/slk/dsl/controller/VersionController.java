package com.slk.dsl.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.slk.dsl.dto.AppsMappedTOLOBs;
import com.slk.dsl.model.Org;
import com.slk.dsl.model.Version_Table;
import com.slk.dsl.repository.VersionDAO;
import com.slk.dsl.services.VersionService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VersionController {

	@Autowired
	VersionService service;
	@Autowired
	VersionDAO repo;

	@RequestMapping(value = "/createVersion", method = RequestMethod.POST)
	public Version_Table createOrganisation(@RequestBody Version_Table versionDetails) {

		return service.saveVersion(versionDetails);
	}

	@GetMapping("getVersion/{id}")
	public List<Version_Table> getLOBMappedToUsers(@PathVariable int id){
		Map<String, Object> json = new HashMap();
		JSONArray array=new JSONArray();
		 
		List<Object[]>apps=repo.getVersionComparsion(2);
		System.out.println(apps.toString());
		
		  ArrayList<Version_Table> results = new ArrayList<>();

		
	
		apps.stream().forEach(objects->{ 
			
			
			
			 
			Version_Table version=new Version_Table();
			
			
			
		
			
			
			 
			results.add(version);
			
		 
		     
		     }
		
		
	
		);
		
		
		
	
		
				
				
		System.out.println(results);
		return results;


	
	}
}

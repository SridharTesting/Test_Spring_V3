package com.slk.dsl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.slk.dsl.repository.VersionNumberDAO;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VersionNumber {
	
	@Autowired
    VersionNumberDAO version;
	
	@GetMapping("getlatversion/{org_name}")
	public String getLOBMappedToUsers(@PathVariable String org_name){
		return version.getVersion(org_name);
	}
	
	
	@GetMapping("getHighestVersionNum/{org_id}")
	public int getHighestVersionNumFromTheDB(@PathVariable int org_id){
		return version.getVersion1(org_id);
	}
	
	@GetMapping("getlatversionum/{org_name}/{viewId}")
	public int getVersionNumber(@PathVariable String org_name,@PathVariable int viewId){
		return version.getVersions(org_name,viewId);
	}
}

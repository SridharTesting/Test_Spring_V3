package com.slk.dsl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slk.dsl.dto.BusinessProcess1AndOrgJoinResponse;
import com.slk.dsl.repository.BusinessProcess1MappingDao;

@RestController
@ControllerAdvice
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BusinessProcess1OrgMappingController {

	@Autowired
	private BusinessProcess1MappingDao busproc1Repo;
	
		
	@GetMapping("getOrgNameforBusProc")
	public List<BusinessProcess1AndOrgJoinResponse> getOrgNameMappedToBusProc1(){
		return busproc1Repo.getbusproc1orgmapping();
	}
	
	
}

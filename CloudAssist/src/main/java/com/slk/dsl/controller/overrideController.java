package com.slk.dsl.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
import com.slk.dsl.dto.overridedto;


import com.slk.dsl.model.LOB;
import com.slk.dsl.model.UserSetup;
import com.slk.dsl.model.override;
import com.slk.dsl.repository.LOBDao;
import com.slk.dsl.repository.overrideDAO;
import com.slk.dsl.services.LOBService;

import com.slk.dsl.services.overrideService;


@RestController
@ControllerAdvice
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class overrideController {

	
	@Autowired
	overrideService service;

	 @GetMapping("getoverride/{id}")
	 public List<overridedto> getlobByID(@PathVariable int id) {
		 return service.getoverride(id);
	 }
	
		/*
		 * @PutMapping("updaterlane/{appid}/{comments}/{stratergyid}") public void
		 * updaterlane(@PathVariable int appid,@PathVariable int
		 * stratergyid,@PathVariable String comments) { String
		 * stratergyIdString=String.valueOf(stratergyid);
		 * service.updaterlane(appid,stratergyIdString ,comments); }
		 */
	 
	 
	 
	 
//	  @PutMapping("updaterlane")
//			public void update(@RequestBody ApplicationModel appDetails) {
//		  
//		  String appid=appDetails.getAppId();
//		  int stratergyId=appDetails.getRlaneStrategyId();
//		  String comments=appDetails.getComments();
//		  
//		  
//			  service.updaterlane(appid ,stratergyId,comments);
//		  }
	  
}

package com.slk.dsl.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.slk.dsl.dto.CSBQuestionerDTO;
import com.slk.dsl.dto.QuestionerSubLookupDTO;
import com.slk.dsl.model.ApplicationLevelQuestioner;
import com.slk.dsl.services.ApplicationQuestionerService;
import com.slk.dsl.services.CSBQuestionerService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ApplicationQuestionerController {
	

	@Autowired
	ApplicationQuestionerService service;
	
	
	
	@RequestMapping(value ="/appquestionerpost/{orgId}", method = RequestMethod.POST) 
	public void AppPostQuestion(@RequestBody List<ApplicationLevelQuestioner> list,@PathVariable int orgId ) throws IOException{  
         service.AppPostQuestioner(list,orgId);
   }
	
	@RequestMapping(value ="/appquestionerdelete/{appid}", method = RequestMethod.DELETE) 
	public void DeleteQuestion(@PathVariable int appid) {  
         service.DeleteAppQuestioner(appid);
   }
	
	@GetMapping("getsublookup/{name}") 
	public List<QuestionerSubLookupDTO> getsublookup(@PathVariable String name) {  
      return  service.getsublookup(name);
  }
	
}

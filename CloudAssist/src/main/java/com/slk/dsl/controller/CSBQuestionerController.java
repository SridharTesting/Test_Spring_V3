package com.slk.dsl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.slk.dsl.dto.CSBQuestionerDTO;
import com.slk.dsl.dto.OrgQuestionerDTO;
import com.slk.dsl.model.ApplicationLevelQuestioner;
import com.slk.dsl.model.QuestionerResponse;
import com.slk.dsl.services.CSBQuestionerService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CSBQuestionerController {

	@Autowired
	CSBQuestionerService service;
	
	@GetMapping("/csbquestioner/{orgid}")  
    public List<OrgQuestionerDTO> allBaseApps(@PathVariable int orgid) {  
         return service.getquestionerData(orgid);
          
    }
	
	@GetMapping("csbquestionerapplevel/{orgid}")  
    public List<CSBQuestionerDTO> csbquestionerapplevel(@PathVariable int orgid) {  
         return service.getquestionerDataAppLevel(orgid);
          
    }
	
	@GetMapping("csbquestionerapplevelselectedvalue/{appid}")  
    public List<CSBQuestionerDTO> getquestionerDataAppLevelSelectedValue(@PathVariable int appid){
		return service.getquestionerDataAppLevelSelectedValue(appid);
	}
	 
	
	@RequestMapping(value ="/csbquestionerpost", method = RequestMethod.POST) 
	public void PostQuestion(@RequestBody List<QuestionerResponse> list ) {  
         service.PostQuestioner(list);
   }
	
	
	@RequestMapping(value ="/csbquestionerdelete/{orgid}", method = RequestMethod.DELETE) 
	public void DeleteQuestion(@PathVariable int orgid) {  
         service.DeleteQuestioner(orgid);
   }
	
	
	
	
	    
	    
	
	
}

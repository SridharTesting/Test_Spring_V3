package com.slk.dsl.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.slk.dsl.dto.QuestionerAndFieldLookup;
import com.slk.dsl.model.ApplicationQuestionUpload;
import com.slk.dsl.model.InfrastructureQuestionsUpload;
import com.slk.dsl.model.ProcessQuestionUpload;
import com.slk.dsl.model.fhn_infrastructure_dataTable;
import com.slk.dsl.repository.Neo4jFilterDAO;
import com.slk.dsl.services.Neo4jFilterservice;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Neo4jFilter {
	@Autowired
	 Neo4jFilterservice service;
	
	
	@GetMapping("getfilter/{viewtype}")  
    public List<QuestionerAndFieldLookup> Filter(@PathVariable int viewtype) {  
		List<QuestionerAndFieldLookup> combinedResult = new ArrayList<QuestionerAndFieldLookup>();
		
		combinedResult=service.Filter(viewtype);
		return combinedResult;
//          
    }
	
	

	@GetMapping("getfilterselectedinfra/{attribute}")  
    public List<InfrastructureQuestionsUpload> Filterselectedinfrastructure(@PathVariable String attribute) {  
		//List<fhn_infrastructure_dataTable> combinedResult = new List<fhn_infrastructure_dataTable>();
		List<InfrastructureQuestionsUpload> combinedResult=new ArrayList<InfrastructureQuestionsUpload>();
		combinedResult=service.Filterselectedinfra(attribute);
		return combinedResult;
	
//          
    }
	
	@GetMapping("getfilterselectedapp/{attribute}")  
    public List<ApplicationQuestionUpload> Filterselectedapplication(@PathVariable String attribute) {  
		//List<fhn_infrastructure_dataTable> combinedResult = new List<fhn_infrastructure_dataTable>();
		List<ApplicationQuestionUpload> combinedResult=new ArrayList<ApplicationQuestionUpload>();
		combinedResult=service.Filterselectedapp(attribute);
		return combinedResult;
	
//          
    }
	
	
	@GetMapping("getfilterselectedprocess/{attribute}")  
    public List<ProcessQuestionUpload> Filterselectedprocess(@PathVariable String attribute) {  
		//List<fhn_infrastructure_dataTable> combinedResult = new List<fhn_infrastructure_dataTable>();
		List<ProcessQuestionUpload> combinedResult=new ArrayList<ProcessQuestionUpload>();
		combinedResult=service.Filterselectedprocess(attribute);
		return combinedResult;
	
//          
    }

}

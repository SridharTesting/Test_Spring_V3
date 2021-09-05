package com.slk.dsl.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.slk.dsl.services.QuestionerService;
import com.slk.dsl.model.QuestionerReturnedModel;
import com.slk.dsl.model.fhn_infrastructure_dataTable;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class QuestionerController {

	@Autowired
	QuestionerService service;
	
	
	
	@RequestMapping(value = "/getque/{id}/{viewtype}")
	public List<QuestionerReturnedModel> FindAllQuestioner(@PathVariable int id,@PathVariable int viewtype) {

		return service.FindAQuestioner(id,viewtype);

	}
//	
////	
	@RequestMapping(value = "/postque/{viewtype}",method = RequestMethod.PUT)
	public List<QuestionerReturnedModel> UpdateQuestioner(@RequestBody List<QuestionerReturnedModel> model,@PathVariable int viewtype) {
		List<QuestionerReturnedModel> result = new ArrayList<QuestionerReturnedModel>();
		
			result = service.PutQuestioner(model,viewtype);
		
		return result;
		

	}
	
	
}

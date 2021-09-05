package com.slk.dsl.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;


import com.slk.dsl.model.questionare;
import com.slk.dsl.repository.questionareDAO;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class questionareController {

	@Autowired
	questionareDAO version;

	@GetMapping("GetQuestionerTemplate/{org_id}/{viewtype}")
	public List<questionare> getquestionare(@PathVariable int org_id,@PathVariable int viewtype) {
		return version.GetQuestionerTemplate(org_id,viewtype);
	}
}
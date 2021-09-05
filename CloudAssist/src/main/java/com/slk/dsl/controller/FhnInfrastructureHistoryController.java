package com.slk.dsl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.slk.dsl.dto.FhnversioningInfrstructure;
import com.slk.dsl.model.Fhn_infra_data_history;
import com.slk.dsl.services.Fhn_infra_data_history_Service;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FhnInfrastructureHistoryController {

	@Autowired
	Fhn_infra_data_history_Service service;
	
	@RequestMapping(value = "/upinfradatahistory", method = RequestMethod.POST)
	public void update(@RequestBody FhnversioningInfrstructure processList ) {
		  
		List<Fhn_infra_data_history> process=processList.getProcessData();
		int versionId=processList.getVersionId();
		service.saveFhnInfraDataHistory(process,versionId);
//		service.saveFhnInfraDataHistory(appData);
		  
	  }
}

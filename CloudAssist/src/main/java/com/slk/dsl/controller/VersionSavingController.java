package com.slk.dsl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.slk.dsl.dto.ApplicationVersionDto;
import com.slk.dsl.dto.infraversionDTO;
import com.slk.dsl.model.ApplicationVersionData;
import com.slk.dsl.model.Fhn_infra_data_history;
import com.slk.dsl.model.InfrastructureVersionData;
import com.slk.dsl.services.VersionDataSaveService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class VersionSavingController {

	@Autowired
	VersionDataSaveService service;

	/*
	 * @PostMapping("/processhistoryData") public List<FHN_Process_history_data>
	 * processHistory(@RequestBody FHNVersioningProcess processList) {
	 * //System.out.println(processData); List<FHN_Process_history_data>
	 * process=processList.getProcessData(); int
	 * versionId=processList.getVersionId(); service.saveProcess(process,versionId);
	 * //return processData; return process; }
	 */

	@PostMapping("/appVersioningData")
	public List<ApplicationVersionData> applicationVersion(@RequestBody ApplicationVersionDto appList) {
		List<ApplicationVersionData> applications = appList.getAppData();
		int versionId = appList.getVersionId();
		service.saveApps(applications, versionId);

		return applications;

	}

	@PostMapping("/infraversioningData")
	public List<InfrastructureVersionData> infraVersion(@RequestBody infraversionDTO infraList) {
		List<InfrastructureVersionData> infra = infraList.getInfraData();
		int versionId = infraList.getVersionId();
		service.saveInfra(infra, versionId);

		return infra;

	}
	
	
//	  @PostMapping(value = "/upinfradatahistory") 
//	  public void update(@RequestBody Infrstructureversioning infraList ) {
//	   List<InfrastructureVersionData> infra=infraList.getProcessData(); 
//	  int versionId=infraList.getVersionId();
//	  service.saveFhnInfraDataHistory(infra, versionId);
//	 
//	  
//	  }
//	 

}
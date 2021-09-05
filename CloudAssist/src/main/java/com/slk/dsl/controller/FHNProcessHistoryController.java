package com.slk.dsl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.slk.dsl.dto.ApplicationVersionDto;
import com.slk.dsl.dto.FHNVersioningProcess;
import com.slk.dsl.model.FHNAppVersionData;
import com.slk.dsl.model.FHN_Process_history_data;
import com.slk.dsl.repository.FHNApplicationDataDAO;
import com.slk.dsl.services.FHNProcessHistoryData;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class FHNProcessHistoryController {
@Autowired
FHNProcessHistoryData service;

	  @PostMapping("/processhistoryData")
		public List<FHN_Process_history_data> processHistory(@RequestBody FHNVersioningProcess processList) {
			//System.out.println(processData);
			List<FHN_Process_history_data> process=processList.getProcessData();
			int versionId=processList.getVersionId();
			service.saveProcess(process,versionId);
			//return processData;
			return process;
		}
		
//		 @PostMapping("/appVersioningData")
//			public List<FHNAppVersionData> applicationVersion(@RequestBody ApplicationVersionDto appList) {
//				List<FHNAppVersionData> applications=appList.getAppData();
//			 int versionId=appList.getVersionId();
//			 service.saveApps(applications,versionId);
//				
//				return applications;
//			
//			}
//	
	
}

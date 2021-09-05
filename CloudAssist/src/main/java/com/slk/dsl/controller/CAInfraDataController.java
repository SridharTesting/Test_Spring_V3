package com.slk.dsl.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.slk.dsl.dto.AddInfraDTO;
import com.slk.dsl.dto.OsNamesDTO;
//import com.slk.dsl.dto.CAAPPMasterdto;
import com.slk.dsl.dto.migrationdto;
import com.slk.dsl.model.Application;
import com.slk.dsl.model.Ca_infra_app_mapping;
import com.slk.dsl.model.InfraDataModel;
import com.slk.dsl.services.CAAppMasterService;
import com.slk.dsl.services.CAInfraDataService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class CAInfraDataController {
	@Autowired
	CAInfraDataService service;
	
	
	 @GetMapping("CAInfra")  
	    public List<InfraDataModel> CAInfradata() {  
	         return service.CAInfra();
	          
	 }
	 
	 
	 @GetMapping("data-infra/{orgId}")  
	    public List<InfraDataModel> allBaseApps(@PathVariable int orgId) {  
	         return service.getfhnInfraData(orgId);
	          
	    }
	 

	
	@GetMapping("getphysical/{orgId}")  
	public List<migrationdto> getphisical(@PathVariable int orgId) {
		return service.getphysical(orgId);

	}
	
	@GetMapping("getenvironmentvsServerbyAPP/{orgId}")  
	public List<migrationdto> getenvironmentvsServer(@PathVariable int orgId) {
		return service.getenvironmentvsServer(orgId);

	}
	
	
	@GetMapping("getenvironmentvsServerbyDATA/{orgId}")  
	public List<migrationdto> getenvironmentvsServerbyDATA(@PathVariable int orgId) {
		return service.getenvironmentvsServerbyDATA(orgId);

	}
	
	
	
	
	@GetMapping("getDataIp")  
	public List<OsNamesDTO> DatavsIp() {
		return service.DatavsIp();

	}
	
	

	@GetMapping("OSVsData/{orgId}")  
	public List<OsNamesDTO> OSVsData(@PathVariable int orgId) {
		return service.OSVsData( orgId);

	}
	
	//•	Application View By LOB 
	//Total Number of applications by Line Of Business 

	@GetMapping("LOBchart/{orgId}")  
	public List<migrationdto> LOBchart(@PathVariable int orgId) {
		return service.LOBchart(orgId);

	}
	
	//infrapage
	@GetMapping("OScount")  
	public List<migrationdto> os_count() {
		return service.getoscount();

	}
	
	
	//infrapage
	@GetMapping("Environmentcount/{orgId}")  
	public List<migrationdto> Environmentcount(@PathVariable int orgId) {
		return service.getEnvironmentcount(orgId);

	}
	
	//infrapage
		@GetMapping("applicationcount/{orgId}")  
		public List<migrationdto> applicationcount(@PathVariable int orgId) {
			return service.getapplicationcount( orgId);

		}
		
		 @PutMapping("updateInfra")
			public void updatecaappmaster(@RequestBody List<InfraDataModel> appDetails) {

		  
			 
			  service.updateinfra(appDetails);
		  }
		
		 @DeleteMapping("/deleteinfrarecord/{infraId}")  
		    private void deleteBook(@PathVariable("infraId") int infraId)   
		    {  
		    	service.delete(infraId);  
		    } 

			@PostMapping("/addinfrarecord")
			public AddInfraDTO uploadinfrarecord(@RequestBody AddInfraDTO appData) {
				service.saveinfra(appData);
				return appData;
			}
			
		 
		 
}

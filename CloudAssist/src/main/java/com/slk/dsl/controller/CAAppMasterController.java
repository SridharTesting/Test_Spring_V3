package com.slk.dsl.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.slk.dsl.dto.ApplicationSurveycountDTO;
import com.slk.dsl.dto.DataCatDto;
import com.slk.dsl.dto.OsNamesDTO;
import com.slk.dsl.dto.UserDashboardDTO;
import com.slk.dsl.dto.VendorandDateDTO;
//import com.slk.dsl.dto.CAAPPMasterdto;
import com.slk.dsl.dto.migrationdto;
import com.slk.dsl.model.Application;
import com.slk.dsl.model.CAAppMaster;
import com.slk.dsl.model.FHNAppBaseTable;
import com.slk.dsl.model.InfraDataModel;
import com.slk.dsl.model.Rlane_Strategy_Lkp;
import com.slk.dsl.model.fhn_infrastructure_dataTable;
import com.slk.dsl.model.Application;
import com.slk.dsl.model.Application;
import com.slk.dsl.services.CAAppMasterService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CAAppMasterController {
	@Autowired
	CAAppMasterService service;
	
	@GetMapping("getapppercent/{orgId}")  
	public  List<migrationdto> gettotalapp(@PathVariable int orgId) {  
		return service.gettotalapp(orgId);

	}
	
	
	
	
	@GetMapping("getostochart/{orgId}")  
	public List<OsNamesDTO> getoschart(@PathVariable int orgId) {
		return service.getoschart(orgId);
	}

		 @PutMapping("rlane")
			public Application update(@RequestBody Application rlaneDetails) {
			  return service.saverlane(rlaneDetails);
			  
		  }
		 
		 @GetMapping("rlanedropdown/{id}")  
			public Optional<Application> lobapp(@PathVariable int id)  {  
				return service.getrlane(id);

			}
  
		 @GetMapping("caap-list")  
		    public List<Application> allrlanes() {  
		         return service.getapp();
		          
		    }
		 @PutMapping("updatecaappmaster")
			public void updatecaappmaster(@RequestBody List<Application> appDetails) {

		  
			 
			  service.updatecaappmaster(appDetails);
		  }
		

	@GetMapping("getvendoranddate/{orgId}")  
	public List<VendorandDateDTO> getdateandvendorcount(@PathVariable int orgId) {
		return service.getdateandvendorcount(orgId);

	}
	
	
	
	@GetMapping("Applicationcriticality/{orgId}")  
	public List<VendorandDateDTO> getApplicationcriticality(@PathVariable int orgId) {
		return service.getApplicationcriticality(orgId);

	}
	
	@GetMapping("Datacriticality/{orgId}")  
	public List<VendorandDateDTO> getDatacriticality(@PathVariable int orgId) {
		return service.getDatacriticality(orgId);

	}
	
	@GetMapping("getlobcount/{orgId}")  
	public List<VendorandDateDTO> getLobCount(@PathVariable int orgId) {
		return service.getLobount(orgId);

	}
	
	@GetMapping("getApplicationSurveycount/{orgId}")  
	public List<ApplicationSurveycountDTO> ApplicationSurveycount(@PathVariable int orgId) {
		return service.getApplicationSurveycount(orgId);

	}
	
	  @GetMapping("CAAppMaster/{orgId}")  
	    public List<Application[]> alllobs(@PathVariable int orgId) {  
	         return service.CAAppMaster(orgId);
	          
	         
	    }
	    

//		  @GetMapping("data-infra/{orgId}")  
//		    public List<InfraDataModel[]> alllobs2(@PathVariable int orgId) {  
//		         return service.datainfra(orgId);
//		          
//		         
//		    }
	  @GetMapping("migration-datacat/{orgId}")  
		public List<List<DataCatDto>> Datacat(@PathVariable int orgId)  {  
			return service.DataCat(orgId);

		}
		

		@GetMapping("migration-appcat/{orgId}")  
		public List<List<DataCatDto>> Appcatt(@PathVariable int orgId)  {  
			return service.APPCat1(orgId);

		}
	
		@GetMapping("getrlanestrategy")  
		public List<Rlane_Strategy_Lkp> getrLane()  {  
			return service.rlanestrategy();

		}
	
			@PostMapping("/addapp")
			public Application uploadApplicationData(@RequestBody Application appData) {
				service.saveApplication(appData);
				return appData;
			}

		 
			@GetMapping("userdashboard/{lobId}")  
			public List<UserDashboardDTO> userdashboard(@PathVariable int lobId) {
				return service.getuserdashboard(lobId);

			}
		 
		 
	
}

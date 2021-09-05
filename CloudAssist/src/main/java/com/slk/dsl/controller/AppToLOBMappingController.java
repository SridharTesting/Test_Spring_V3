package com.slk.dsl.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.slk.dsl.dto.AppsMappedTOLOBs;
import com.slk.dsl.model.AppLOBLinkingTable;
import com.slk.dsl.model.AppToLOBMapping;
import com.slk.dsl.repository.AppToLOBMappingDAO;
import com.slk.dsl.services.AppLobLinkingService;
import com.slk.dsl.services.ApptoLOBMappingService;

@RestController
@ControllerAdvice
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AppToLOBMappingController {
	@Autowired
	ApptoLOBMappingService service;
	
	@Autowired
	AppLobLinkingService linkService;
	
	@Autowired
	AppToLOBMappingDAO repo;
	
	@GetMapping("app-list")  
    public List<AppToLOBMapping> alllobs() {  
         return service.getApps();
          
    }
	
	@GetMapping("lobMappedToApps")  
    public List<AppLOBLinkingTable> lobsMappedToApps() {  
         return linkService.getLobsMappedToApps();
    }
	
		
	@GetMapping("getAppsTaggedToLOB/{id}")
	public ArrayList<AppsMappedTOLOBs> getLOBMappedToUsers(@PathVariable int id){
		Map<String, Object> json = new HashMap();
		JSONArray array=new JSONArray();
		 
		List<Object[]>apps=repo.getAppsTaggedToLOBS(id);
		
		  ArrayList<AppsMappedTOLOBs> results = new ArrayList<>();

		
	
		apps.stream().forEach(objects->{ 
			
			AppsMappedTOLOBs app=new AppsMappedTOLOBs();
			app.setAppId((Integer) objects[0]);
			app.setAppName(objects[1].toString());
			app.setAppDesc(objects[2].toString());
			app.setAppChecked( objects[3].toString());
			results.add(app);
			
		 
		     
		     }
		
		
	
		);
		
		System.out.println(results);
		return results;

	}
	 @RequestMapping(value = "/mapApps", method = RequestMethod.POST)
		public AppLOBLinkingTable mapApps(@RequestBody AppLOBLinkingTable appDetails) {

			

			return linkService.saveLobsMappedToApps(appDetails);
		}
	
	  @DeleteMapping("appsdelfromlob/{id}")
	  public String delete(@PathVariable int id) {
		  linkService.delete(id);
		  return "app deleted from lob";
	  }

	 
	 
}

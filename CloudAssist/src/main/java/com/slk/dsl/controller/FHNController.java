package com.slk.dsl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.slk.dsl.model.FHNAppBaseTable;
import com.slk.dsl.dto.DataCatDto;
import com.slk.dsl.dto.migrationdto;

import com.slk.dsl.services.FHNBaseTableService;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FHNController {

	@Autowired
	FHNBaseTableService service;
	@GetMapping("data-list")  
	public List<FHNAppBaseTable> allBaseApps() {  
		return service.getfhnAppData();

	}


	@PutMapping("appData")
	public List<FHNAppBaseTable> update(@RequestBody List<FHNAppBaseTable> appData) {
		service.saveApplication(appData);
		return appData;

	}


	@PostMapping("/appUpload")
	public List<FHNAppBaseTable> uploadApplicationData(@RequestBody List<FHNAppBaseTable> appData) {
		service.saveApplication(appData);
		return appData;
	}
	
	@GetMapping("migration-list/{orgId}")  
	public List<migrationdto> allmigration(@PathVariable int orgId) {  
		return service.migration(orgId);

	}
	@GetMapping("rlane/{lobId}/{orgId}")  
	public List<migrationdto> rlane(@PathVariable int lobId,@PathVariable int orgId) {  
		return service.rlane(lobId,orgId);

	}
//	@GetMapping("migration-datacat")  
//	public List<List<DataCatDto>> Datacat()  {  
//		return service.DataCat();
//
//	}
	
//	@GetMapping("appcat")  
//	public List<migrationdto>  Appcat()  {  
//		return service.Appcat();
//
//	}
	
	

//	@GetMapping("migration-appcat")  
//	public List<List<DataCatDto>> Appcatt()  {  
//		return service.APPCat1();
//
//	}
}

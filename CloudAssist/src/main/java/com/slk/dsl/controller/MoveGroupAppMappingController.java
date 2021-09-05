package com.slk.dsl.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.slk.dsl.dto.MoveGroupApplicationsDTO;
import com.slk.dsl.dto.MoveGroupRehostApplicationsDTO;
import com.slk.dsl.model.MoveGroup;
//import com.slk.dsl.model.MoveGroup;
import com.slk.dsl.model.MoveGroupAppMapping;
import com.slk.dsl.services.MoveGroupAppMappingService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MoveGroupAppMappingController {

	@Autowired
	MoveGroupAppMappingService Service;
	

	@PostMapping("/createMoveGroupAppMapping")
	

	public MoveGroupAppMapping groupDetails(@RequestBody MoveGroupAppMapping movegroupList) {
		
		return Service.saveMoveGroupApp(movegroupList);
	}

		@GetMapping("getAppNames/{MoveGroupId}")
		
		public List<MoveGroupApplicationsDTO> getAppNames(@PathVariable int MoveGroupId){
			return Service.getAppNames(MoveGroupId);
	
}
		@GetMapping("getAppRehostNames/{orgId}")
		
		public List<MoveGroupRehostApplicationsDTO> getAppNames1(@PathVariable int orgId){
			return Service.getRehostapp(orgId);
	}
		
		 @DeleteMapping("deleteApp/{id}")
		  public String delete(@PathVariable int id)  {
			  
			  Service.delete(id);
			  return "App deleted";
		  }
		 @GetMapping("getMoveGroupMapById")
			
			public List<MoveGroupAppMapping> retrieveGroupById(){
				return Service.getGroupById();
}
}
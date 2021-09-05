package com.slk.dsl.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.slk.dsl.dto.ApplicationVersionDto;
import com.slk.dsl.model.AppLOBLinkingTable;
import com.slk.dsl.model.ApplicationVersionData;
import com.slk.dsl.model.MoveGroup;
import com.slk.dsl.model.UserSetup;
import com.slk.dsl.services.MoveGroupService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class MoveGroupController {
	
	@Autowired
	MoveGroupService service;
	
	@PostMapping("/createMoveGroup/{orgId}")
	
	public MoveGroup groupDetails(@RequestBody MoveGroup movegroupList, @PathVariable int orgId) {
		
		return service.saveMoveGroup(movegroupList,orgId);

	
}
	@GetMapping("getMoveGroup/{orgId}")
	
		public List<MoveGroup[]> retrieveAllGroup(@PathVariable int orgId){
			return service.getMoveGRoups(orgId);
		
	}
	@GetMapping("getMoveGroupbyId/{id}")
	
	public Optional<MoveGroup> retrieveGroupById(@PathVariable int id){
		return service.getGroupById(id);
	
}
	 @PutMapping("UpdateGroup")
		public void update(@RequestBody MoveGroup grpDetails) {
		   service.updateGroup(grpDetails);
		  
	  }


}
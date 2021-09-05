package com.slk.dsl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.slk.dsl.dto.LOBandUserJoinResponse;
import com.slk.dsl.dto.OrgAndLobJoinResponse;
import com.slk.dsl.repository.LobMappingDAO;
import com.slk.dsl.repository.OrgMappingDao;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class orgLOBMappingController {

	
	
	
	@Autowired
	private OrgMappingDao orgRepo;
	
	@Autowired
	private LobMappingDAO lobRepo;
	
	
	@GetMapping("getOrgNameforLOB/{orgId}")
	public List<OrgAndLobJoinResponse> getOrgNameMappedToLOB(@PathVariable int orgId){
		return orgRepo.getOrgLObMapping(orgId);
	}
	@GetMapping("getLobnameforusers")
	public List<LOBandUserJoinResponse> getLOBMappedToUsers(){
		return lobRepo.getLOBUserMapping();
	}
	
	
	
	
}

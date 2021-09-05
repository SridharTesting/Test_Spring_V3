package com.slk.dsl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slk.dsl.model.AppLOBLinkingTable;
import com.slk.dsl.model.Application;
import com.slk.dsl.model.BusinessProcess1;
import com.slk.dsl.model.MoveGroup;
import com.slk.dsl.model.UserSetup;
import com.slk.dsl.repository.MoveGroupRepo;

@Service
public class MoveGroupService {
	
	
	@Autowired
	MoveGroupRepo group;
	
	public MoveGroup saveMoveGroup(MoveGroup grpDetails, int orgId) {
		MoveGroup grp = new MoveGroup();
		
		
	    grp.setMoveGroupId(grpDetails.getMoveGroupId());
	    grp.setOrgId(orgId);
		grp.setMoveGroupName(grpDetails.getMoveGroupName());
		grp.setMigrationStartdt(grpDetails.getMigrationStartdt());
		grp.setMigrationEnddt(grpDetails.getMigrationEnddt());
		grp.setRecInsDt(grpDetails.getRecInsDt());
		grp.setRecUpdDt(grpDetails.getRecUpdDt());
		return group.save(grp);
	}
//	public List<AppLOBLinkingTable> getLobsMappedToApps() {  
//        return appLobLinkRepo.findAll();  
//    } 
//	
	public List<MoveGroup[]> getMoveGRoups(int orgId){
		
		return group.findByOrgId(orgId);
	}
	

public Optional<MoveGroup> getGroupById(int id){
		
		return group.findById(id);
	
}


public void updateGroup(MoveGroup grpDetails) {
	String moveGroupName=grpDetails.getMoveGroupName();
	int id=grpDetails.getMoveGroupId();
	group.updateGroup(moveGroupName,id);
	
}





}
package com.slk.dsl.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.slk.dsl.dto.MoveGroupApplicationsDTO;
import com.slk.dsl.dto.MoveGroupRehostApplicationsDTO;
import com.slk.dsl.dto.migrationdto;
import com.slk.dsl.model.MoveGroup;
//import com.slk.dsl.model.MoveGroup;
import com.slk.dsl.model.MoveGroupAppMapping;
import com.slk.dsl.repository.MoveGroupAppMappingRep;


@Service
public class MoveGroupAppMappingService {
	@Autowired
	MoveGroupAppMappingRep repo;
	
	
	public MoveGroupAppMapping saveMoveGroupApp(MoveGroupAppMapping grpDetails) {
		MoveGroupAppMapping grp = new MoveGroupAppMapping();
	
		grp.setMoveGroupAppID(grpDetails.getMoveGroupAppID());
		grp.setMoveGroupID(grpDetails.getMoveGroupID());
		grp.setAppMasterId(grpDetails.getAppMasterId());
		grp.setRecInsDT(grpDetails.getRecInsDT());
		grp.setRecUpDT(grpDetails.getRecUpDT());
	    
		return ((CrudRepository<MoveGroupAppMapping, Integer>) repo).save(grp);
	}
	
public List<MoveGroupApplicationsDTO> getAppNames(int MoveGroupId){
	List<Object[]> queryResult = repo.getAppName(MoveGroupId);
	List<MoveGroupApplicationsDTO> result = new ArrayList<MoveGroupApplicationsDTO>();

	queryResult.stream().forEach(objects->{
		MoveGroupApplicationsDTO temp = new MoveGroupApplicationsDTO();
		temp.setApp_Name(objects[0].toString());
		temp.setApp_Master_Id((Integer)objects[1]);
		result.add(temp);
		});
	return result;
	
	
	
}


public List<MoveGroupRehostApplicationsDTO> getRehostapp(int orgId) {  
	List<Object[]> queryResult = repo.getRehost(orgId);
	List<MoveGroupRehostApplicationsDTO> result = new ArrayList<MoveGroupRehostApplicationsDTO>();

	queryResult.stream().forEach(objects->{
		MoveGroupRehostApplicationsDTO temp = new MoveGroupRehostApplicationsDTO();
		temp.setApp_Master_Id((Integer)objects[0]);
		temp.setApp_Name(objects[1].toString());
		result.add(temp);
		});
	return result;
	}

public String delete(int id) {
	
	 repo.deleteapp(id);
	  return "App deleted";
}

public List<MoveGroupAppMapping> getGroupById(){
	
	return repo.findAll();
}
}

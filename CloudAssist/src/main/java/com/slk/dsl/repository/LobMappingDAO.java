package com.slk.dsl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.slk.dsl.dto.LOBandUserJoinResponse;
import com.slk.dsl.dto.OrgAndLobJoinResponse;
import com.slk.dsl.model.LOBMapping;
@Repository
public interface LobMappingDAO extends JpaRepository<LOBMapping, Integer>{
	
	
	@Query("select new com.slk.dsl.dto.LOBandUserJoinResponse(u.userId,l.lobId,l.lobName,u.firstName,u.lastName,u.emailId) from LOBMapping l JOIN UserSetup u on l.lobId=u.lobId")
	public List<LOBandUserJoinResponse> getLOBUserMapping(); 
	
	
	

}


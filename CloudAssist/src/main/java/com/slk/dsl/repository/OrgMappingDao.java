package com.slk.dsl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.slk.dsl.dto.OrgAndLobJoinResponse;
import com.slk.dsl.model.LOB;
import com.slk.dsl.model.OrgMapping;



public interface OrgMappingDao extends JpaRepository<OrgMapping,Integer>{

	
	
	@Query("select new com.slk.dsl.dto.OrgAndLobJoinResponse(o.orgId,o.orgName,l.lobName,l.lobManager,l.lobId) from OrgMapping o JOIN LOB l on o.orgId=l.orgId where o.orgId=:orgId")
	public List<OrgAndLobJoinResponse> getOrgLObMapping(int orgId); 
	
	
	
	

}

package com.slk.dsl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.slk.dsl.dto.BusinessProcess1AndOrgJoinResponse;
import com.slk.dsl.model.BusinessProcess1Mapping;

@Repository
public interface BusinessProcess1MappingDao extends JpaRepository<BusinessProcess1Mapping, Integer>{
	
	@Query("select new com.slk.dsl.dto.BusinessProcess1AndOrgJoinResponse(o.orgId,o.orgName,b.busproLevel1Name,b.busproLevel1Desc,b.busproLevel1Id) from  BusinessProcess1Mapping b JOIN Org o on b.orgId=o.orgId")
	public List<BusinessProcess1AndOrgJoinResponse> getbusproc1orgmapping(); 

}

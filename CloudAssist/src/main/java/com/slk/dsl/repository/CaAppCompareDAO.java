package com.slk.dsl.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.slk.dsl.model.ApplicationVersionData;
import com.slk.dsl.model.InfrastructureVersionData;
@Repository
public interface CaAppCompareDAO extends JpaRepository<ApplicationVersionData,Integer> {
	String findInfraQuery = "select * from ca_app_master_versioning  where versionId=:id and Org_Id=:orgId";
	@Query(value = findInfraQuery, nativeQuery = true)
	public List<ApplicationVersionData> VersionComparsion(Integer orgId, Integer id);
	
	@Query(value = findInfraQuery, nativeQuery = true)
	public List<ApplicationVersionData> VersionComparsion2(Integer orgId, Integer id);
}

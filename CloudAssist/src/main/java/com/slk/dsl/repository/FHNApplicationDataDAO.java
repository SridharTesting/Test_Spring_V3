package com.slk.dsl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.slk.dsl.model.Fhn_infra_data_history;
import com.slk.dsl.model.InfrastructureVersionData;


@Repository
public interface FHNApplicationDataDAO extends JpaRepository<InfrastructureVersionData,Integer> {
	String findQuery = "select * from fhn_infrastructure_data_versioning where versionId=:id";
	@Query(value = findQuery, nativeQuery = true)
	public List<Fhn_infra_data_history> getVersionComparsion(Integer id);
	
	String findInfraQuery = "select * from ca_infra_data_versioning  where versionId=:id and Org_Id=:orgId";
	@Query(value = findInfraQuery, nativeQuery = true)
	public List<InfrastructureVersionData> VersionComparsion(Integer orgId,Integer id);
	
	@Query(value = findInfraQuery, nativeQuery = true)
	public List<InfrastructureVersionData> VersionComparsion2(Integer orgId,Integer id);
	
	@Query(value = findQuery, nativeQuery = true)
	public List<Fhn_infra_data_history> getVersionComparsion2(Integer id);
}

package com.slk.dsl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.slk.dsl.model.FHNAppVersionData;
import com.slk.dsl.model.FHN_Process_history_data;

@Repository
public interface ApplicationCompareDAO extends JpaRepository<FHNAppVersionData,Integer> {

	String findQuery = "select * from fhn_application_versioning_data where versionId=:id";

	@Query(value = findQuery, nativeQuery = true)
	public List<FHNAppVersionData> getVersionComparsion(Integer id);
	
	@Query(value = findQuery, nativeQuery = true)
	public List<FHNAppVersionData> getVersionComparsion2(Integer id);
}

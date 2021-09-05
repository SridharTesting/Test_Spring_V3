package com.slk.dsl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.slk.dsl.model.FHN_Process_history_data;
import com.slk.dsl.model.Fhn_infra_data_history;


public interface FHNProcessCompareDataDAO extends JpaRepository<FHN_Process_history_data,Integer> {
	
	String findQuery = "select * from fhn_process_version_table where versionId=:id";

	@Query(value = findQuery, nativeQuery = true)
	public List<FHN_Process_history_data> getVersionComparsion(Integer id);
	
	@Query(value = findQuery, nativeQuery = true)
	public List<FHN_Process_history_data> getVersionComparsion2(Integer id);
}

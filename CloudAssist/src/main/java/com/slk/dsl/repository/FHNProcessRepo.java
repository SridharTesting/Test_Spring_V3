package com.slk.dsl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.slk.dsl.model.FHN_Process_Data;
@Repository
public interface FHNProcessRepo extends JpaRepository<FHN_Process_Data, Integer>{
	String fhn_process = "select appId from fhn_process_data  ";
	@Query(value=fhn_process,nativeQuery=true)
	public List<Object[]> get_process();

}

package com.slk.dsl.repository;

import java.util.List;

import javax.persistence.Lob;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.slk.dsl.model.FHNAppVersionData;
import com.slk.dsl.model.LOB;

@Repository
public interface LOBRepo extends JpaRepository<LOB, Integer>{
	String findQuery = "select * from ca_lob_master where Org_Id=:id and Lob_Name=:name";

	@Query(value = findQuery, nativeQuery = true)
	public List<Object[]> getlobDistinctValues(Integer id,String name);
	
}

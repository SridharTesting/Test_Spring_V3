package com.slk.dsl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.slk.dsl.model.FieldLookup;

@Repository
public interface FieldLookupDAO extends JpaRepository<FieldLookup,Integer>{

	
	String findfieldlookupTableQuery = "select * from field_lookup";
	@Query(value = findfieldlookupTableQuery, nativeQuery = true)
	public List<FieldLookup> getFieldlookupTable();
}

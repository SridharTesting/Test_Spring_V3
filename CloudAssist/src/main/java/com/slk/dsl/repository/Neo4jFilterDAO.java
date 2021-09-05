package com.slk.dsl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.slk.dsl.model.fhn_infrastructure_dataTable;

public interface Neo4jFilterDAO extends JpaRepository<fhn_infrastructure_dataTable,Integer>{
	
	
	String findjoininfra = "  SELECT field_Name,field_AliasName from field_lookup where field_Name in (\r\n"
			+ "  SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'fhn_infrastructure_data');"; 
	@Query(value = findjoininfra , nativeQuery = true)
public List<Object[]> getjoinedTableinfra();


String findjoinapp = "  SELECT field_Name,field_AliasName from field_lookup where field_Name in (\r\n"
		+ "  SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'fhn_application_data');"; 
@Query(value =findjoinapp, nativeQuery = true)
public List<Object[]> getjoinedTableapp();


String findjoinproces = "  SELECT field_Name,field_AliasName from field_lookup where field_Name in (\r\n"
		+ "  SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'fhn_process_data');"; 
@Query(value = findjoinproces, nativeQuery = true)
public List<Object[]> getjoinedTableprocess();




String findjoininfraselected = "    select distinct :attribute from fhn_infrastructure_data;"; 
@Query(value = findjoininfraselected, nativeQuery = true)
public List<String> getjoinedTableinfraselected(String attribute);

String findjoinprocessselected = "    select distinct :attribute from fhn_process_data;"; 
@Query(value = findjoinprocessselected  , nativeQuery = true)
public List<String> getjoinedTableprocessselected(String attribute);

String findjoinappselected = "    select distinct :attribute from fhn_application_data;"; 
@Query(value = findjoinappselected , nativeQuery = true)
public List<String> getjoinedTableappselected(String attribute);


}

package com.slk.dsl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.slk.dsl.model.Version_Table;

@Repository

public interface VersionDAO extends JpaRepository<Version_Table, Integer> {

	
	String findQuery = "  SELECT  IF(t1.App_ID <>t2.App_ID,CONCAT('oldValue: ',t1.App_ID,'; newValue: ',t2.App_ID),'') as colcompare, IF(t1.Description <>t2.Description,CONCAT('oldValue: ',t1.Description,'; newValue: ',t2.Description),'') as col2compare,\r\n" + 
			"  t1.App_ID,t1.Description,t1.versionid,t1.author,t1.VersionNum,t1.createdDate,t1.AppSystem,t1.BusinessManager,t1.ETDirector,t1.ETManager FROM versioning_table t1 join versioning_table t2 ON t1.versionId=2 AND t2.versionId=3";
	
			@Query(value = findQuery, nativeQuery = true)
	public List<Object[]> getVersionComparsion(Integer id); 
}

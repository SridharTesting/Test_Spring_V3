package com.slk.dsl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.slk.dsl.model.FHNAppBaseTable;
@Repository
public interface fhnBaseDao extends JpaRepository<FHNAppBaseTable, Integer> {
	String findSelectedOption = "Select   count(app.RLane_Strategy_Id), lkp.RLane_Strategy as Count FROM ca_app_master app \r\n"
			+ "			right JOIN ca_rlane_strategy_lookup lkp on lkp.RLane_Strategy_Id=app.RLane_Strategy_Id where Org_Id=:orgId GROUP BY lkp.RLane_Strategy;";
	@Query(value = findSelectedOption, nativeQuery = true)
	public List<Object[]> getSelectedQuestion(int orgId);
	
	
	
	
	
		String rlane = "Select   count(app.RLane_Strategy_Id), lkp.RLane_Strategy as Count FROM ca_app_master app \r\n"
				+ "			right JOIN ca_rlane_strategy_lookup lkp on lkp.RLane_Strategy_Id=app.RLane_Strategy_Id \r\n"
				+ "            where Org_Id=:orgId and LOB_Id=:lobId GROUP BY lkp.RLane_Strategy;";
		@Query(value = rlane, nativeQuery = true)
		public List<Object[]> getrlane(int lobId,int orgId);
	
	

	String findDATACAT = "select count(*) as migration_data, \"Highly Restricted\" from ca_app_master where Data_Criticality =\"Highly Restricted\" and RLane_Strategy_Id =:id union\r\n"
			+ "select count(*) as migration_data, \"Confidential\" from ca_app_master where Data_Criticality =\"Confidential\" and RLane_Strategy_Id =:id  union\r\n"
			+ "select count(*) as migration_data, \"others\" from ca_app_master where Data_Criticality =\"Internal\" and RLane_Strategy_Id =:id  union\r\n"
			+ "select count(*) as migration_data, \"Public\" from ca_app_master where Data_Criticality =\"Public\" and RLane_Strategy_Id =:id";
			@Query(value = findDATACAT, nativeQuery = true)
	public List<Object[]> getSelecteddataCat(int id);

	
	
	String findAppCat ="select count(*) as num, Application_Criticality from ca_app_master where Application_Criticality=\"Business critical\"union \r\n"
			+ "select count(*) as num, Application_Criticality from ca_app_master where Application_Criticality=\"Mission critical\"union \r\n"
			+ "select count(*) as num, Application_Criticality from ca_app_master where Application_Criticality=\"Others\"";
	@Query(value = findAppCat, nativeQuery = true)
	public List<Object[]> getAppCat();
	

	String findAPPCATMigration = "select count(*) as migration_data1, \"Business critical\" from ca_app_master where Application_Criticality =\"Business critical\" and RLane_Strategy_Id =:id  union\r\n"
			+ "select count(*) as migration_data11, \"Mission critical\" from ca_app_master where Application_Criticality =\"Mission critical\" and RLane_Strategy_Id =:id  union\r\n"
			+ "select count(*) as migration_data1, \"others\" from ca_app_master where Application_Criticality =\"others\" and RLane_Strategy_Id =:id";
			@Query(value = findAPPCATMigration, nativeQuery = true)
	public List<Object[]> getAppMigration(int id);
	

	
}





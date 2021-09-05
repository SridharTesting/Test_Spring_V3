
package com.slk.dsl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slk.dsl.model.Application;
import com.slk.dsl.model.InfraDataModel;

@Repository
public interface CAAppMasterDAO extends JpaRepository<Application, Integer>{

	String lookupid = "select count(App_Master_Id) as num, \"Total\" from ca_app_master where Org_Id=:orgId union \r\n"
			+ "		 select count(App_Master_Id) as num, \"active\" from ca_app_master where  App_Suv_Status=1 and Org_Id=:orgId ";
	@Query(value = lookupid, nativeQuery = true)
	public List<Object[]> getlookupid(int orgId);

	String osnames = "select distinct OS_Type from ca_infra_data where os_type is not null and Org_Id=:orgId";
	@Query(value = osnames, nativeQuery = true)
	public List<Object[]> getosnames(int orgId);

	
	String oscount = "select count(*) as total from ca_infra_data where OS_Type=:name";
	@Query(value = oscount, nativeQuery = true)
	public List<Object> getoscount(String name);
	
	String findrlane ="select app.RLane_Strategy_Id,rl.RLane_Strategy from ca_app_master app inner join ca_rlane_strategy_lookup rl on"
			+ " rl.RLane_Strategy_Id = app.RLane_Strategy_Id where app.App_Master_Id =:id;\r\n";
	@Query(value = findrlane, nativeQuery = true)
	public List<Object[]> getrlane(int id);
	String dateandvendor = "select count(Vendor_Name),Rec_Upd_dt from ca_app_master where (Vendor_Name) is not null and Org_Id=:orgId";
	@Query(value = dateandvendor, nativeQuery = true)
	public List<Object[]> getdateandvendor(int orgId);
	
	String getApplicationcriticality ="select count(*),Application_Criticality  r\n"
			+"from ca_app_master \r\n"
			+ "where Application_Criticality in (select distinct(Application_Criticality )from ca_app_master) and Org_Id=:orgId \r\n"
			+ "group by  Application_Criticality";
	@Query(value = getApplicationcriticality, nativeQuery = true)
	public List<Object[]> Applicationcriticality(int orgId);
	
	String getData_Criticality = "select count(*),Data_Criticality \r\n"
			+ "from ca_app_master \r\n"
			+ "where Data_Criticality in (select distinct(Data_Criticality) from ca_app_master)and Org_Id=:orgId \r\n"
			+ "group by  Data_Criticality;";
	@Query(value = getData_Criticality, nativeQuery = true)
	public List<Object[]> Data_Criticality(int orgId);
	
	String lobcount = "select count(*), lb.Lob_Name\r\n"
			+ "			from ca_app_master app\r\n"
			+ "		inner join ca_lob_master lb on lb.LOB_Id=app.LOB_Id\r\n"
			+ "			where  app.LOB_Id in (select distinct(LOB_Id) from ca_lob_master ) and lb.Org_Id=:orgId\r\n"
			+ "			group by  app.LOB_Id;";
	@Query(value = lobcount, nativeQuery = true)
	public List<Object[]> getlobcount(int orgId);
	
	
	
	String ApplicationSurveycount = "select  ap.App_Name , Lob_Name,ap.LOB_Id, App_Suv_Status from ca_app_master ap\r\n"
			+ "			inner join ca_lob_master lb on lb.Lob_Id=ap.LOB_Id where ap.Org_Id=:orgId";
	@Query(value = ApplicationSurveycount, nativeQuery = true)
	public List<Object[]> getApplicationSurveycount(int orgId);
	
	String findDATACAT = "select count(*),Data_Criticality \r\n"
			+ "from ca_app_master app\r\n"
			+ "inner join ca_rlane_strategy_lookup rl on rl.RLane_Strategy_Id = app.RLane_Strategy_Id\r\n"
			+ "where Data_Criticality in (select distinct(Data_Criticality) from ca_app_master) \r\n"
			+ "and app.RLane_Strategy_Id=:id\r\n"
			+ "and app.Org_Id = :orgId\r\n"
			+ "group by  Data_Criticality;";
			@Query(value = findDATACAT, nativeQuery = true)
	public List<Object[]> getSelecteddataCat(int id, int orgId);
	
	
	
	
	String findAPPCATMigration = "select count(*),Application_Criticality\r\n"
			+ "			from ca_app_master app\r\n"
			+ "			inner join ca_rlane_strategy_lookup rl on rl.RLane_Strategy_Id = app.RLane_Strategy_Id\r\n"
			+ "			where Application_Criticality in (select distinct(Application_Criticality) from ca_app_master) \r\n"
			+ "			and app.RLane_Strategy_Id=:id\r\n"
			+ "            and app.Org_Id = :orgId\r\n"
			+ "			group by  Application_Criticality;";
			@Query(value = findAPPCATMigration, nativeQuery = true)
	public List<Object[]> getAppMigration(int id,int orgId);
	
	
	
	

	String ca_rlane_strategy_lookup = "select * from ca_rlane_strategy_lookup ";
			@Query(value = ca_rlane_strategy_lookup, nativeQuery = true)
	public List<Object[]> rlane_strategy_lookup();
	
	String createapp = "insert into ca_app_master (App_Id,App_Name,Org_Id,LOB_Id,App_Suv_Status,RLane_Strategy_Id,Migration_Status) Values (:appid,:appname,:orgid,:lobid,0,0,0) ";
	@Modifying
	@Transactional
	@Query(value = createapp, nativeQuery = true)
public void saveApp(String appid,String appname,int lobid , int orgid);
	
	String ca_app_master = "select * from ca_app_master where Org_Id=:orgId  ";
	@Query(value = ca_app_master, nativeQuery = true)
	public List<Application[]> getcaappmaster(int orgId);
	


	
	
	
	String userdashboard = "select count(*) as total,(select count(*) from ca_app_master  where App_Suv_Status = 1 and lob_id =:lobId ) as completed_survey,\r\n"
			+ "(select lob_manager from ca_lob_master where lob_id = :lobId) as lob_manager,\r\n"
			+ "(select count( distinct Vendor_Name) from ca_app_master where LOB_Id =:lobId) as vendor_count\r\n"
			+ "from ca_app_master cam \r\n"
			+ " where cam.lob_id =:lobId";
	@Query(value = userdashboard, nativeQuery = true)
	public List<Object[]> getuserdashboard(int lobId);
	
	
	
}
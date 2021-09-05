package com.slk.dsl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slk.dsl.model.CAAppMaster;
import com.slk.dsl.model.InfraDataModel;
import com.slk.dsl.model.fhn_infrastructure_dataTable;

@Repository
public interface CaInfraDataDao extends JpaRepository<InfraDataModel, Integer> {
	
	
	String deleteinfra = "delete from ca_infra_app_mapping where Infra_Id =:id ";
	@Modifying
	@Transactional
	@Query(value = deleteinfra, nativeQuery = true)
	public void deleteappincainframapping(int id);
	
	

	
	String physicalcount = "select count(*),\"Virtual\" as total from ca_infra_data where Physical_OR_Virtual=\"virtual\"  and Org_Id=:orgId  union\r\n"
			+ "			select count(*),\"Physical\" as total from ca_infra_data where Physical_OR_Virtual=\"physical\" and Org_Id=:orgId ";
	@Query(value = physicalcount, nativeQuery = true)
	public List<Object[]> getphysicalcount(int orgId);
	

	//1.data center view bar graph
	
	String IPcount = "select distinct Data_Center from ca_infra_data  ";
	@Query(value = IPcount, nativeQuery = true)
	public List<Object[]> getdatavsIp();
	

	String datavsip = "select count(IP_Address) from ca_infra_data where Data_Center =:name";
	@Query(value = datavsip, nativeQuery = true)
	public List<Object> getDatavsIp(String name);
	
	//
	
	//2.	Operating System version View by Data Center 
	String DCcount = "select distinct Data_Center from ca_infra_data where Data_Center is not null and Org_Id=:orgId  ";
	@Query(value = DCcount, nativeQuery = true)
	public List<Object[]> getDC(int orgId);
	
	
	String OSVSDC = "select count(*) from ca_infra_data where Data_Center=:name";
	@Query(value = OSVSDC, nativeQuery = true)
	public List<Object> getOSVSDC(String name);
	
// end
	
	//3.Application
	
	String ServsEnvbyAPP = "select count(*), id.Environment from ca_infra_app_mapping ia inner \r\n"
			+ "			join ca_app_master ap on ia.App_Master_Id= ap.App_Master_Id inner \r\n"
			+ "			join ca_infra_data id on id.Infra_Id= ia.Infra_Id where id.Environment is not null  and ap.Org_Id=:orgId group by id.Environment";
	@Query(value = ServsEnvbyAPP, nativeQuery = true)
	public List<Object[]> getServsEnvbyAPP(int orgId);
	
	//4.Database
	String ServsEnvbyDATA = "select count(*),Environment from ca_infra_data where Environment in (select distinct(Environment) \r\n"
			+ "from ca_infra_data) and Server_Type =\"Database\" and Org_Id=:orgId  group by Environment";
	@Query(value = ServsEnvbyDATA, nativeQuery = true)
	public List<Object[]> getServsEnvbyDATA(int orgId);
	
	//5.LOB chart
	
	String LOBChart = "select count(*),clm.Lob_Name from ca_app_master cam inner join ca_lob_master clm on clm.Lob_Id = cam.Lob_Id \r\n"
			+ "		 where cam.Org_Id=:orgId  group by clm.Lob_Id";
	@Query(value = LOBChart, nativeQuery = true)
	public List<Object[]> getLOBChart(int orgId);
	
	
	
	String oscount = "select count(*), OS_Type from ca_infra_data where OS_Type is not null  group by OS_Type";
	@Query(value = oscount, nativeQuery = true)
	public List<Object[]> getoscount();
	

	String Environment = "select count(*), Environment from ca_infra_data  where Environment is not null and   Org_Id=:orgId group by Environment ";
	@Query(value = Environment, nativeQuery = true)
	public List<Object[]> getEnvironment(int orgId);
	
	String applicationcount = "select count(*), Rec_Ins_dt from ca_infra_data where Org_Id=:orgId";
	@Query(value = applicationcount, nativeQuery = true)
	public List<Object[]> getapplicationcount(int orgId);
	
	
	String createapp = "insert into ca_infra_data (Host_Name,IP_Address,Org_Id,Rec_Ins_Dt) Values (:Host_Name,:IP_Address,:orgid,:Rec_Ins_Dt) ";
	@Modifying
	@Transactional
	@Query(value = createapp, nativeQuery = true)
public void saveinfra(String Host_Name,String IP_Address , int orgid,String Rec_Ins_Dt);	
	
	
	String createinframapping = "insert into ca_infra_app_mapping (App_Master_Id,Infra_Id,Org_Id,Rec_Ins_Dt,Rec_Upd_Dt) Values (:AppMasterId,:InfraId,:OrgId,:datetime,:datetime) ";
	@Modifying
	@Transactional
	@Query(value = createinframapping, nativeQuery = true)
public void saveinframapping( int AppMasterId,int InfraId,int OrgId,  String datetime );
 

String infra_data = "select * from ca_infra_data where Org_Id=:orgId  ";
@Query(value = infra_data, nativeQuery = true)
public List<InfraDataModel> getdatainfra(int orgId);
	
	
}

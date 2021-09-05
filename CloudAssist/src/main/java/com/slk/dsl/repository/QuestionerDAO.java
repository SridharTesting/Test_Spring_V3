package com.slk.dsl.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slk.dsl.model.QuestionerReturnedModel;
import com.slk.dsl.model.fhn_infrastructure_dataTable;

import java.util.List;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface QuestionerDAO extends JpaRepository<fhn_infrastructure_dataTable,Integer>{
	
//	
	String findInfraTableQuery = "SELECT appId, appSystem, 'SystemAdmin' as\r\n" + 
			"fieldName FROM fhn_infrastructure_data where (SystemAdmin = '' or SystemAdmin=null) and orgId =:id\r\n" + 
			"union\r\n" + 
			"SELECT appId, appSystem, 'SystemAdminEmployeeID' as fieldName FROM fhn_infrastructure_data where (SystemAdminEmployeeID = '' or SystemAdminEmployeeID = null) and orgId =:id\r\n" + 
			"union\r\n" + 
			"SELECT appId, appSystem, 'DRRelationshipManager' as fieldName  FROM fhn_infrastructure_data where (DRRelationshipManager = '' or DRRelationshipManager=null) and orgId =:id\r\n" + 
			"union\r\n" + 
			"SELECT appId, appSystem, 'DRRelationshipManagerEmployeeID' as fieldName FROM fhn_infrastructure_data where (DRRelationshipManagerEmployeeID = '' or DRRelationshipManagerEmployeeID=null) and orgId =:id\r\n" + 
			"union\r\n" + 
			"SELECT appId, appSystem, 'MainPlatform' as fieldName FROM fhn_infrastructure_data where (MainPlatform = '' or MainPlatform=null) and orgId =:id\r\n" + 
			"union\r\n" + 
			"SELECT appId, appSystem,  'NetworkExposure' as fieldName FROM fhn_infrastructure_data where (NetworkExposure = '' or NetworkExposure=null) and orgId =:id\r\n" + 
			"union\r\n" + 
			"SELECT appId, appSystem, 'RTO' as fieldName FROM fhn_infrastructure_data where (RTO = '' or RTO=null) and orgId =:id\r\n" + 
			"union\r\n" + 
			"SELECT appId, appSystem, 'OS' as fieldName FROM fhn_infrastructure_data where (OS = '' or OS=null ) and orgId =:id\r\n" + 
			"union\r\n" + 
			"SELECT appId, appSystem,  'Location' as fieldName FROM fhn_infrastructure_data where (Location = '' or Location=null)  and orgId =:id"
			+ " order by appId";
	@Query(value = findInfraTableQuery, nativeQuery = true)
	public List<Object[]> getInfraTable(@Param("id") int id);
	
	
	String findApplicationTableQuery = "SELECT appId, appSystem, 'description' as fieldName FROM fhn_application_data where (description = '' or description =null) and orgId =:id\r\n"
			+ "union\r\n"
			+ "SELECT appId, appSystem, 'HoursofOp' as fieldName FROM fhn_application_data where (HoursofOp = '' or HoursofOp = null) and orgId =:id\r\n"
			+ "union\r\n"
			+ "SELECT appId, appSystem, 'DataCatApp' as fieldName  FROM fhn_application_data where (DataCatApp = '' or DataCatApp =null) and orgId =:id\r\n"
			+ "union\r\n"
			+ "SELECT appId, appSystem, 'CustomerFacing' as fieldName FROM fhn_application_data where (CustomerFacing = '' or CustomerFacing=null) and orgId =:id\r\n"
			+ "union\r\n"
			+ "SELECT appId, appSystem, 'RTA' as fieldName FROM fhn_application_data where (RTA = '' or RTA =null) and orgId =:id\r\n"
			+ "union\r\n"
			+ "SELECT appId, appSystem, 'RPO' as fieldName FROM fhn_application_data where (RPO = '' or RPO=null) and orgId =:id\r\n"
			+ "union\r\n"
			+ "SELECT appId, appSystem, 'RPA' as fieldName FROM fhn_application_data where (RPA = '' or RPA =null ) and orgId =:id\r\n"
			+ "union\r\n"
			+ "SELECT appId, appSystem, 'VendorConfirmation' as fieldName FROM fhn_application_data where (VendorConfirmation = '' or VendorConfirmation =null ) and orgId =:id\r\n"
			+ "union\r\n"
			+ "SELECT appId, appSystem,  'vendor' as fieldName FROM fhn_application_data where (vendor = '' or vendor=null)  and orgId =:id\r\n"
			+ "order by appId";
	@Query(value = findApplicationTableQuery, nativeQuery = true)
	public List<Object[]> getApplicationTable(@Param("id") int id);
	
	
	String findProcessTableQuery = "SELECT appId, appSystem, 'BusinessOwner' as fieldName FROM fhn_process_data where (BusinessOwner = '' or BusinessOwner =null) and orgId =:id\r\n"
			+ "union\r\n"
			+ "SELECT appId, appSystem, 'BusinessOwnerEmployeeID' as fieldName FROM fhn_process_data where (BusinessOwnerEmployeeID = '' or BusinessOwnerEmployeeID =null) and orgId =:id\r\n"
			+ "union\r\n"
			+ "SELECT appId, appSystem, 'BusinessManager' as fieldName FROM fhn_process_data where (BusinessManager = '' or BusinessManager = null) and orgId =:id\r\n"
			+ "union\r\n"
			+ "SELECT appId, appSystem, 'BusinessManagerEmployeeID' as fieldName  FROM fhn_process_data where (BusinessManagerEmployeeID = '' or BusinessManagerEmployeeID =null) and orgId =:id\r\n"
			+ "union\r\n"
			+ "SELECT appId, appSystem, 'ETDirector' as fieldName FROM fhn_process_data where (ETDirector = '' or ETDirector=null) and orgId =:id\r\n"
			+ "union\r\n"
			+ "SELECT appId, appSystem, 'ETDirectorEmployeeID' as fieldName FROM fhn_process_data where (ETDirectorEmployeeID = '' or ETDirectorEmployeeID =null) and orgId =:id\r\n"
			+ "union\r\n"
			+ "SELECT appId, appSystem, 'ETManager' as fieldName FROM fhn_process_data where (ETManager = '' or ETManager=null) and orgId =:id\r\n"
			+ "union\r\n"
			+ "SELECT appId, appSystem, 'ETManagerEmployeeID' as fieldName FROM fhn_process_data where (ETManagerEmployeeID = '' or ETManagerEmployeeID =null ) and orgId =:id\r\n"
			+ "union\r\n"
			+ "SELECT appId, appSystem, 'ETPrimaryTechnical' as fieldName FROM fhn_process_data where (ETPrimaryTechnical = '' or ETPrimaryTechnical =null ) and orgId =:id\r\n"
			+ "union\r\n"
			+ "SELECT appId, appSystem, 'ETPrimaryTechnicalEmployeeID' as fieldName FROM fhn_process_data where (ETPrimaryTechnicalEmployeeID = '' or ETPrimaryTechnicalEmployeeID =null ) and orgId =:id\r\n"
			+ "union\r\n"
			+ "SELECT appId, appSystem, 'ETSecondaryTechnical' as fieldName FROM fhn_process_data where (ETSecondaryTechnical = '' or ETSecondaryTechnical =null ) and orgId =:id\r\n"
			+ "union\r\n"
			+ "SELECT appId, appSystem, 'ETSecondaryTechnicalEmployeeID' as fieldName FROM fhn_process_data where (ETSecondaryTechnicalEmployeeID = '' or ETSecondaryTechnicalEmployeeID =null ) and orgId =:id\r\n"
			+ "union\r\n"
			+ "SELECT appId, appSystem, 'LOB' as fieldName FROM fhn_process_data where (LOB = '' or LOB =null ) and orgId =:id\r\n"
			+ "union\r\n"
			+ "SELECT appId, appSystem, 'SCName' as fieldName FROM fhn_process_data where (SCName = '' or SCName =null ) and orgId =:id\r\n"
			+ "union\r\n"
			+ "SELECT appId, appSystem, 'QualityScore' as fieldName FROM fhn_process_data where (QualityScore = '' or QualityScore =null ) and orgId =:id\r\n"
			+ "union\r\n"
			+ "SELECT appId, appSystem, 'Domain' as fieldName FROM fhn_process_data where (Domain = '' or Domain =null ) and orgId =:id\r\n"
			+ "union\r\n"
			+ "SELECT appId, appSystem, 'ManagerCertification' as fieldName FROM fhn_process_data where (ManagerCertification = '' or ManagerCertification =null ) and orgId =:id\r\n"
			+ "union\r\n"
			+ "SELECT appId, appSystem, 'DRExerciseResults' as fieldName FROM fhn_process_data where (DRExerciseResults = '' or DRExerciseResults =null ) and orgId =:id\r\n"
			+ "union\r\n"
			+ "SELECT appId, appSystem, 'ApplicationDRPlan' as fieldName FROM fhn_process_data where (ApplicationDRPlan = '' or ApplicationDRPlan =null ) and orgId =:id\r\n"
			+ "union\r\n"
			+ "SELECT appId, appSystem, 'DRExerciseDate' as fieldName FROM fhn_process_data where (DRExerciseDate = '' or DRExerciseDate =null ) and orgId =:id\r\n"
			+ "union\r\n"
			+ "SELECT appId, appSystem, 'DRTier' as fieldName FROM fhn_process_data where (DRTier = '' or DRTier =null ) and orgId =:id\r\n"
			+ "union\r\n"
			+ "SELECT appId, appSystem,  'DRPlanDate' as fieldName FROM fhn_process_data where (DRPlanDate = '' or DRPlanDate=null)  and orgId =:id\r\n"
			+ "\r\n"
			+ "order by appId";
	@Query(value = findProcessTableQuery, nativeQuery = true)
	public List<Object[]> getProcessTable(@Param("id") int id);
	
	
//	@Query(value = findInfraTableQuery, nativeQuery = true)
//	public List<QuestionerReturnedModel> getApplicationTable(int id);
	
	String findQuestionerTableQuery = "select questioner from questioner_list";
	@Query(value = findQuestionerTableQuery, nativeQuery = true)
	public List<String> getQuestionList();
	
	String findjoin = "SELECT flkp.field_Name, flkp.field_AliasName,ql.questioner FROM field_lookup flkp INNER JOIN questioner_list ql on ql.field_Id=flkp.field_Id"; 
			@Query(value = findjoin, nativeQuery = true)
public List<Object[]> getjoinedTable();

//String attributes = "OS";
String que = "update fhn_infrastructure_data set "+":attributes"+ "= :fieldName where appId =:id";
//String que = "update fhn_infrastructure_data set :attributes = :fieldName where appId = :id";
//que.setParameter("id", id);

@Transactional
@Modifying(clearAutomatically = true,flushAutomatically=true)
@Query(value = que, nativeQuery = true)
public void putque(@Param("attributes") Object attributes,@Param("fieldName")String fieldName,@Param("id")int id);
}

package com.slk.dsl.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.slk.dsl.model.Application;
@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer>{
	
	String deleteRecordsFromApplicationTable="Delete from ca_app_master where Org_Id=:orgId";
	@Modifying
    @Transactional 
	@Query(value = deleteRecordsFromApplicationTable, nativeQuery = true)
	public void deleteApps(int orgId);

	/*
	 * @Query(value = "SELECT AppId FROM ca_app_master", nativeQuery = true) public
	 * List<Object[]> findByAppId();
	 * 
	 * 
	 * @Modifying
	 * 
	 * @Query("UPDATE ca_app_master u SET u.App_Id = :appId, u.App_Name = :appName,u.App_Desc=appDesc,u.Org_Id=orgId,u.LOB_Id=lobId,u.App_Manager=appManager,u.Vendor_Name=vendorName,u.Application_Criticality=applicationCriticality,u.Data_Criticality=dataCriticality  WHERE u.App_Master_Id = :appMasterId"
	 * ) void updateAppMaster( int appMasterId,String appId, String appName,String
	 * appDesc,String orgId,String lobId,String appManager,String vendorName,String
	 * applicationCriticality,String dataCriticality);
	 */
}

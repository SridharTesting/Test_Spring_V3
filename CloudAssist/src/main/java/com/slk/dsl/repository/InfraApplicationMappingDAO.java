package com.slk.dsl.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.slk.dsl.model.InfraAppMappingTable;
@Repository
public interface InfraApplicationMappingDAO  extends JpaRepository<InfraAppMappingTable, Integer>{
	String findQueryForAppMaster = "select App_Master_Id  from ca_app_master where App_Id=:appId";
    String findQueryForInfraId="Select infra_id from ca_infra_data where Host_Name=:hostName or IP_Address=:ipAddress";
    String deleteRecordsFromOrgId="Delete from ca_infra_app_mapping where Org_Id=:orgId";
	@Query(value = findQueryForAppMaster, nativeQuery = true)
	public List<Object[]> getAppMasterId(String appId);
	
	@Query(value = findQueryForInfraId, nativeQuery = true)
	public List<Object[]> getInfraId(String hostName,String ipAddress);
	
	@Modifying
    @Transactional 
	@Query(value = deleteRecordsFromOrgId, nativeQuery = true)
	public void deleteInfraMapping(int orgId);
	

}

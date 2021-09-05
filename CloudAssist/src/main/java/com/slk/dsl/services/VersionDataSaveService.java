package com.slk.dsl.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slk.dsl.model.ApplicationVersionData;
import com.slk.dsl.model.InfrastructureVersionData;
import com.slk.dsl.repository.InfraVersionRepo;
import com.slk.dsl.repository.VersionSaveDAO;

@Service
public class VersionDataSaveService {
	@Autowired
	VersionSaveDAO appRepo;
	
	@Autowired
	InfraVersionRepo infraRepo;

	/*
	 * @Autowired FHNProcessHistoryDAO repo;
	 */

	/*
	 * @Autowired Fhn_infra_data_historyDAO infrarepo;
	 */

	/*
	 * public void saveProcess(List<FHN_Process_history_data> fhn_Process_Table, int
	 * versionId) {
	 */
	/*
	 * 
	 * List<FHN_Process_history_data> processVersion=new
	 * ArrayList<FHN_Process_history_data>(); for (FHN_Process_history_data
	 * fhn_process_Table : fhn_Process_Table) {
	 * 
	 * 
	 * //fhn_process_Table.setOrgId(orgId);
	 * fhn_process_Table.setVersionId(versionId);
	 * fhn_process_Table.setProcessVersionId(fhn_process_Table.getProcessVersionId()
	 * ); fhn_process_Table.setOrgId(fhn_process_Table.getOrgId());
	 * fhn_process_Table.setBusinessOwner(fhn_process_Table.getBusinessOwner());
	 * fhn_process_Table.setBusinessOwnerEmployeeID(fhn_process_Table.
	 * getBusinessManagerEmployeeID());
	 * fhn_process_Table.setBusinessManager(fhn_process_Table.getBusinessManager());
	 * fhn_process_Table.setBusinessManagerEmployeeID(fhn_process_Table.
	 * getBusinessManagerEmployeeID());
	 * fhn_process_Table.seteTDirector(fhn_process_Table.geteTDirector());
	 * fhn_process_Table.seteTDirectorEmployeeID(fhn_process_Table.
	 * geteTDirectorEmployeeID());
	 * fhn_process_Table.seteTManager(fhn_process_Table.geteTManager());
	 * fhn_process_Table.seteTManagerEmployeeID(fhn_process_Table.
	 * geteTManagerEmployeeID());
	 * fhn_process_Table.seteTPrimaryTechnical(fhn_process_Table.
	 * geteTPrimaryTechnical());
	 * fhn_process_Table.seteTPrimaryTechnicalEmployeeID(fhn_process_Table.
	 * geteTPrimaryTechnicalEmployeeID());
	 * fhn_process_Table.seteTSecondaryTechnical(fhn_process_Table.
	 * geteTSecondaryTechnical());
	 * fhn_process_Table.seteTSecondaryTechnicalEmployeeID(fhn_process_Table.
	 * geteTSecondaryTechnicalEmployeeID());
	 * 
	 * fhn_process_Table.setLob(fhn_process_Table.getLob());
	 * 
	 * fhn_process_Table.setScName(fhn_process_Table.getScName());
	 * 
	 * fhn_process_Table.setQualityScore(fhn_process_Table.getQualityScore());
	 * 
	 * fhn_process_Table.setDomain(fhn_process_Table.getDomain());
	 * fhn_process_Table.setManagerCertification(fhn_process_Table.
	 * getManagerCertification());
	 * 
	 * fhn_process_Table.setdRExerciseResults
	 * (fhn_process_Table.getdRExerciseResults ());
	 * fhn_process_Table.setApplicationDRPlan(fhn_process_Table.getApplicationDRPlan
	 * ()); fhn_process_Table.setdRExerciseDate (fhn_process_Table.getdRExerciseDate
	 * ()); fhn_process_Table.setdRTier(fhn_process_Table.getdRTier());
	 * fhn_process_Table.setdRPlanDate(fhn_process_Table.getdRPlanDate());
	 * processVersion.add(fhn_process_Table);
	 * 
	 * }
	 * 
	 * repo.saveAll(processVersion);
	 * 
	 * }
	 */

public void saveApps(List<ApplicationVersionData> applications, int versionId) {
	List<ApplicationVersionData> appVersion=new ArrayList<ApplicationVersionData>();
	for (ApplicationVersionData Applications : applications) {
		Applications.setVersionId(versionId);
		Applications.setAppName(Applications.getAppName());
		Applications.setAppId(Applications.getAppId());
Applications.setAppDesc(Applications.getAppDesc());
Applications.setApplicationCriticality(Applications.getApplicationCriticality());
Applications.setAppManager(Applications.getAppManager());
Applications.setAppSuvStatus(Applications.getAppSuvStatus());
Applications.setComments(Applications.getComments());
Applications.setDataCatApp(Applications.getDataCatApp());

Applications.setLobId(Applications.getLobId());
Applications.setMigrationStatus(Applications.getMigrationStatus());
Applications.setOrgId(Applications.getOrgId());
Applications.setRecInsDt(Applications.getRecInsDt());
Applications.setRecUpdDt(Applications.getRecUpdDt());
Applications.setRlaneStrategyId(Applications.getRlaneStrategyId());
Applications.setVendorName(Applications.getVendorName());

		appVersion.add(Applications);

	}
	
	appRepo.saveAll(appVersion);
	
}


  public void saveInfra(List<InfrastructureVersionData> infraData,int versionId ) {
  
  List<InfrastructureVersionData> InfraVersion=new ArrayList<InfrastructureVersionData>(); 
 
	  for (InfrastructureVersionData infraDetails : infraData) {
			
		  infraDetails.setVersionId(versionId);
		  infraDetails.setInfraId(infraDetails.getInfraId());
			 infraDetails.setAvarageStorageIOPS(infraDetails.getAvarageStorageIOPS());
			 infraDetails.setAvgCpuUsage(infraDetails.getAvgCpuUsage());
			 infraDetails.setAvgMemoryUsage(infraDetails.getAvgMemoryUsage());
			 infraDetails.setAvgStorageReadIOPS(infraDetails.getAvgStorageReadIOPS());
			 infraDetails.setAvgStorageWriteIOPS(infraDetails.getAvgStorageWriteIOPS());
			 infraDetails.setBusinessUnit(infraDetails.getBusinessUnit());
			 infraDetails.setCpu(infraDetails.getCpu());
			 infraDetails.setCpuType(infraDetails.getCpuType());
			 infraDetails.setDataCenter(infraDetails.getDataCenter());
			 infraDetails.setDiskFreeSpace(infraDetails.getDiskFreeSpace());
			 infraDetails.setDiskSize(infraDetails.getDiskSize());
			 
			 
			 infraDetails.setEnvironment(infraDetails.getEnvironment());
			 infraDetails.setHostName(infraDetails.getHostName());
			 infraDetails.setHypervisor(infraDetails.getHypervisor());
			 infraDetails.setInScope(infraDetails.getInScope());
		
			 infraDetails.setIpAddress(infraDetails.getIpAddress());
			 infraDetails.setMaxNetworkUsageRate(infraDetails.getMaxNetworkUsageRate());
			 infraDetails.setMemory(infraDetails.getMemory());
			 infraDetails.setOrgId(infraDetails.getOrgId());
			 infraDetails.setOsBitness(infraDetails.getOsBitness());
			 infraDetails.setOsType(infraDetails.getOsType());
			 
			 infraDetails.setOsVersion(infraDetails.getOsVersion());
			 infraDetails.setPeakCpuUsage(infraDetails.getPeakCpuUsage());
			 infraDetails.setPeakMemoryUsage(infraDetails.getPeakMemoryUsage());
			 infraDetails.setPeakNetworkUsage(infraDetails.getPeakNetworkUsage());
			 infraDetails.setPeakStorageIOPS(infraDetails.getPeakStorageIOPS());
			 infraDetails.setPhysicalOrVirtual(infraDetails.getPhysicalOrVirtual());
		
			 infraDetails.setServerOwner(infraDetails.getServerOwner());
			 infraDetails.setServerType(infraDetails.getServerType());
			 infraDetails.setTotalCores(infraDetails.getTotalCores());
			 InfraVersion.add(infraDetails);
  
  }
  
	  infraRepo.saveAll(InfraVersion); 
	  }
  
  
  }
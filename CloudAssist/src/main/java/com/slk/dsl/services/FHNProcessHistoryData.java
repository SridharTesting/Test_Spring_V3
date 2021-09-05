package com.slk.dsl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slk.dsl.model.FHNAppVersionData;
import com.slk.dsl.model.FHN_Process_Data;
import com.slk.dsl.model.FHN_Process_history_data;
import com.slk.dsl.repository.FHNAppVersionRepo;
import com.slk.dsl.repository.FHNProcessHistoryDAO;
@Service
public class FHNProcessHistoryData {
	
	@Autowired
	FHNProcessHistoryDAO repo;
	@Autowired
	FHNAppVersionRepo appRepo;
	
	
public void saveProcess(List<FHN_Process_history_data> fhn_Process_Table, int versionId) {
		
		
		for (FHN_Process_history_data fhn_process_Table : fhn_Process_Table) {
			

			//fhn_process_Table.setOrgId(orgId);
			fhn_process_Table.setVersionId(versionId);
			fhn_process_Table.setProcessVersionId(fhn_process_Table.getProcessVersionId());
			fhn_process_Table.setOrgId(fhn_process_Table.getOrgId());
			fhn_process_Table.setBusinessOwner(fhn_process_Table.getBusinessOwner());
			fhn_process_Table.setBusinessOwnerEmployeeID(fhn_process_Table.getBusinessManagerEmployeeID());
			fhn_process_Table.setBusinessManager(fhn_process_Table.getBusinessManager());
			fhn_process_Table.setBusinessManagerEmployeeID(fhn_process_Table.getBusinessManagerEmployeeID());
			fhn_process_Table.seteTDirector(fhn_process_Table.geteTDirector());
			fhn_process_Table.seteTDirectorEmployeeID(fhn_process_Table.geteTDirectorEmployeeID());
			fhn_process_Table.seteTManager(fhn_process_Table.geteTManager());
			fhn_process_Table.seteTManagerEmployeeID(fhn_process_Table.geteTManagerEmployeeID());
			fhn_process_Table.seteTPrimaryTechnical(fhn_process_Table.geteTPrimaryTechnical());
			fhn_process_Table.seteTPrimaryTechnicalEmployeeID(fhn_process_Table.geteTPrimaryTechnicalEmployeeID());
			fhn_process_Table.seteTSecondaryTechnical(fhn_process_Table.geteTSecondaryTechnical());
			fhn_process_Table.seteTSecondaryTechnicalEmployeeID(fhn_process_Table.geteTSecondaryTechnicalEmployeeID());
			
			fhn_process_Table.setLob(fhn_process_Table.getLob());
		
			fhn_process_Table.setScName(fhn_process_Table.getScName());
			
			fhn_process_Table.setQualityScore(fhn_process_Table.getQualityScore());
			
			fhn_process_Table.setDomain(fhn_process_Table.getDomain());
			fhn_process_Table.setManagerCertification(fhn_process_Table.getManagerCertification());
			
			fhn_process_Table.setdRExerciseResults (fhn_process_Table.getdRExerciseResults ());
			fhn_process_Table.setApplicationDRPlan(fhn_process_Table.getApplicationDRPlan());
			fhn_process_Table.setdRExerciseDate (fhn_process_Table.getdRExerciseDate ());
			fhn_process_Table.setdRTier(fhn_process_Table.getdRTier());
			fhn_process_Table.setdRPlanDate(fhn_process_Table.getdRPlanDate());
	
			repo.save(fhn_process_Table);
		}
		
		
		
	}


public void saveApps(List<FHNAppVersionData> applications, int versionId) {
	// TODO Auto-generated method stub
	for (FHNAppVersionData Applications : applications) {
		

		//fhn_process_Table.setOrgId(orgId);
		Applications.setVersionId(versionId);
		Applications.setAppSystem(Applications.getAppSystem());
		Applications.setAppId(Applications.getAppId());
Applications.setCustomerFacing(Applications.getCustomerFacing());
Applications.setDataCatApp(Applications.getDataCatApp());
Applications.setDescription(Applications.getDescription());
Applications.setHoursofOp(Applications.getHoursofOp());
Applications.setRpa(Applications.getRpa());
Applications.setRpo(Applications.getRpo());
Applications.setRta(Applications.getRta());
Applications.setVendorConfirmation(Applications.getVendorConfirmation());
Applications.setOrgId(Applications.getOrgId());
		//repo.save(Applications);
appRepo.save(Applications);
	}
	
}
}

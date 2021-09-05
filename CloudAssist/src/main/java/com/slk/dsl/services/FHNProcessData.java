package com.slk.dsl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slk.dsl.model.FHNAppBaseTable;
import com.slk.dsl.model.FHN_Process_Data;
import com.slk.dsl.repository.FHNProcessRepo;
@Service
public class FHNProcessData {
	
	@Autowired
	FHNProcessRepo repo;
	
	public List<FHN_Process_Data> getfhnProcessData() {  
	    return repo.findAll();
	} 
	public void saveProcess(List<FHN_Process_Data> fhn_Process_Table) {
		if(fhn_Process_Table.size()>=0) {
		
		
		for (FHN_Process_Data fhn_process_Table : fhn_Process_Table) {
			

			//fhn_process_Table.setOrgId(orgId);
			fhn_process_Table.setOrgId(fhn_process_Table.getOrgId());
			fhn_process_Table.setAppId(fhn_process_Table.getAppId());
			fhn_process_Table.setAppSystem(fhn_process_Table.getAppSystem());
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
		
		
	}
}

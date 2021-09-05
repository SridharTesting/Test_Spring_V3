package com.slk.dsl.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slk.dsl.model.fhn_infrastructure_dataTable;
import com.slk.dsl.repository.FHNProcessRepo;
import com.slk.dsl.repository.FhnInraDataRepo;
import com.slk.dsl.repository.fhnBaseDao;


@Service
public class FhnInfraDataService {
	@Autowired
	FhnInraDataRepo versionrepo;
	
	@Autowired
	FHNProcessRepo versionrepoprocess;
	
	@Autowired
	fhnBaseDao versionrepoapp;
	
	public void saveVersion(List <fhn_infrastructure_dataTable> versionDetails) {
		if(versionDetails.size()>=0) {
		 for (fhn_infrastructure_dataTable versionDetails1 : versionDetails) {
			 versionDetails1.setAppId(versionDetails1.getAppId());
			 versionDetails1.setAppSystem(versionDetails1.getAppSystem());
			 versionDetails1.setOrgId(versionDetails1.getOrgId());
			 versionDetails1.setLastUpdate(versionDetails1.getLastUpdate());
			 versionDetails1.setSystemAdmin(versionDetails1.getSystemAdmin());
			 versionDetails1.setSystemAdminEmployeeID(versionDetails1.getSystemAdminEmployeeID());
			 versionDetails1.setDRelationshipManager(versionDetails1.getDRelationshipManager());
			 versionDetails1.setDRelationshipManagerEmployeeID(versionDetails1.getDRelationshipManagerEmployeeID());
			 versionDetails1.setMainPlatform(versionDetails1.getMainPlatform());
			 versionDetails1.setNetworkExposure(versionDetails1.getNetworkExposure());
			 versionDetails1.setRTO(versionDetails1.getRTO());
			 versionDetails1.setOS(versionDetails1.getOS());
			 versionDetails1.setLocation(versionDetails1.getLocation());
			 versionrepo.save(versionDetails1);
		 }
		 
		 
		}	
		
		
	}
	
//	
	
	
	
	
	
	public fhn_infrastructure_dataTable updateFhnInfraData(fhn_infrastructure_dataTable infraData) {
		 return versionrepo.save(infraData);
		}
	
	public void delete(int id)   
	
	{  
		versionrepoapp.deleteById(id);
	List<Integer> infra_id =new ArrayList<Integer>();
 List<Object[]> infra_validation=versionrepo.get_fhn();
infra_validation.stream().forEach(object->{
	List<Integer> Temp =new ArrayList<Integer>();
	Temp.add((Integer)object[0]);
	infra_id.addAll(Temp);
});
	if(infra_id.contains(id)) {
		versionrepo.deleteById(id);
	}
		
		
		
		List<Integer> Process_id = new ArrayList<Integer>();
		List<Object[]> process_validation=versionrepoprocess.get_process();
		List<Integer> Temp1 = new ArrayList<Integer>();
		process_validation.stream().forEach(object->{
			Temp1.add((Integer)object[0]);
			Process_id.addAll(Temp1);
		});
		if(Process_id.contains(id)) {
			versionrepoprocess.deleteById(id);
		}
	} 
	
}

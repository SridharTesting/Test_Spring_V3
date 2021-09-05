package com.slk.dsl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slk.dsl.model.Fhn_infra_data_history;

import com.slk.dsl.repository.Fhn_infra_data_historyDAO;

@Service
public class Fhn_infra_data_history_Service {

	@Autowired
	Fhn_infra_data_historyDAO versionrepo;
	
	
	public void saveFhnInfraDataHistory(List<Fhn_infra_data_history> versionDetails,int versionId )
	{
		for (Fhn_infra_data_history versionDetails1 : versionDetails) {
			 versionDetails1.setAppId(versionDetails1.getAppId());
			 versionDetails1.setAppSystem(versionDetails1.getAppSystem());
			 versionDetails1.setOrgId(versionDetails1.getOrgId());
			 versionDetails1.setLastUpdate(versionDetails1.getLastUpdate());
			 versionDetails1.setSystemAdmin(versionDetails1.getSystemAdmin());
			 versionDetails1.setSystemAdminEmployeeID(versionDetails1.getSystemAdminEmployeeID());
			 versionDetails1.setdRRelationshipManager(versionDetails1.getdRRelationshipManager());
			 versionDetails1.setdRRelationshipManagerEmployeeID(versionDetails1.getdRRelationshipManagerEmployeeID());
			 versionDetails1.setMainPlatform(versionDetails1.getMainPlatform());
			 versionDetails1.setNetworkExposure(versionDetails1.getNetworkExposure());
			 versionDetails1.setrTO(versionDetails1.getrTO());
			 versionDetails1.setoS(versionDetails1.getoS());
			 versionDetails1.setLocation(versionDetails1.getLocation());
			 versionDetails1.setVersionId(versionId);
			 versionrepo.save(versionDetails1);
		 }
	}
}

package com.slk.dsl.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class VersionNumberDAO {
	@Autowired
	public  EntityManager em ;
	
	
	public String getVersion(String input) {
		try {
		String returnedvalue =   em.createNamedStoredProcedureQuery("getversion").setParameter("org_name", input).getSingleResult().toString();
		
		if(returnedvalue==null || returnedvalue.isEmpty()) {
			returnedvalue="0";
		}
		return returnedvalue;
		}
		catch(NoResultException e) {
	        return null;
	    }
		
	}
		
	public int getVersions(String org_name,int viewId) {
		try {
		int returnedvalue = (int)em.createNamedStoredProcedureQuery("getversions").setParameter("org_name", org_name).setParameter("viewId", viewId).getSingleResult();
		return returnedvalue;
		}
		catch(NoResultException e) {
	        return 0;
	    }
		
	}
	
	
	public int getVersion1(int input) {
		int returnedvalue =   (int)em.createNamedStoredProcedureQuery("getHighestVersionNumber").setParameter("orgId", input).getSingleResult();
		if(returnedvalue==0) {
			returnedvalue=0;
		}
		return returnedvalue;
	}
}

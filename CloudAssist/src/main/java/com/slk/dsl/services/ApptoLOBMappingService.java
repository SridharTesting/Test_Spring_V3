package com.slk.dsl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slk.dsl.model.AppToLOBMapping;
import com.slk.dsl.repository.AppToLOBMappingDAO;
@Service
public class ApptoLOBMappingService {

	@Autowired
	AppToLOBMappingDAO appLOBrepo;
	
	
	public List<AppToLOBMapping> getApps() {  
        return appLOBrepo.findAll();  
    }
	
	
	public List<Object[]> getAppsTaggedToLOBBasedOnID(int id){
		return appLOBrepo.getAppsTaggedToLOBS(id);
	}
	
}

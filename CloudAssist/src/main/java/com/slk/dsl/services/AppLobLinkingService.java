package com.slk.dsl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slk.dsl.model.AppLOBLinkingTable;
import com.slk.dsl.model.Org;
import com.slk.dsl.repository.AppLobLinkingDAO;

@Service
public class AppLobLinkingService {
	@Autowired
	AppLobLinkingDAO appLobLinkRepo;
	
	
	public List<AppLOBLinkingTable> getLobsMappedToApps() {  
        return appLobLinkRepo.findAll();  
    } 
	
	
	
	public AppLOBLinkingTable saveLobsMappedToApps(AppLOBLinkingTable appDetails) {
		return appLobLinkRepo.save(appDetails);
	}
	
	 public void delete(int id) {
		 appLobLinkRepo.deleteById(id);
	 }
	
}

package com.slk.dsl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slk.dsl.dto.OrgAndLobJoinResponse;
import com.slk.dsl.model.Org;
import com.slk.dsl.repository.OrganizationDao;
@Service
public class OrganizationService {

	
	@Autowired
	OrganizationDao orgRepo;
	
	//all http methods will be declared here
	
	public Org saveOrganization(Org orgDetails) {
		return orgRepo.save(orgDetails);
	}

	  public List<Org> getorg() {  
	        return orgRepo.findAll();  
	    } 
	  
	  

	  public Optional<Org> findByID(int id) {  
	        return orgRepo.findById(id) ;
	    }
	  
	 public void delete(int id) {
		 orgRepo.deleteById(id);
	 }
	 
	 
		
		/*
		 * public List<OrgAndLobJoinResponse> getLobName(){
		 * 
		 * return orgRepo.getJoinInfo();
		 * 
		 * }
		 */
		 
}

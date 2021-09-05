package com.slk.dsl.services;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slk.dsl.dto.Lob_List_Dto;
import com.slk.dsl.dto.rlanedto;
import com.slk.dsl.model.Rlane;

import com.slk.dsl.repository.RlaneDao;
@Service

public class RlaneService {

	@Autowired
	RlaneDao Rlanerepo;
	
	public Rlane saveRlane(Rlane RlaneDetails) {
		return Rlanerepo.save(RlaneDetails);
	}

	  public List<Rlane> getRlane() {  
	        return Rlanerepo.findAll();  
	    } 
		 public List<rlanedto> rlaneapp(int id){
			 List<Object[]> result =	 Rlanerepo.getrlane(id);
			 List<rlanedto> rlane = new ArrayList<rlanedto>();
			
			 result.stream().forEach(objects->{
				 rlanedto rlanedata = new rlanedto();
				 rlanedata.setApp_Id(objects[0].toString());
				 

				 rlanedata.setApp_Name(objects[1].toString());
				 

				 rlanedata.setRLane_strategy(objects[0].toString());
				 

				 rlanedata.setRlane_strategy_Id(objects[1].toString());
				 
				 
				 
				 
				
					rlane.add(rlanedata);
				});
			 return rlane;
		 }
	  

	  public Optional<Rlane> getrlane(int RLane_Strategy_Id) {  
	        return Rlanerepo.findById(RLane_Strategy_Id) ;
	    }
	  
	 public void delete(int RLane_Strategy_Id) {
		 Rlanerepo.deleteById(RLane_Strategy_Id);
	 }
	 
	 
	
		/*
		 * public List<OrgAndLobJoinResponse> getLobName(){
		 * 
		 * return orgRepo.getJoinInfo();
		 * 
		 * }
		 */
		 
}
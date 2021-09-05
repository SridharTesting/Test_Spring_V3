package com.slk.dsl.services;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slk.dsl.dto.Lob_List_Dto;

import com.slk.dsl.model.LOB;
import com.slk.dsl.repository.LOBDao;
import com.slk.dsl.repository.LobMappingDAO;
@Service
public class LOBService {

	
	@Autowired
	LOBDao lobRepo;
	LobMappingDAO lobRepoMapping;
	public LOB saveLOB(LOB lobDetails) {
		return lobRepo.save(lobDetails);
	}
	
	 public List<LOB> getLob(int orgId) {  
	        return lobRepo.getlob(orgId);
	        
	    } 
	 
//	 public List<ROLE> getRole(int orgId) {  
//	        return roleRepo.getRole(orgId);
//	        
//	    } 
 
	 public Optional<LOB> getlobByID(int id) {
		 return lobRepo.findById(id);
	 }
	 public String delete(int id) {
	
		 lobRepo.deleteById(id);
		 
	    Optional<LOB> lob=lobRepo.findById(id);
	    boolean operationSuccessful =  lob == null;
        if(operationSuccessful){
            return "project deleted succefully";
        }else{
            return "Unable to delete LOB: The given lob is referenced by one or multiple user.";
        }

    

		
		
	 }
	 
		/*
		 * public OrgMapping findByOrgId(int OrgId) { return (OrgMapping)
		 * lobRepoMapping.findByOrgId(OrgId); }
		 */
	 public List<Lob_List_Dto> lobapp(int id){
		 List<Object[]> result =	 lobRepo.getApplob(id);
		 List<Lob_List_Dto> lob = new ArrayList<Lob_List_Dto>();
		
		 result.stream().forEach(objects->{
			 Lob_List_Dto lobdata = new Lob_List_Dto();

			 lobdata.setApp_Id(objects[0].toString());
//			 lobdata.setApp_Master_Id(objects[0].toString());

			 lobdata.setApp_Name(objects[1].toString());
			 lobdata.setRLane_Strategy_Id(objects[4].toString());
	 
	 if(objects[5]!=null)
	 {lobdata.setRLane_Strategy(objects[5].toString());
		 
	 }
	 else
	 {
		 lobdata.setRLane_Strategy("null");
	 }
			 lobdata.setApp_Suv_Status(objects[2].toString());
			 lobdata.setMigration_Status(objects[3].toString());
			 if(objects[6]!=null)
			 {lobdata.setComments(objects[6].toString());
				 
			 }
			 else
			 {
				 lobdata.setComments("");
			 }
			 
				lob.add(lobdata);
			});
		 return lob;
	 }
	 
}

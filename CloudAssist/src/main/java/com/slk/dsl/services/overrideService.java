package com.slk.dsl.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slk.dsl.dto.overridedto;


import com.slk.dsl.model.LOB;
import com.slk.dsl.model.UserSetup;
import com.slk.dsl.model.override;
import com.slk.dsl.repository.LOBDao;

import com.slk.dsl.repository.overrideDAO;
@Service
public class overrideService {
	@Autowired
	overrideDAO overriderepo;
	
//	 public Optional<override> getoverideByID(int id) {
//		 return overriderepo.findById(id);
//	 }
	 public List<overridedto> getoverride(int id){
		 List<Object[]> result =	 overriderepo.getoverride(id);
		 List<overridedto> override = new ArrayList<overridedto>();
		
		 result.stream().forEach(objects->{
			 overridedto overridedata = new overridedto();

//			 overridedata.setApp_Id(objects[0].toString());
			 overridedata.setRLane_Strategy_Id(objects[0].toString());
			 overridedata.setRLane_Strategy(objects[1].toString());
			
			 override.add(overridedata);
			});
		 return override;
}
//public void updaterlane(String appid,int stratergyid,String comments) {
//	int appsid=Integer.parseInt(appid);  
//	
//	overriderepo.updatecomments(appsid,comments);
//	overriderepo.updatestratergy(appsid, stratergyid);
//	
//}


	 
}
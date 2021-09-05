package com.slk.dsl.services;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slk.dsl.dto.ApplicationQuestionerSaveDTO;
import com.slk.dsl.dto.CSBQuestionerDTO;
import com.slk.dsl.dto.QuestionerSubLookupDTO;
import com.slk.dsl.dto.SubLookupDTO;
import com.slk.dsl.model.Application;
import com.slk.dsl.model.ApplicationLevelQuestioner;
import com.slk.dsl.repository.ApplicationQuestionerDAO;

@Service
public class ApplicationQuestionerService {



	@Autowired
	ApplicationQuestionerDAO repo;
	
	@PersistenceContext
	private EntityManager em;
	

	public void AppPostQuestioner(List<ApplicationLevelQuestioner> list,int orgId )throws IOException{
		List<ApplicationQuestionerSaveDTO> result = new ArrayList<ApplicationQuestionerSaveDTO>();
		List<SubLookupDTO> sublookupresult = new ArrayList<SubLookupDTO>();
		List<Object[]> queryResult = repo.getlookupid();
		List<Object[]> sublookuptable = repo.getsublookupTable();
		
		sublookuptable.stream().forEach(objects->{
			SubLookupDTO temp = new SubLookupDTO();
			temp.setSublookupid((Integer)objects[0]);
			temp.setLookupid((Integer)objects[1]);
			temp.setValues(objects[2].toString());
			sublookupresult.add(temp);
		});
		queryResult.stream().forEach(objects->{
			ApplicationQuestionerSaveDTO rr = new ApplicationQuestionerSaveDTO();
			rr.setQuestioner_Lkp_Id((Integer)objects[0]);
			rr.setQuestioner_values(objects[1].toString());
			rr.setQuestioner_Id((Integer)objects[2]);
			result.add(rr);
			});
		
		
		for (ApplicationLevelQuestioner aa : list) {
			aa.setResponse_Id(aa.getResponse_Id());
			aa.setQuestioner_Id(aa.getQuestioner_Id());
			if(aa.getComments()!=null) {
			aa.setComments(aa.getComments());
			}
			aa.setApp_Id(aa.getApp_Id());
			result.forEach(b -> {
				if(aa.getComments()!=null) {
				if(b.getQuestioner_values().equals(aa.getComments())&&b.getQuestioner_Id()==aa.getQuestioner_Id()) {
					aa.setQuestioner_Lkp_Id(BigInteger.valueOf(b.getQuestioner_Lkp_Id()));
				}
				if(aa.getQuestioner_Lkp_Id().intValue()==0) {
					sublookupresult.stream().forEach(sublookuprecord->{
						if(sublookuprecord.getValues().equals(aa.getComments())) {
							aa.setQuestioner_Lkp_Id(BigInteger.valueOf(sublookuprecord.getSublookupid()));
						}
					});
				}
				}
			});
			aa.setRec_Ins_Dt(aa.getRec_Ins_Dt());
			aa.setRec_Upd_Dt(aa.getRec_Upd_Dt());
			repo.save(aa);
				
			int appMasterId=repo.getAppMasterId(aa.getApp_Id(),orgId);
			System.out.println(appMasterId);
	
			repo.activateApplication(appMasterId,orgId);
					//String fetching = "python " + "activity-final.py";
			//String cmd ="python /c start python C:/Cloud_Decision_Engine/activity-final.py";
			/*
			 * System.out.println(fetching); String[] cmd = new String[]{"cmd.exe",
			 * "/c/Cloud_Decision_Engine/", fetching}; Runtime.getRuntime().exec(cmd);
			 */
			
			
			
			
			  //Process process = new ProcessBuilder("CMD", "/C", command2).start();
			
			
		};
		String fetching = "python3.7 " + "/usr/local/apache-tomcat-8.5.57/webapps/Cloud_Decision_Engine/activity-final.py";
		//String[] commandToExecute = new String[]{"cmd.exe", fetching};
		//System.out.println(commandToExecute.toString());
		Runtime.getRuntime().exec(fetching);
	}
	
	public void DeleteAppQuestioner(int app_Id) {
		repo.delete(app_Id);
	}
	
	
	public List<QuestionerSubLookupDTO> getsublookup(String name){
		List<Object[]> result = repo.bringsubquestionvalues(name);
		List<QuestionerSubLookupDTO> data = new ArrayList<QuestionerSubLookupDTO>();
		result.stream().forEach(obj->{
			QuestionerSubLookupDTO temp = new QuestionerSubLookupDTO();
			temp.setQuestioner_lookup_Id((Integer)obj[0]);
			temp.setQuestioner_sublookup_values(obj[1].toString());
			data.add(temp);
		});
		return data;
		
	}
	
	
	
}

package com.slk.dsl.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slk.dsl.dto.CSBQuestionerDTO;
import com.slk.dsl.dto.OrgQuestionerDTO;
import com.slk.dsl.dto.QuestionerPrimary;
import com.slk.dsl.model.ApplicationLevelQuestioner;
import com.slk.dsl.model.FHNAppBaseTable;
import com.slk.dsl.model.QuestionerResponse;
import com.slk.dsl.repository.CSBQuestionerDAO;

@Service
public class CSBQuestionerService {
	
	@Autowired
	CSBQuestionerDAO repo;

	public List<OrgQuestionerDTO> getquestionerData(int orgid) {
		List<OrgQuestionerDTO> result = new ArrayList<OrgQuestionerDTO>();
		
		List<Object[]> queryResult  = repo.getQuestionList();
		List<Object[] > selectedresponse = repo.getSelectedQuestion(orgid);
		
		
		
		queryResult.stream().forEach(objects->{
			OrgQuestionerDTO rr = new OrgQuestionerDTO();
			rr.setQuestioner_Id((Integer)objects[0]);
			rr.setQuestioner(objects[1].toString());
			rr.setQuestioner_category(objects[2].toString());
			rr.setResponse_Type(objects[3].toString());
			rr.setQuestioner_Lkp_Id((Integer)objects[4]);
			rr.setQuestioner_values(objects[5].toString());
			selectedresponse.stream().forEach(object -> {
				if(rr.getQuestioner_Id() == (Integer)object[0])
				rr.setSelected_val(object[1].toString());
			});
			rr.setQuestioner_Cat_Id((Integer)objects[6]);
			result.add(rr);
		});
		
		
		return result;
	}
	
	public List<CSBQuestionerDTO> getquestionerDataAppLevel(int orgid){
		List<CSBQuestionerDTO> result = new ArrayList<CSBQuestionerDTO>();
		
		List<Object[]> queryResult  = repo.getQuestionListappLevel();
		List<Object[] > selectedresponse = repo.getSelectedQuestionapp(orgid);
		
		queryResult.stream().forEach(objects->{
			CSBQuestionerDTO rr = new CSBQuestionerDTO();
			rr.setQuestioner_Id((Integer)objects[0]);
			rr.setQuestioner(objects[1].toString());
			rr.setQuestioner_category(objects[2].toString());
			rr.setResponse_Type(objects[3].toString());
			rr.setQuestioner_Lkp_Id((BigInteger)objects[4]);
			rr.setQuestioner_values(objects[5].toString());
			selectedresponse.stream().forEach(object -> {
				if(rr.getQuestioner_Id() == (Integer)object[0])
				rr.setSelected_val(object[1].toString());
			});
			result.add(rr);
		});
		return result;
	}
	
	public List<CSBQuestionerDTO> getquestionerDataAppLevelSelectedValue(int appid){
List<CSBQuestionerDTO> result = new ArrayList<CSBQuestionerDTO>();
		
		List<Object[]> queryResult  = repo.getQuestionListappLevel();
		List<Object[] > selectedresponse = repo.getSelectedQuestionapp(appid);
		
		queryResult.stream().forEach(objects->{
			CSBQuestionerDTO rr = new CSBQuestionerDTO();
			rr.setQuestioner_Id((Integer)objects[0]);
			rr.setQuestioner(objects[1].toString());
			rr.setQuestioner_category(objects[2].toString());
			rr.setResponse_Type(objects[3].toString());
	
			rr.setQuestioner_Lkp_Id((BigInteger)objects[4]);
			rr.setQuestioner_values(objects[5].toString());
			selectedresponse.stream().forEach(object -> {
				if(rr.getQuestioner_Id() == (Integer)object[0])
				rr.setSelected_val(object[1].toString());
			});
			result.add(rr);
		});
		return result;
		
	}
	
	public void PostQuestioner(List<QuestionerResponse> list ){
		List<OrgQuestionerDTO> result = new ArrayList<OrgQuestionerDTO>();
		List<Object[]> queryResult = repo.getlookupid();
		
		queryResult.stream().forEach(objects->{
			OrgQuestionerDTO rr = new OrgQuestionerDTO();
			rr.setQuestioner_Lkp_Id((Integer)objects[0]);
			rr.setQuestioner_values(objects[1].toString());
			rr.setQuestioner_Id((Integer)objects[2]);
			result.add(rr);
			});
		
		
		for (QuestionerResponse aa : list) {
			aa.setResponse_Id(aa.getResponse_Id());
			aa.setOrg_Id(aa.getOrg_Id());
			aa.setQuestioner_Id(aa.getQuestioner_Id());
			aa.setComments(aa.getComments());
//			aa.setQuestioner_Lkp_Id(aa.getQuestioner_Lkp_Id());
			result.forEach(b -> {
				if(b.getQuestioner_values().equals(aa.getComments())&&b.getQuestioner_Id()==aa.getQuestioner_Id()) {
					aa.setQuestioner_Lkp_Id(b.getQuestioner_Lkp_Id());
				}
			});
			aa.setRec_Ins_Dt(aa.getRec_Ins_Dt());
			
			aa.setResponse_Id(aa.getResponse_Id());
			repo.save(aa);
			aa.setRec_Upd_Dt(aa.getRec_Upd_Dt());
		};
		 
	}
	
	
	
	public void DeleteQuestioner(int orgid) {
		repo.delete(orgid);
	}
}

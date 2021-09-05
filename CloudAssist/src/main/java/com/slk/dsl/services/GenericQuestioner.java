package com.slk.dsl.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slk.dsl.dto.QuestionerAndFieldLookup;
import com.slk.dsl.dto.QuestionerPrimary;
import com.slk.dsl.model.FieldLookup;
import com.slk.dsl.model.QuestionerList;
import com.slk.dsl.model.QuestionerReturnedModel;
import com.slk.dsl.model.fhn_infrastructure_dataTable;
import com.slk.dsl.repository.FieldLookupDAO;
import com.slk.dsl.repository.QuestionerDAO;

@Service
public class GenericQuestioner {

//	@Autowired
//	FieldLookupDAO fieldLookuprepo;
	
	public List<QuestionerReturnedModel> getQuestiion(List<QuestionerPrimary> listid,
			List<QuestionerAndFieldLookup> ql){
		List<QuestionerReturnedModel> result = new ArrayList<QuestionerReturnedModel>();
		
		for(QuestionerPrimary list:listid) {
			
			for(QuestionerAndFieldLookup qlist:ql) {
				
				if(list.getFieldName().equals(qlist.getField_Name()))
				{
					QuestionerReturnedModel qm = new QuestionerReturnedModel();
					qm.setApp_Id(list.getAppId());
					qm.setApp_System(list.getAppSystem());
					qm.setField_Name(qlist.getField_AliasName());
					qm.setquestioner(qlist.getQuestioner());
					qm.setField_Value("");
					result.add(qm);
				}
			}
		}
		return result;
		
	}
}

package com.slk.dsl.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.slk.dsl.dto.QuestionerAndFieldLookup;
import com.slk.dsl.dto.QuestionerPrimary;
import com.slk.dsl.model.ApplicationQuestionUpload;
import com.slk.dsl.model.InfrastructureQuestionsUpload;
import com.slk.dsl.model.ProcessQuestionUpload;
import com.slk.dsl.model.QuestionerReturnedModel;
import com.slk.dsl.repository.QuestionerDAO;

@Service
@Transactional
public class QuestionerService {

	
	@Autowired
	QuestionerDAO repo;
	
	@Autowired
	GenericQuestioner queService;
	
	
	public List<QuestionerReturnedModel> FindAQuestioner(@PathVariable int id,@PathVariable int viewtype) {
		
		List<QuestionerPrimary> result = new ArrayList<QuestionerPrimary>();
		if(viewtype==2) {
			List<Object[]> queryResult = repo.getInfraTable(id);
			queryResult.stream().forEach(objects->{
				QuestionerPrimary rr = new QuestionerPrimary();
				rr.setAppId((Integer)objects[0]);
				rr.setAppSystem(objects[1].toString());
				rr.setFieldName(objects[2].toString());
				result.add(rr);
			});
		}
		
		
		else if(viewtype==1) {
			List<Object[]> queryResult = repo.getApplicationTable(id);
			queryResult.stream().forEach(objects->{
				QuestionerPrimary rr = new QuestionerPrimary();
				rr.setAppId((Integer)objects[0]);
				rr.setAppSystem(objects[1].toString());
				rr.setFieldName(objects[2].toString());
				result.add(rr);
			});
		}
		else    if(viewtype==3) {
			List<Object[]> queryResult = repo.getProcessTable(id);
			queryResult.stream().forEach(objects->{
				QuestionerPrimary rr = new QuestionerPrimary();
				rr.setAppId((Integer)objects[0]);
				rr.setAppSystem(objects[1].toString());
				rr.setFieldName(objects[2].toString());
				result.add(rr);
			});
		}
                 
		
		List<QuestionerAndFieldLookup> combinedResult = new ArrayList<QuestionerAndFieldLookup>();
		
		
		List<Object[]> aa  = repo.getjoinedTable();
		
		aa.stream().forEach(objects->{
			QuestionerAndFieldLookup res = new QuestionerAndFieldLookup();
			res.setField_Name(objects[0].toString());
			res.setField_AliasName(objects[1].toString());
			res.setQuestioner(objects[2].toString());
			combinedResult.add(res);
		});
		
		return queService.getQuestiion(result, combinedResult);
	
	}
	
	
public List<QuestionerReturnedModel> PutQuestioner(List<QuestionerReturnedModel> qm,int viewType){
		
		String attributes ="";
		List<QuestionerAndFieldLookup> combinedResult = new ArrayList<QuestionerAndFieldLookup>();
			List<Object[]> aa  = repo.getjoinedTable();
		
		aa.stream().forEach(objects->{
			QuestionerAndFieldLookup res = new QuestionerAndFieldLookup();
			res.setField_Name(objects[0].toString());
			res.setField_AliasName(objects[1].toString());
			combinedResult.add(res);
		});
		
		for(QuestionerReturnedModel list:qm) {
			for(QuestionerAndFieldLookup bb:combinedResult) {
			if(list.getField_Name().equals(bb.getField_AliasName()))
			{
				attributes = bb.getField_Name().toString();
				
				putque(attributes, list.getField_Value(),list.getApp_Id(),viewType);
				
			}
			
			
		}
			
		}
		return qm;
	}
	

@PersistenceContext
private EntityManager em;

public void putque(String attributes,String fieldValue,int aId,int viewType) {
	
	//use criteria api to dynamic build api's
		CriteriaBuilder cb = em.getCriteriaBuilder();
		if(viewType==1) {
			 CriteriaUpdate<ApplicationQuestionUpload>update=cb.createCriteriaUpdate(ApplicationQuestionUpload.class);
			 Root e=update.from(ApplicationQuestionUpload.class);
		 update.set(attributes,fieldValue); 
			 
		update.where(cb.equal(e.get("appId"), aId));
		
		 this.em.createQuery(update).executeUpdate();
			
		}
		else if(viewType==2) {
		 CriteriaUpdate<InfrastructureQuestionsUpload>update=cb.createCriteriaUpdate(InfrastructureQuestionsUpload.class);
		 Root e=update.from(InfrastructureQuestionsUpload.class);
	 update.set(attributes,fieldValue); 
		 
	update.where(cb.equal(e.get("appId"), aId));
	
	 this.em.createQuery(update).executeUpdate();
		  System.out.println(update);
		}
		
		
		else  {
			CriteriaUpdate<ProcessQuestionUpload>update=cb.createCriteriaUpdate(ProcessQuestionUpload.class);
			 Root e=update.from(ProcessQuestionUpload.class);
		 update.set(attributes,fieldValue); 
			 
		update.where(cb.equal(e.get("appId"), aId));
		
		 this.em.createQuery(update).executeUpdate();
			
		}
		  
}	  
}
	

 



//for(fhn_infrastructure_dataTable list:a) {
//	if(list.getSystemAdmin()==null||list.getSystemAdminEmployeeID()==null||list.getSystemAdmin()==""||list.getSystemAdminEmployeeID()=="" || list.getDRelationshipManager()==null||list.getDRelationshipManager()==""
//			|| list.getDRelationshipManagerEmployeeID()==null||list.getDRelationshipManagerEmployeeID()==""|| list.getMainPlatform()==null||list.getMainPlatform()=="" || list.getNetworkExposure()==null||list.getNetworkExposure()==""
//			|| list.getrTO()==null||list.getrTO()=="" || list.getoS()==null||list.getoS()=="" || list.getLocation()==null||list.getLocation()=="")
//	{
//		 listId.add(list);
//		
//	}
//}



//for(fhn_infrastructure_dataTable list:listId) {
//	if(list.getSystemAdmin()==null  || list.getSystemAdmin()=="")
//	{
//		QuestionerReturnedModel qm = new QuestionerReturnedModel();
//		qm.setAppId(list.getAppId());
//		qm.setAppsystem(list.getAppSystem());
//		qm.setAttributes(fieldaliasname.get("SystemAdmin"));
//		qm.setQuestions(ql.get(0));
//		qmList.add(qm);
//	}
//	
//	if(list.getSystemAdminEmployeeID()==null || list.getSystemAdminEmployeeID()=="")
//	{
//		QuestionerReturnedModel qm = new QuestionerReturnedModel();
//
//	qm.setAppId(list.getAppId());
//	qm.setAppsystem(list.getAppSystem());
//	qm.setAttributes(fieldaliasname.get("SystemAdminEmployeeID"));
//	qm.setQuestions(ql.get(1));
//	qmList.add(qm);
//	
//	}
//	
//	if(list.getDRelationshipManager()==null || list.getDRelationshipManager()=="")
//	{
//		QuestionerReturnedModel qm = new QuestionerReturnedModel();
//
//	qm.setAppId(list.getAppId());
//	qm.setAppsystem(list.getAppSystem());
//	qm.setAttributes(fieldaliasname.get("DRRelationshipManager"));
//	qm.setQuestions(ql.get(2));
//	qmList.add(qm);
//	
//	}
//	
////	
//	
//	if(list.getdRRelationshipManagerEmployeeID()==null  || list.getdRRelationshipManagerEmployeeID()=="")
//	{
//		QuestionerReturnedModel qm = new QuestionerReturnedModel();
//		qm.setAppId(list.getAppId());
//		qm.setAppsystem(list.getAppSystem());
//		qm.setAttributes(fieldaliasname.get("DRRelationshipManagerEmployeeID"));
//		qm.setQuestions(ql.get(3));
//		qmList.add(qm);
//	}
//	
//	if(list.getMainPlatform()==null  || list.getMainPlatform()=="")
//	{
//		QuestionerReturnedModel qm = new QuestionerReturnedModel();
//		qm.setAppId(list.getAppId());
//		qm.setAppsystem(list.getAppSystem());
//		qm.setAttributes(fieldaliasname.get("MainPlatform"));
//		qm.setQuestions(ql.get(4));
//		qmList.add(qm);
//	}
//	
//	if(list.getNetworkExposure()==null  || list.getNetworkExposure()=="")
//	{
//		QuestionerReturnedModel qm = new QuestionerReturnedModel();
//		qm.setAppId(list.getAppId());
//		qm.setAppsystem(list.getAppSystem());
//		qm.setAttributes(fieldaliasname.get("NetworkExposure"));
//		qm.setQuestions(ql.get(5));
//		qmList.add(qm);
//	}
//	
//	if(list.getrTO()==null  || list.getrTO()=="")
//	{
//		QuestionerReturnedModel qm = new QuestionerReturnedModel();
//		qm.setAppId(list.getAppId());
//		qm.setAppsystem(list.getAppSystem());
//		qm.setAttributes(fieldaliasname.get("RTO"));
//		qm.setQuestions(ql.get(6));
//		qmList.add(qm);
//	}
//	
//	if(list.getOS()==null  || list.getOS()=="")
//	{
//		QuestionerReturnedModel qm = new QuestionerReturnedModel();
//		qm.setAppId(list.getAppId());
//		qm.setAppsystem(list.getAppSystem());
//		qm.setAttributes(fieldaliasname.get("OS"));
//		qm.setQuestions(ql.get(7));
//		qmList.add(qm);
//	}
//	
//	if(list.getLocation()==null  || list.getLocation()=="")
//	{
//		QuestionerReturnedModel qm = new QuestionerReturnedModel();
//		qm.setAppId(list.getAppId());
//		qm.setAppsystem(list.getAppSystem());
//		qm.setAttributes(fieldaliasname.get("Location"));
//		qm.setQuestions(ql.get(8));
//		qmList.add(qm);
//	}
//}

package com.slk.dsl.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.slk.dsl.dto.QuestionerAndFieldLookup;
import com.slk.dsl.model.ApplicationQuestionUpload;
import com.slk.dsl.model.InfrastructureQuestionsUpload;
import com.slk.dsl.model.ProcessQuestionUpload;
import com.slk.dsl.model.QuestionerReturnedModel;
import com.slk.dsl.model.fhn_infrastructure_dataTable;
import com.slk.dsl.repository.Neo4jFilterDAO;
@Service
public class Neo4jFilterservice {
	@Autowired
	Neo4jFilterDAO repo;
	public List<QuestionerAndFieldLookup> Filter( int viewtype) {
		List<QuestionerAndFieldLookup> combinedResult = new ArrayList<QuestionerAndFieldLookup>();
		List<Object[]> aa  = new ArrayList<Object[]>();
		if(viewtype==2) {
 aa  = repo.getjoinedTableinfra();}
		
		else if(viewtype==1) {
			 aa  = repo.getjoinedTableapp();}
		else if(viewtype==3) {
			 aa  = repo.getjoinedTableprocess();}
		
		aa.stream().forEach(objects->{
			QuestionerAndFieldLookup res = new QuestionerAndFieldLookup();
			res.setField_Name(objects[0].toString());
			res.setField_AliasName(objects[1].toString());
		
			combinedResult.add(res);
		});
		
		return combinedResult;
		
	}
	
	public List<InfrastructureQuestionsUpload> Filterselectedinfra(  String attribute) {
	
			return somef(attribute);
		

		
		
	}
	
	
	public List<ApplicationQuestionUpload> Filterselectedapp(  String attribute) {
		
		return applicationFilter(attribute);
	

	
	
}
	
	public List<ProcessQuestionUpload> Filterselectedprocess(  String attribute) {
		
		return processFilter(attribute);
	

	
	
}


	@PersistenceContext
	private EntityManager em;
	
	public List<InfrastructureQuestionsUpload> somef(String attributes) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		//divide from here for application,infra and process
		
		CriteriaQuery<InfrastructureQuestionsUpload> q = cb.createQuery(InfrastructureQuestionsUpload.class);
		
		
		
		 Root<InfrastructureQuestionsUpload> c = q.from(InfrastructureQuestionsUpload.class);
		 q.select(c.get(attributes)).distinct(true);
		 q.where(cb.notEqual(c.get(attributes), ""));
		 
		 
		 //q.multiselect(c.get(attributes)).distinct(true);
		 List<InfrastructureQuestionsUpload> test = em.createQuery( q ).getResultList();
		 return test;
		
		
	}
	
	
	public List<ApplicationQuestionUpload> applicationFilter(String attributes) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ApplicationQuestionUpload> q = cb.createQuery(ApplicationQuestionUpload.class);
		
		
		
		 Root<ApplicationQuestionUpload> c = q.from(ApplicationQuestionUpload.class);
		 q.select(c.get(attributes)).distinct(true);
		 q.where(cb.notEqual(c.get(attributes), ""));
		 
		 List<ApplicationQuestionUpload> test = em.createQuery( q ).getResultList();
		 return test;
		
	}
	
	
	public List<ProcessQuestionUpload> processFilter(String attributes) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ProcessQuestionUpload> q = cb.createQuery(ProcessQuestionUpload.class);
		
		 Root<ProcessQuestionUpload> c = q.from(ProcessQuestionUpload.class);
		 q.select(c.get(attributes)).distinct(true);
		 q.where(cb.notEqual(c.get(attributes), ""));
		 
		 List<ProcessQuestionUpload> test = em.createQuery( q ).getResultList();
		 return test;
		
	}
}

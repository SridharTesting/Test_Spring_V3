package com.slk.dsl.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.slk.dsl.model.questionare;

@Repository
public class questionareDAO {
	@Autowired
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<questionare> GetQuestionerTemplate(int input, int viewtype){
		return em.createNamedStoredProcedureQuery("GetQuestionerTemplate").setParameter("orgidp",input).setParameter("viewtype",viewtype).getResultList();
	}

	
	
}

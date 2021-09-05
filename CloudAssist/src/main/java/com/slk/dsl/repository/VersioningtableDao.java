package com.slk.dsl.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.slk.dsl.model.Version_Table;

@Repository
public class VersioningtableDao {
	@Autowired
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Version_Table> getver(int input, int viewtype){
		return em.createNamedStoredProcedureQuery("firststoredprocedure").setParameter("orgidp",input).setParameter("viewtype",viewtype).getResultList();
	}
	
	
}

package com.slk.dsl.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.slk.dsl.model.Org;
@Repository
public interface OrganizationDao extends JpaRepository<Org, Integer>{

	
	
	 
}


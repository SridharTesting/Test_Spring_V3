package com.slk.dsl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.slk.dsl.model.BusinessProcess1;
import com.slk.dsl.model.LOB;

@Repository
public interface BusinessProcess1Dao  extends JpaRepository<BusinessProcess1, Integer>{
	

}

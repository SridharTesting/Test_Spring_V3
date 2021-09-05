package com.slk.dsl.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.slk.dsl.model.Rlane;
@Repository
public interface RlaneDao extends JpaRepository<Rlane, Integer>{


	String findrlane ="SELECT * FROM cloudassist.ca_rlane_strategy_lookup where RLane_Strategy_Id =:id";
	@Query(value = findrlane, nativeQuery = true)
	public List<Object[]> getrlane(int id);
	
	 
}


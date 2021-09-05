package com.slk.dsl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slk.dsl.model.override;

@Repository

public interface overrideDAO extends  JpaRepository<override, Integer>{

	String findoverride ="select app.RLane_Strategy_Id,rl.RLane_Strategy from ca_app_master"
			+ " app inner join ca_rlane_strategy_lookup rl on rl.RLane_Strategy_Id = app.RLane_Strategy_Id where app.App_Id =:id\r\n"
			+ "";
	@Query(value = findoverride, nativeQuery = true)
	public List<Object[]> getoverride(int id);
	
	
	String updaterlanecomments ="update ca_app_master set comments = :comments where App_Id = :appid";
	@Modifying
	@Transactional
	@Query(value = updaterlanecomments, nativeQuery = true)
	public void updatecomments(int appid,String comments);
	
	
	String updaterlanestratergy ="update ca_app_master set RLane_Strategy_Id = :stratergyid where App_Id = :appid";
	@Modifying
	@Transactional
	@Query(value = updaterlanestratergy, nativeQuery = true)
	public void updatestratergy(int appid,int stratergyid);
	

}

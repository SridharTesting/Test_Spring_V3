package com.slk.dsl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.slk.dsl.model.LOB;
@Repository
public interface LOBDao extends JpaRepository<LOB, Integer>{
	
	@Query("select l from LOB l where l.orgId = :orgId")
	 List<LOB> findLOBByObjectId(Integer orgId);
	
	
	String findAPPlob ="select App_Id,App_Name,\r\n"
			+ "CASE\r\n"
			+ "    WHEN App_Suv_Status= 1 THEN \"Completed\"\r\n"
			+ "    ELSE \"Not Started\"\r\n"
			+ "END as App_Suv_Status,\r\n"
			+ "\"Not Started\" as Migration_Status,\r\n"
			+ "app.RLane_Strategy_Id,\r\n"
			+ "rl.RLane_Strategy,comments from ca_app_master app\r\n"
			+ "left join ca_rlane_strategy_lookup rl on rl.RLane_Strategy_Id = app.RLane_Strategy_Id\r\n"
			+ " where LOB_Id=:id";
	@Query(value = findAPPlob, nativeQuery = true)
	public List<Object[]> getApplob(int id);
	
	
	

	String findlob ="SELECT * FROM ca_lob_master where Org_Id=:orgId";
	@Query(value = findlob, nativeQuery = true)
	public List<LOB> getlob(int orgId);
	
}



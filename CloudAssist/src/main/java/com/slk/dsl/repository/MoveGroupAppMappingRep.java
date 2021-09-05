package com.slk.dsl.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.slk.dsl.dto.MoveGroupApplicationsDTO;
import com.slk.dsl.dto.MoveGroupRehostApplicationsDTO;
import com.slk.dsl.model.MoveGroup;
import com.slk.dsl.model.MoveGroupAppMapping;

public interface MoveGroupAppMappingRep extends JpaRepository <MoveGroupAppMapping,Integer>{


	String appName="select a.App_Name, a.App_Master_Id from ca_movegroup_app_mapping m\r\n"
			+ "inner join ca_app_master a on a.App_Master_Id = m.App_Master_Id\r\n"
			+ "where m.Move_Group_Id= :MoveGroupId";

	@Query(value = appName, nativeQuery = true)
	public List<Object[]> getAppName(int MoveGroupId);
	
	
	String rehostName="select App_Master_Id,App_Name from ca_app_master where RLane_Strategy_Id = 1 and App_Master_Id not in (\r\n"
			+ "select m.App_Master_Id from ca_movegroup_app_mapping m\r\n"
			+ "inner join ca_move_group a on a.Move_Group_Id = m.Move_Group_Id\r\n"
			+ "where a.Org_Id=:orgId)";

	@Query(value = rehostName, nativeQuery = true)
	public List<Object[]> getRehost(int orgId);
	
	
	String deletapp = "delete from ca_movegroup_app_mapping where Move_Group_Id= :id";
	@Modifying
	@Transactional
	@Query(value = deletapp, nativeQuery = true)
	public void deleteapp(int id);
	}

package com.slk.dsl.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.slk.dsl.model.MoveGroup;

public interface MoveGroupRepo extends JpaRepository <MoveGroup,Integer>{
	
	

	String appName="SELECT * FROM CSB_CloudAssist.ca_move_group where Org_Id=:orgId";

	@Query(value = appName, nativeQuery = true)
	public List<MoveGroup[]> findByOrgId(int orgId);
	
	
	String updategroup = "update ca_move_group set Move_Group_Name = :moveGroupName where Move_Group_Id= :id ";
	@Transactional
	@Modifying
	@Query(value = updategroup, nativeQuery = true)
	public void updateGroup(String moveGroupName,int id);
	

}

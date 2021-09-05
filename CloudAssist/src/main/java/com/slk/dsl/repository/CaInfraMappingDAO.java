package com.slk.dsl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slk.dsl.model.Ca_infra_app_mapping;

@Repository
public interface CaInfraMappingDAO extends JpaRepository<Ca_infra_app_mapping, Integer> {

	
	
	
	String deleteinfra = "delete from ca_infra_app_mapping where App_Master_Id =:id ";
	@Modifying
	@Transactional
	@Query(value = deleteinfra, nativeQuery = true)
	public void deleteappincainframapping(int id);
	
	
	String deleteMoveGroup = "delete from ca_movegroup_app_mapping where App_Master_Id =:id";
	@Modifying
	@Transactional
	@Query(value = deleteMoveGroup, nativeQuery = true)
	public void deleteMoveGroup(int id);
	
	
	String getinfraid = "select Infra_Id from ca_infra_app_mapping where App_Master_Id =:id ";
	@Query(value = getinfraid, nativeQuery = true)
	public List<Object> getinfraIds(int id);
	
	String deletappmaster = "delete from ca_app_master where App_Master_Id =:id";
	@Modifying
	@Transactional
	@Query(value = deletappmaster, nativeQuery = true)
	public void deletecaappmaster(int id);
	
	
	String deletefrominfa = "delete from ca_infra_data where infra_id in :id ";
	@Modifying
	@Transactional
	@Query(value = deletefrominfa, nativeQuery = true)
	public void deleteinifra(List<Integer> id);
}


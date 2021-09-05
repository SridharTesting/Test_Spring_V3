package com.slk.dsl.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.slk.dsl.model.InfraDataModel;

public interface InfraDataUploadDAO extends JpaRepository<InfraDataModel, Integer> {
	String deleteRecordsFromInfraTable="Delete from ca_infra_data where Org_Id=:orgId";
	@Modifying
    @Transactional
	@Query(value = deleteRecordsFromInfraTable, nativeQuery = true)
	public void deleteInfraMapping(int orgId);
}

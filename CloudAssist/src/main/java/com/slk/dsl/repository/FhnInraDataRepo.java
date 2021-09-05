package com.slk.dsl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.slk.dsl.model.InfraDataModel;
import com.slk.dsl.model.fhn_infrastructure_dataTable;

@Repository
public interface FhnInraDataRepo extends JpaRepository<fhn_infrastructure_dataTable, Integer>{
String fhn_infra = "select appId from fhn_infrastructure_data  ";
@Query(value=fhn_infra,nativeQuery=true)
public List<Object[]> get_fhn();



}

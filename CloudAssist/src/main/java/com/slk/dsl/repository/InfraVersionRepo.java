package com.slk.dsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slk.dsl.model.ApplicationVersionData;
import com.slk.dsl.model.InfrastructureVersionData;

public interface InfraVersionRepo extends JpaRepository<InfrastructureVersionData, Integer>{

}

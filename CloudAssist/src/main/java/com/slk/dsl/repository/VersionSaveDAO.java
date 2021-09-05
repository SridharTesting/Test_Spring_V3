package com.slk.dsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slk.dsl.model.ApplicationVersionData;
@Repository
public interface VersionSaveDAO extends JpaRepository<ApplicationVersionData, Integer> {

}

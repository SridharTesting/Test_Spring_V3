package com.slk.dsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slk.dsl.model.FHNAppVersionData;


public interface FHNAppVersionRepo extends JpaRepository<FHNAppVersionData, Integer>{

}

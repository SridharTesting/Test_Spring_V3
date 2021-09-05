package com.slk.dsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.slk.dsl.model.FHN_Process_history_data;
@Repository
public interface FHNProcessHistoryDAO extends JpaRepository<FHN_Process_history_data, Integer>{

}

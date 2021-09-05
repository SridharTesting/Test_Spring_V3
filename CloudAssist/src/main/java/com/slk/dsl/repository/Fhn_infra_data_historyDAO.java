package com.slk.dsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slk.dsl.model.Fhn_infra_data_history;

@Repository
public interface Fhn_infra_data_historyDAO extends JpaRepository<Fhn_infra_data_history, Integer> {

}

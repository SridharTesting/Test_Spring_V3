package com.slk.dsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slk.dsl.model.AppLOBLinkingTable;

@Repository
public interface AppLobLinkingDAO extends JpaRepository<AppLOBLinkingTable, Integer>{

}

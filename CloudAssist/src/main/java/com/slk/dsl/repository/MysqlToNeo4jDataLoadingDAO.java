package com.slk.dsl.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.slk.dsl.model.MysqlToNeo4j;
@Repository
public interface MysqlToNeo4jDataLoadingDAO  extends Neo4jRepository<MysqlToNeo4j, Integer>{

	
	@Query("CALL apoc.load.jdbc('jdbc:mysql://localhost:3306/CloudAssist?user=root&password=slk@SOFT123','ca_lob_master' ) YIELD row Create(a:lob) set a=row return a")
	List<MysqlToNeo4j> loadDataFromMysql();
}

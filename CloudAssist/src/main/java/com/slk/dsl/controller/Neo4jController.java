package com.slk.dsl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slk.dsl.model.MysqlToNeo4j;
import com.slk.dsl.model.Org;
import com.slk.dsl.repository.MysqlToNeo4jDataLoadingDAO;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Neo4jController {
	@Autowired
	MysqlToNeo4jDataLoadingDAO repo;

	@GetMapping("createMapping")  
    public List<MysqlToNeo4j> allstudents() {  
         return repo.loadDataFromMysql();
          
    }
}

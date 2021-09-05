package com.slk.dsl.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.slk.dsl.model.Version_Table;
import com.slk.dsl.repository.VersioningtableDao;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class VersioningtableController {

	@Autowired
	VersioningtableDao version;

	@GetMapping("getver/{org_id}/{viewtype}")
	public List<Version_Table> getVersionForDropdown(@PathVariable int org_id,@PathVariable int viewtype) {
		return version.getver(org_id,viewtype);
	}
}

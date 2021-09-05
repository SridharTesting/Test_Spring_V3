package com.slk.dsl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slk.dsl.model.Org;
import com.slk.dsl.model.Version_Table;
import com.slk.dsl.repository.VersionDAO;

@Service
public class VersionService {

	@Autowired
	VersionDAO versionrepo;
	
	public Version_Table saveVersion(Version_Table versionDetails) {
		return versionrepo.save(versionDetails);
	}
	
	
}

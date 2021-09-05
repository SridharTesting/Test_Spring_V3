package com.slk.dsl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slk.dsl.model.CompareVersion;
import com.slk.dsl.repository.FHNApplicationDataDAO;
@Service
public class FHNApplicationService {
	//versionong service
	
	
	
	@Autowired
	FHNApplicationDataDAO fhnRepo;
	
	/*
	 * public CompareVersion saveCopyOfAppData(CompareVersion versionDetails) {
	 * return fhnRepo.save(versionDetails); }
	 */
}

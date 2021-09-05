package com.slk.dsl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.slk.dsl.model.fhn_infrastructure_dataTable;
import com.slk.dsl.services.FhnInfraDataService;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UploadFHNInfraData {

	@Autowired
	FhnInfraDataService service;

	@RequestMapping(value = "/upinfradata", method = RequestMethod.POST)
	public void UploadInfraData(@RequestBody List<fhn_infrastructure_dataTable> versionDetails) {

		service.saveVersion(versionDetails);
	}
}

package com.slk.dsl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.slk.dsl.model.CompareVersion;


import com.slk.dsl.services.FHNApplicationService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FHNVersionController {
@Autowired
FHNApplicationService service;

/*
 * @RequestMapping(value = "/copyAppData", method = RequestMethod.POST) public
 * CompareVersion createAppData(@RequestBody CompareVersion appDetails) {
 * 
 * 
 * 
 * return service.saveCopyOfAppData(appDetails); }
 */
}

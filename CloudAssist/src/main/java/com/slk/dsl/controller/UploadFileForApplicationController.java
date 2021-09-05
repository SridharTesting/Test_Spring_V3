package com.slk.dsl.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.slk.dsl.dto.FileResponseMessage;
import com.slk.dsl.repository.ApplicationRepository;
import com.slk.dsl.services.ApplicationDataSaveAfterUploadingService;
@RestController
@CrossOrigin
public class UploadFileForApplicationController {
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	@Autowired
	ApplicationRepository repo;
	
	@Autowired
	ApplicationDataSaveAfterUploadingService service;

	@PostMapping("/uploadAppData")
    public ResponseEntity<FileResponseMessage>  uploadMultipartFile(@RequestParam("UserFile") MultipartFile[] UserFile,@RequestParam("orgId")int orgId){
       logger.info("File uploaded started");
       String message = "";
       //String orgId="1";

	      List<String> files = new ArrayList<>();
	     
       
       try {

    	      Arrays.asList(UserFile).stream().forEach(file -> {
    	    	  try {
					service.saveAppDataFromUploadFile(file,orgId);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	    	  files.add(file.getOriginalFilename());
    	      });

    	      message = "Uploaded the files successfully: " + files;
    	      return ResponseEntity.status(HttpStatus.OK).body(new FileResponseMessage(message,files));
    	    } catch (Exception e) {
    	      message = "Fail to upload files!";
    	      
    	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new FileResponseMessage(message,files));
    	    }
	
    	  }

       
}    
       
       
       
       //insert LOB id and lob manager in lob manager in ca_lob_master tbl 
			/*
			 * boolean isFlag=false; String orgId="1";
			 * 
			 * isFlag =service.saveAppDataFromUploadFile(file,orgId);
			 * 
			 * 
			 * 
			 * 
			 * if(isFlag) { logger.info("File uploaded successfully");
			 * 
			 * 
			 * return new ResponseEntity<>("File uploaded successfully", HttpStatus.OK); }
			 * 
			 * else { logger.info("error in file upload"); return new
			 * ResponseEntity<>("Error in file upload", HttpStatus.BAD_REQUEST);
			 * 
			 * } }}
			 */

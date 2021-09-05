package com.slk.dsl.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;
import com.slk.dsl.model.SaveBlob;
import com.slk.dsl.model.UserSetup;
import com.slk.dsl.repository.FileUploadDAO;
import com.slk.dsl.repository.SaveBlobRepo;
import com.slk.dsl.repository.UserSetupDao;
import com.slk.dsl.services.FileStorageService;
import com.slk.dsl.services.SAveblobService;


@RestController
@CrossOrigin
public class FileUploadController {
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	@Autowired
	FileUploadDAO repo;
	
	@Autowired
	UserSetupDao userRepo;
	
	@Autowired
	FileStorageService service;
	
	@Autowired
	SAveblobService saveblobservice;
	
	
	@PostMapping("/uploadblob")
	public SaveBlob  uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("orgId")String orgId,@RequestParam("userDisplayName")String userDisplayName,@RequestParam("viewtype")int viewtype) {
		return saveblobservice.saveFile(file,Integer.parseInt(orgId),userDisplayName,viewtype);
	}
	
	@GetMapping("/downloadFile/{fileId}/{OrgId}")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable int fileId, @PathVariable int OrgId){
		SaveBlob file = saveblobservice.getFile(fileId,OrgId).get();
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(file.getDocType()))
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+file.getUploaded_by()+"\"")
				.body(new ByteArrayResource(file.getDataup()));
	}
	
	
	
	@PostMapping("/upload")
    public ResponseEntity<String>  uploadMultipartFile(@RequestParam("file") MultipartFile file, @RequestParam("orgId")String orgId) {
       logger.info("File uploaded started");
       boolean isFlag=false;
      
    	   isFlag =service.saveDataFromUploadFile(file,orgId);
       
     
   
  
  if(isFlag) {
	  logger.info("File uploaded successfully");
	  
	  
	  return new ResponseEntity<>("File uploaded successfully", HttpStatus.OK);
  }

  else {
	  logger.info("error in file upload");
	  return new ResponseEntity<>("Error in file upload", HttpStatus.BAD_REQUEST);
	  
  }
  
    
    
	}
	
	
	
	 @GetMapping("uploaded_files")  
	    public List<SaveBlob> allfiles() {  
	         return saveblobservice.uplodedfiles();
	          
	    }
	
	
}

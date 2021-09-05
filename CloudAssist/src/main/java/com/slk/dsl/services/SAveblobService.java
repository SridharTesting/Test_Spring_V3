package com.slk.dsl.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.print.Doc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.slk.dsl.model.Application;
import com.slk.dsl.model.SaveBlob;
import com.slk.dsl.model.UserSetup;
import com.slk.dsl.repository.SaveBlobRepo;

@Service
public class SAveblobService {

	@Autowired
	SaveBlobRepo blobrepo;
	
	public SaveBlob saveFile(MultipartFile file, int orgId , String userDisplayName, int viewtype) {
		String docname = file.getOriginalFilename();
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date date = new Date();  
		    formatter.format(date);
		SaveBlob sb = new SaveBlob(orgId,viewtype,file.getBytes(),userDisplayName,date,1,file.getContentType());
		return blobrepo.save(sb);
		} catch(Exception e) {
			  e.printStackTrace();
		  }
		return null;
	}
	
//	 public Optional<SaveBlob> getFile(Integer fileId) {
//		  return blobrepo.findById(fileId);
//	  }
	 
	  public Optional<SaveBlob> getFile(int fileId, int orgId) {
		  return blobrepo.getlatestfile(fileId,orgId);
	  }
	  
	  

	  public List<SaveBlob> uplodedfiles() {  
	        return blobrepo.findAll();  
	    } 
}

package com.slk.dsl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.slk.dsl.dto.DataCatDto;
import com.slk.dsl.dto.Lob_List_Dto;
import com.slk.dsl.model.LOB;
import com.slk.dsl.repository.LOBDao;
import com.slk.dsl.services.LOBService;

@RestController
@ControllerAdvice
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LOBController {
	
	@Autowired
	LOBService service;
	
	@Autowired
	LOBDao dao;
	
	 @RequestMapping(value = "/createLob", method = RequestMethod.POST)
		public LOB createOrganisation(@RequestBody LOB lobDetails) {

			

			return service.saveLOB(lobDetails);
		}
	 
	  @GetMapping("lob-list/{orgId}")  
	    public List<LOB> alllobs(@PathVariable int orgId) {  
	         return service.getLob(orgId);
	          
	    }
	  @PutMapping("lob")
		public LOB update(@RequestBody LOB lobDetails) {
		  return service.saveLOB(lobDetails);
		  
	  }
	  
	  
	  @GetMapping("getlobbyid/{id}")
		 public LOB getLobByID(@PathVariable int id) {
		  return service.getlobByID(id).get();
	  }
		  
	  
	  @DeleteMapping("lob/{id}")
	  public String delete(@PathVariable int id)  {
		  
		  service.delete(id);
		  return "Org deleted";
	  }
	  
	  
	  @GetMapping("getLobnamebasedonOrgId/{id}")
		public List<LOB> getLOBsOnOrgID(@PathVariable int id){
			return  dao.findLOBByObjectId(id);
		}
	  
		/*
		 * @GetMapping("/orgs/{id}") public OrgMapping getOrgById( @PathVariable(value =
		 * "id") int OrgId) { return service.findByOrgId(OrgId); }
		 */
	  
	  @GetMapping("lobtoQuestioner/{id}")  
		public List<Lob_List_Dto> lobapp(@PathVariable int id)  {  
			return service.lobapp(id);

		}
		
		 
}

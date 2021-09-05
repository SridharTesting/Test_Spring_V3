package com.slk.dsl.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slk.dsl.model.Ca_infra_app_mapping;
import com.slk.dsl.repository.CaInfraDataDao;
import com.slk.dsl.repository.CaInfraMappingDAO;
@Service
public class CaInfraMappingService {
	@Autowired
	CaInfraMappingDAO repo;
	public List<Ca_infra_app_mapping>  CAInframapping() {  
	       return repo.findAll();  
	   } 
	
	
	
	public void delete(int id)   {
		List<Object> result = repo.getinfraIds(id);
		List<Integer> list = new ArrayList<Integer>();
		result.forEach(item ->{
			list.add((Integer)item);
		});
//		result.stream().forEach(obj->{
//			int i=(Integer)obj[0];
//			list.add(i);
//		});
		repo.deleteMoveGroup(id);
		repo.deleteappincainframapping(id);
		repo.deletecaappmaster(id);

		repo.deleteinifra(list);
	}

}

package com.slk.dsl.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slk.dsl.model.FHNAppBaseTable;
import com.slk.dsl.repository.fhnBaseDao;
import com.slk.dsl.dto.DataCatDto;
import com.slk.dsl.dto.migrationdto;

@Service
public class FHNBaseTableService {
@Autowired
fhnBaseDao repo;
public List<FHNAppBaseTable> getfhnAppData() {  
    return repo.findAll();
} 

/*
 * public FHNAppBaseTable updateFhnAppData(FHNAppBaseTable appData) { return
 * repo.save(appData); }
 */




public void saveApplication(List<FHNAppBaseTable> fhn_Application_Table) {
	 List<FHNAppBaseTable> applications =new ArrayList<FHNAppBaseTable>();
	
	for (FHNAppBaseTable fhn_Application_Table1 : fhn_Application_Table) {
		fhn_Application_Table1.setAppId(fhn_Application_Table1.getAppId());
		fhn_Application_Table1.setAppSystem(fhn_Application_Table1.getAppSystem());
		fhn_Application_Table1.setDescription	 (fhn_Application_Table1.getDescription());
		fhn_Application_Table1.setVendor(fhn_Application_Table1.getVendor());
		fhn_Application_Table1.setHoursofOp(fhn_Application_Table1.getHoursofOp());
		fhn_Application_Table1.setDataCatApp(fhn_Application_Table1.getDataCatApp());
		fhn_Application_Table1.setCustomerFacing (fhn_Application_Table1.getCustomerFacing ());
		

		fhn_Application_Table1.setRta (fhn_Application_Table1.getRta ());
		fhn_Application_Table1.setRpo  (fhn_Application_Table1.getRpo  ());
		fhn_Application_Table1.setRpa (fhn_Application_Table1.getRpa ());
		
		fhn_Application_Table1.setVendorConfirmation (fhn_Application_Table1.getVendorConfirmation ());
//		if((Integer)fhn_Application_Table1.getMigration_Strategy_Id()!=null)
//		{fhn_Application_Table1.setMigration_Strategy_Id(fhn_Application_Table1.getMigration_Strategy_Id());}
		applications.add(fhn_Application_Table1);
	}
	
	   
			repo.saveAll(applications);
	
}
public List<migrationdto> migration(int orgId)
{
	List<Object[]> result = repo.getSelectedQuestion(orgId); 
	List<migrationdto> data = new ArrayList<migrationdto>();

	result.stream().forEach(objects->{
		migrationdto migration = new migrationdto();

	migration.setNum((BigInteger)objects[0]);

	migration.setMigration_Strategy(objects[1].toString());
		data.add(migration);
	});
	
	
	return data;
	
}

public List<migrationdto> rlane(int lobId,int orgId)
{
	List<Object[]> result = repo.getrlane(lobId,orgId); 
	List<migrationdto> data = new ArrayList<migrationdto>();

	result.stream().forEach(objects->{
		migrationdto migration = new migrationdto();

	migration.setNum((BigInteger)objects[0]);

	migration.setMigration_Strategy(objects[1].toString());
		data.add(migration);
	});
	
	
	return data;
	
}






}

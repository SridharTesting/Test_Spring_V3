
package com.slk.dsl.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.slk.dsl.model.CAAppMaster;
import com.slk.dsl.repository.CAAppMasterDAO;
import com.slk.dsl.dto.ApplicationSurveycountDTO;
import com.slk.dsl.dto.CSBQuestionerDTO;
import com.slk.dsl.dto.DataCatDto;
import com.slk.dsl.dto.Lob_List_Dto;
import com.slk.dsl.dto.OsNamesDTO;
import com.slk.dsl.dto.UserDashboardDTO;
import com.slk.dsl.dto.VendorandDateDTO;
//import com.slk.dsl.dto.CAAPPMasterdto;
import com.slk.dsl.dto.migrationdto;
import com.slk.dsl.model.Application;
import com.slk.dsl.model.InfraDataModel;
import com.slk.dsl.model.Rlane_Strategy_Lkp;
import com.slk.dsl.model.fhn_infrastructure_dataTable;
//import com.slk.dsl.model.CAAppMaster;
import com.slk.dsl.repository.CAAppMasterDAO;
import com.slk.dsl.model.LOB;

import com.slk.dsl.model.Rlane;
import com.slk.dsl.model.UserSetup;


@Service
public class CAAppMasterService {
@Autowired
CAAppMasterDAO repo;
//public List<CAAppMaster> getCaAppMaster() {  
//    return repo.findAll();
//} 



public List<Application[]> CAAppMaster(int orgId) {  
       return repo.getcaappmaster(orgId);
   } 



public List<migrationdto> gettotalapp(int orgId) {  
List<Object[]> queryResult = repo.getlookupid(orgId);
List<migrationdto> result = new ArrayList<migrationdto>();

queryResult.stream().forEach(objects->{
	migrationdto temp = new migrationdto();
	temp.setNum((BigInteger)objects[0]);
	temp.setMigration_Strategy(objects[1].toString());
	result.add(temp);
	});
return result;
}
public List<OsNamesDTO> getoschart(int orgId) {
	List<Object[]> data= repo.getosnames(orgId);
	List<OsNamesDTO> result= new ArrayList<OsNamesDTO>();
	List<String> osnames = new ArrayList<String>();
	data.stream().forEach(obj ->{
		osnames.add(obj[0].toString());
	});
	
			
	osnames.stream().forEach(object ->{
		OsNamesDTO temp = new OsNamesDTO();
		List<Object> t = repo.getoscount(object);
		t.stream().forEach(obj ->{
			temp.setCount(obj.toString());
		});
		temp.setName(object);
		result.add(temp);
	});
	return result;
}
public Application saverlane(Application rlaneDetails) {
	return repo.save(rlaneDetails);
}
public Optional<Application> getrlane(int id) {  
    return repo.findById(id);  
} 

public List<Application> getapp() {  
    return repo.findAll();  
} 
public void updatecaappmaster(List<Application> appDetails)
{
	List<Application> master= new ArrayList<Application>();
	
	for(Application Caappmaster: appDetails) {
		Caappmaster.setAppId(Caappmaster.getAppId());
		Caappmaster.setAppDesc(Caappmaster.getAppDesc());
		Caappmaster.setApplicationCriticality(Caappmaster.getApplicationCriticality());
		Caappmaster.setAppManager(Caappmaster.getAppManager());
		Caappmaster.setAppMasterId(Caappmaster.getAppMasterId());
		Caappmaster.setAppName(Caappmaster.getAppName());
		Caappmaster.setAppSuvStatus(Caappmaster.getAppSuvStatus());
		Caappmaster.setComments(Caappmaster.getComments());
		Caappmaster.setDataCatApp(Caappmaster.getDataCatApp());
		Caappmaster.setLobId(Caappmaster.getLobId());
		Caappmaster.setMigrationStatus(Caappmaster.getMigrationStatus());
		Caappmaster.setOrgId(Caappmaster.getOrgId());
		Caappmaster.setRecInsDt(Caappmaster.getRecInsDt());
		Caappmaster.setRecUpdDt(Caappmaster.getRecInsDt());
		Caappmaster.setRlaneStrategyId(Caappmaster.getRlaneStrategyId());
		Caappmaster.setVendorName(Caappmaster.getVendorName());
		
		master.add(Caappmaster);
	}
	
	repo.saveAll(master);
}

public List<List<DataCatDto>> DataCat(int orgId){
	List<Object[]> Rehostresult = repo.getSelecteddataCat(1,orgId); 
	List<Object[]> Retainstresult = repo.getSelecteddataCat(2,orgId); 
	List<Object[]>  Replatformresult = repo.getSelecteddataCat(3,orgId); 
	List<Object[]>Rearchitectresult = repo.getSelecteddataCat(4,orgId); 
	List<Object[]> ReBuildresult = repo.getSelecteddataCat(5,orgId); 
	List<Object[]> Replaceresult = repo.getSelecteddataCat(6,orgId); 
	List<DataCatDto> Rehostresultdata = new ArrayList<DataCatDto>();
	List<DataCatDto> Retainresultdata = new ArrayList<DataCatDto>();
	List<DataCatDto> Replatformresultdata = new ArrayList<DataCatDto>();
	List<DataCatDto> Rearchitectresultdata = new ArrayList<DataCatDto>();
	List<DataCatDto> ReBuildresultdata = new ArrayList<DataCatDto>();
	List< DataCatDto> Replaceresultdata = new ArrayList< DataCatDto>();
	List<List< DataCatDto>> finaldata = new  ArrayList<List< DataCatDto>>();
	Replaceresult.stream().forEach(objects->{
		 DataCatDto migration = new  DataCatDto();

	migration.setNum((BigInteger)objects[0]);

	migration.setMigration_Strategy(objects[1].toString());
	migration.setName("Replace");
	Replaceresultdata.add(migration);
	});
	
	Retainstresult.stream().forEach(objects->{
		 DataCatDto migration = new  DataCatDto();

	migration.setNum((BigInteger)objects[0]);

	migration.setMigration_Strategy(objects[1].toString());
	migration.setName("Retain");
	Retainresultdata.add(migration);
	});
	
	Replatformresult.stream().forEach(objects->{
		 DataCatDto migration = new  DataCatDto();

	migration.setNum((BigInteger)objects[0]);

	migration.setMigration_Strategy(objects[1].toString());
	migration.setName("Replatform");
	Replatformresultdata.add(migration);
	});
	
	Rehostresult.stream().forEach(objects->{
		 DataCatDto migration = new  DataCatDto();

	migration.setNum((BigInteger)objects[0]);

	migration.setMigration_Strategy(objects[1].toString());
	migration.setName("Rehost");
	Rehostresultdata.add(migration);
	});
	
	
	Rearchitectresult.stream().forEach(objects->{
		 DataCatDto migration = new  DataCatDto();

	migration.setNum((BigInteger)objects[0]);

	migration.setMigration_Strategy(objects[1].toString());
	migration.setName("Rearchitect");
	Rearchitectresultdata.add(migration);
	});
	
	ReBuildresult.stream().forEach(objects->{
		 DataCatDto migration = new  DataCatDto();

	migration.setNum((BigInteger)objects[0]);

	migration.setMigration_Strategy(objects[1].toString());
	migration.setName("Rebuild");
	ReBuildresultdata.add(migration);
	});
	
	
	
	finaldata.add(Replaceresultdata);
	finaldata.add(Retainresultdata);
	finaldata.add(Replatformresultdata);
	finaldata.add(Rehostresultdata);
	finaldata.add(Rearchitectresultdata);
	finaldata.add(ReBuildresultdata);
	
	return 	finaldata;
	
	
}






public List<List<DataCatDto>> APPCat1(int orgId){
	List<Object[]> Rehostresult = repo.getAppMigration(1,orgId); 
	List<Object[]> Retainstresult = repo.getAppMigration(2,orgId); 
	List<Object[]>  Replatformresult = repo.getAppMigration(3,orgId); 
	List<Object[]>Rearchitectresult = repo.getAppMigration(4,orgId); 
	List<Object[]> ReBuildresult = repo.getAppMigration(5,orgId); 
	List<Object[]> Replaceresult = repo.getAppMigration(6,orgId); 
	List<DataCatDto> Rehostresultdata = new ArrayList<DataCatDto>();
	List<DataCatDto> Retainresultdata = new ArrayList<DataCatDto>();
	List<DataCatDto> Replatformresultdata = new ArrayList<DataCatDto>();
	List<DataCatDto> Rearchitectresultdata = new ArrayList<DataCatDto>();
	List<DataCatDto> ReBuildresultdata = new ArrayList<DataCatDto>();
	List< DataCatDto> Replaceresultdata = new ArrayList< DataCatDto>();
	List<List< DataCatDto>> finaldata = new  ArrayList<List< DataCatDto>>();
	Replaceresult.stream().forEach(objects->{
		 DataCatDto migration = new  DataCatDto();

	migration.setNum((BigInteger)objects[0]);

	migration.setMigration_Strategy(objects[1].toString());
	migration.setName("Replace");
	Replaceresultdata.add(migration);
	});
	
	Retainstresult.stream().forEach(objects->{
		 DataCatDto migration = new  DataCatDto();

	migration.setNum((BigInteger)objects[0]);

	migration.setMigration_Strategy(objects[1].toString());
	migration.setName("Retain");
	Retainresultdata.add(migration);
	});
	
	Replatformresult.stream().forEach(objects->{
		 DataCatDto migration = new  DataCatDto();

	migration.setNum((BigInteger)objects[0]);

	migration.setMigration_Strategy(objects[1].toString());
	migration.setName("Replatform");
	Replatformresultdata.add(migration);
	});
	
	Rehostresult.stream().forEach(objects->{
		 DataCatDto migration = new  DataCatDto();

	migration.setNum((BigInteger)objects[0]);

	migration.setMigration_Strategy(objects[1].toString());
	migration.setName("Rehost");
	Rehostresultdata.add(migration);
	});
	
	
	Rearchitectresult.stream().forEach(objects->{
		 DataCatDto migration = new  DataCatDto();

	migration.setNum((BigInteger)objects[0]);

	migration.setMigration_Strategy(objects[1].toString());
	migration.setName("Rearchitect");
	Rearchitectresultdata.add(migration);
	});
	
	ReBuildresult.stream().forEach(objects->{
		 DataCatDto migration = new  DataCatDto();

	migration.setNum((BigInteger)objects[0]);

	migration.setMigration_Strategy(objects[1].toString());
	migration.setName("Rebuild");
	ReBuildresultdata.add(migration);
	});
	
	
	
	finaldata.add(Replaceresultdata);
	finaldata.add(Retainresultdata);
	finaldata.add(Replatformresultdata);
	finaldata.add(Rehostresultdata);
	finaldata.add(Rearchitectresultdata);
	finaldata.add(ReBuildresultdata);
	
	return 	finaldata;
}







public List<VendorandDateDTO> getdateandvendorcount(int orgId) {
	List<Object[]> data= repo.getdateandvendor(orgId);
	List<VendorandDateDTO> result= new ArrayList<VendorandDateDTO>();
	data.stream().forEach(obj->{
		VendorandDateDTO temp = new VendorandDateDTO();
		temp.setVendorcount(obj[0].toString());
		temp.setDateupdated(obj[1].toString());
		result.add(temp);
	});
	return result;
	
}



public List<VendorandDateDTO> getApplicationcriticality(int orgId) {
	List<Object[]> data= repo. Applicationcriticality(orgId);
	List<VendorandDateDTO> result= new ArrayList<VendorandDateDTO>();
	data.stream().forEach(obj->{
		VendorandDateDTO temp = new VendorandDateDTO();
		temp.setVendorcount(obj[0].toString());
		temp.setDateupdated(obj[1].toString());
		result.add(temp);
	});
	return result;
	
}

public List<VendorandDateDTO> getDatacriticality(int orgId) {
	List<Object[]> data= repo. Data_Criticality(orgId);
	List<VendorandDateDTO> result= new ArrayList<VendorandDateDTO>();
	data.stream().forEach(obj->{
		VendorandDateDTO temp = new VendorandDateDTO();
		temp.setVendorcount(obj[0].toString());
		temp.setDateupdated(obj[1].toString());
		result.add(temp);
	});
	return result;
	
}

public List<VendorandDateDTO> getLobount(int orgId) {
	List<Object[]> data= repo.getlobcount(orgId);
	List<VendorandDateDTO> result= new ArrayList<VendorandDateDTO>();
	data.stream().forEach(obj->{
		VendorandDateDTO temp = new VendorandDateDTO();
		temp.setVendorcount(obj[0].toString());
		temp.setDateupdated(obj[1].toString());
		result.add(temp);
	});
	return result;
	
}



public List<ApplicationSurveycountDTO> getApplicationSurveycount(int orgId) {
	List<Object[]> data= repo.getApplicationSurveycount(orgId);
	List<ApplicationSurveycountDTO> result= new ArrayList<ApplicationSurveycountDTO>();
	data.stream().forEach(obj->{
		ApplicationSurveycountDTO temp = new ApplicationSurveycountDTO();
	temp.setApp_Name(obj[0].toString());
	temp.setLob_Name(obj[1].toString());
temp.setLOB_Id(obj[2].toString());
temp.setApp_Suv_Status(obj[3].toString());

		result.add(temp);
	});
	return result;
	
}


public List<Rlane_Strategy_Lkp> rlanestrategy() {
	List<Object[]> data= repo.rlane_strategy_lookup();
	List<Rlane_Strategy_Lkp> result= new ArrayList<Rlane_Strategy_Lkp>();
	data.stream().forEach(obj->{
		Rlane_Strategy_Lkp temp = new Rlane_Strategy_Lkp();
		temp.setRLane_Strategy_Id((Integer)obj[0]);
		temp.setRLane_Strategy(obj[1].toString());
		
		
		temp.setIs_Active((Integer)obj[2]);
		result.add(temp);
	});
	return result;
	
	
	
	
}





public Application saveApplication(Application app)   {
	Application apprecord = new Application();
	apprecord.setAppId(app.getAppId());
	apprecord.setAppName(app.getAppName());
	apprecord.setLobId(app.getLobId());
	apprecord.setOrgId(app.getOrgId());
	repo.saveApp(app.getAppId(),app.getAppName(),app.getLobId(),app.getOrgId());
	return apprecord;
}


public List<UserDashboardDTO> getuserdashboard(int lobId) {
	List<Object[]> data= repo.getuserdashboard(lobId);
	List<UserDashboardDTO> result= new ArrayList<UserDashboardDTO>();
	data.stream().forEach(obj->{
		UserDashboardDTO temp = new UserDashboardDTO();
		
		temp.setTotal((BigInteger)obj[0]);
		temp.setCompleted_survey((BigInteger)obj[1]);
		
		
		temp.setLob_manager(obj[2].toString());
		temp.setVendor_count((BigInteger)obj[3]);
		
		result.add(temp);
	});
	return result;
	
}

}

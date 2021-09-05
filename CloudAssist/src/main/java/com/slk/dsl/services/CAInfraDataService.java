package com.slk.dsl.services;
import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.slk.dsl.model.CAAppMaster;
import com.slk.dsl.repository.CAAppMasterDAO;
import com.slk.dsl.repository.CaInfraDataDao;
import com.slk.dsl.dto.AddInfraDTO;
import com.slk.dsl.dto.CSBQuestionerDTO;
import com.slk.dsl.dto.OsNamesDTO;
//import com.slk.dsl.dto.CAAPPMasterdto;
import com.slk.dsl.dto.migrationdto;
import com.slk.dsl.model.Application;
import com.slk.dsl.model.Ca_infra_app_mapping;
import com.slk.dsl.model.InfraDataModel;

@Service

public class CAInfraDataService {
	@Autowired
	CaInfraDataDao repo;
	
	
	
	public void updateinfra(List<InfraDataModel> appDetails)
	{
		List<InfraDataModel> master= new ArrayList<InfraDataModel>();
		
		for(InfraDataModel infradata: appDetails) {
			infradata.setInfraId(infradata.getInfraId());
			
			infradata.setHostName(infradata.getHostName());
			infradata.setIpAddress(infradata.getIpAddress());
			infradata.setHypervisor(infradata.getHypervisor());
			infradata.setOsType(infradata.getOsType());
			infradata.setOsVersion(infradata.getOsVersion());
			infradata.setOsBitness(infradata.getOsBitness());
			infradata.setPhysicalOrVirtual(infradata.getPhysicalOrVirtual());
			infradata.setServerType(infradata.getServerType());
			infradata.setEnvironment(infradata.getEnvironment());
			infradata.setDataCenter(infradata.getDataCenter());
			infradata.setBusinessUnit(infradata.getBusinessUnit());
			infradata.setServerOwner(infradata.getServerOwner());
			infradata.setInScope(infradata.getInScope());
			infradata.setCpu(infradata.getCpuType());		
			infradata.setTotalCores(infradata.getTotalCores());
			infradata.setMemory(infradata.getMemory());
			infradata.setDiskSize(infradata.getDiskSize());
			infradata.setDiskFreeSpace(infradata.getDiskFreeSpace());
			infradata.setAvarageStorageIOPS(infradata.getAvarageStorageIOPS());
			infradata.setPeakStorageIOPS(infradata.getPeakStorageIOPS());
			infradata.setAvgStorageReadIOPS(infradata.getAvgStorageReadIOPS());
			infradata.setAvgStorageWriteIOPS(infradata.getAvgStorageWriteIOPS());
			infradata.setPeakNetworkUsage(infradata.getPeakNetworkUsage());
			infradata.setMaxNetworkUsageRate(infradata.getMaxNetworkUsageRate());
			infradata.setRecInsDt(infradata.getRecInsDt());
			
			
			master.add(infradata);
		}
		
		repo.saveAll(master);
	}
	public void delete(int id)   {
		repo.deleteappincainframapping(id);
		repo.deleteById(id);
	}
	

public AddInfraDTO saveinfra(AddInfraDTO app)   {
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	   LocalDateTime now = LocalDateTime.now();  
	   String datetime = dtf.format(now);
	AddInfraDTO apprecord = new AddInfraDTO();
	apprecord.setAppMasterId(apprecord.getAppMasterId());
	apprecord.setHostName(apprecord.getHostName());
	apprecord.setIpAddress(apprecord.getIpAddress());
	apprecord.setOrgId(apprecord.getOrgId());
	apprecord.setInfraId(apprecord.getInfraId());
	
	repo.saveinfra(app.getHostName(),app.getIpAddress(),app.getOrgId(),datetime);
	repo.saveinframapping(app.getAppMasterId(),app.getInfraId(),app.getOrgId(),datetime);
	return apprecord;
}
	
	
	
	
	
	
	
	public List<InfraDataModel>  CAInfra() {  
	       return repo.findAll();  
	   } 
	
	


	public List<migrationdto> getphysical(int orgId) {
		List<Object[]> data= repo. getphysicalcount(orgId);
		List<migrationdto> result= new ArrayList<migrationdto>();
		
		
				
		data.stream().forEach(object ->{
			migrationdto temp = new migrationdto();
		temp.setNum((BigInteger)object[0]);
		temp.setMigration_Strategy(object[1].toString());
			result.add(temp);
		});
		return result;
	}
	
	
	
	
	
	
	public List<OsNamesDTO> DatavsIp() {
		List<Object[]> data= repo.  getdatavsIp();
		List<OsNamesDTO> result= new ArrayList<OsNamesDTO>();
		List<String> osnames = new ArrayList<String>();
		data.stream().forEach(obj ->{
			osnames.add(obj[0].toString());
		});
		
				
		osnames.stream().forEach(object ->{
			OsNamesDTO temp = new OsNamesDTO();
			List<Object> t = repo.getDatavsIp(object);
			t.stream().forEach(obj ->{
				temp.setCount(obj.toString());
			});
			temp.setName(object);
			result.add(temp);
		});
		return result;
	}
	
	
	

	public List<OsNamesDTO> OSVsData(int orgId) {
		List<Object[]> data= repo.getDC(orgId);
		List<OsNamesDTO> result= new ArrayList<OsNamesDTO>();
		List<String> osnames = new ArrayList<String>();
		data.stream().forEach(obj ->{
			osnames.add(obj[0].toString());
			
		});
		
				
		osnames.stream().forEach(object ->{
			OsNamesDTO temp = new OsNamesDTO();
			List<Object> t = repo.getOSVSDC(object);
			t.stream().forEach(obj ->{
				temp.setCount(obj.toString());
			});
			temp.setName(object);
			result.add(temp);
		});
		return result;
	}
	
	

	

	public List<migrationdto> getenvironmentvsServer(int orgId) {
		List<Object[]> data= repo.getServsEnvbyAPP(orgId);
		List<migrationdto> result= new ArrayList<migrationdto>();
		
		
				
		data.stream().forEach(object ->{
			migrationdto temp = new migrationdto();
		temp.setNum((BigInteger)object[0]);
		temp.setMigration_Strategy(object[1].toString());
			result.add(temp);
		});
		return result;
	}
	
	

	public List<migrationdto> getenvironmentvsServerbyDATA(int orgId) {
		List<Object[]> data= repo.getServsEnvbyDATA(orgId);
		List<migrationdto> result= new ArrayList<migrationdto>();
		
		
				
		data.stream().forEach(object ->{
			migrationdto temp = new migrationdto();
		temp.setNum((BigInteger)object[0]);
		temp.setMigration_Strategy(object[1].toString());
			result.add(temp);
		});
		return result;
	}
	
	
	//Total Number of applications by Line Of Business 

	public List<migrationdto> LOBchart(int orgId) {
		List<Object[]> data= repo.getLOBChart(orgId);
		List<migrationdto> result= new ArrayList<migrationdto>();
		
		
				
		data.stream().forEach(object ->{
			migrationdto temp = new migrationdto();
		temp.setNum((BigInteger)object[0]);
		temp.setMigration_Strategy(object[1].toString());
			result.add(temp);
		});
		return result;
	}
	
	

	public List<migrationdto> getoscount() {
		List<Object[]> data= repo.getoscount();
		List<migrationdto> result= new ArrayList<migrationdto>();
		
		
				
		data.stream().forEach(object ->{
			migrationdto temp = new migrationdto();
		temp.setNum((BigInteger)object[0]);
		temp.setMigration_Strategy(object[1].toString());
			result.add(temp);
		});
		return result;
	}
	
	
	public List<migrationdto> getEnvironmentcount(int orgId) {
		List<Object[]> data= repo.getEnvironment(orgId);
		List<migrationdto> result= new ArrayList<migrationdto>();
		
		
				
		data.stream().forEach(object ->{
			migrationdto temp = new migrationdto();
		temp.setNum((BigInteger)object[0]);
		temp.setMigration_Strategy(object[1].toString());
			result.add(temp);
		});
		return result;
	}
	
	public List<migrationdto> getapplicationcount(int orgId) {
		List<Object[]> data= repo.getapplicationcount(orgId);
		List<migrationdto> result= new ArrayList<migrationdto>();
		
		
				
		data.stream().forEach(object ->{
			migrationdto temp = new migrationdto();
		temp.setNum((BigInteger)object[0]);
		if(object[1] != null)
		temp.setMigration_Strategy(object[1].toString());
			result.add(temp);
		});
		return result;
	}
	
	public List<InfraDataModel> getfhnInfraData(int orgId) {  
	    return repo.getdatainfra(orgId);
	} 


}



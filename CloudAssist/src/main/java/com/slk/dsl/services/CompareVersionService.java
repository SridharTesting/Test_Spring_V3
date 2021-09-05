package com.slk.dsl.services;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.slk.dsl.model.ApplicationVersionData;
import com.slk.dsl.model.Fhn_infra_data_history;
import com.slk.dsl.model.InfrastructureVersionData;
import com.slk.dsl.repository.CaAppCompareDAO;
import com.slk.dsl.repository.FHNApplicationDataDAO;



@Service
public class CompareVersionService {

	String Version = "1"; // Defaultval
	String Diff = "Difference";
	String Dele = "Deleted";
	String Add = "Added";
	@Autowired
	FHNApplicationDataDAO CVerDao;
	@Autowired
	CaAppCompareDAO AppverDao;

		LinkedHashMap<String, LinkedHashMap<String, String>> Version1Detailsapp = new LinkedHashMap<String, LinkedHashMap<String, String>>();
		LinkedHashMap<String, LinkedHashMap<String, String>> Version2Detailsapp = new LinkedHashMap<String, LinkedHashMap<String, String>>();
		LinkedHashMap<String, LinkedHashMap<String, String>> Version1Detailsinfra = new LinkedHashMap<String, LinkedHashMap<String, String>>();
		LinkedHashMap<String, LinkedHashMap<String, String>> Version2Detailsinfra = new LinkedHashMap<String, LinkedHashMap<String, String>>();

	JSONArray test;
	public JSONArray CompareVer(int orgId, int Ver1, int Ver2) {
		List<InfrastructureVersionData> queryResult = CVerDao.VersionComparsion(orgId,Ver1);
		List<InfrastructureVersionData> queryResult2 = CVerDao.VersionComparsion2(orgId,Ver2);
//	
		Map<Integer,InfrastructureVersionData> obj1=new LinkedHashMap<Integer,InfrastructureVersionData>();
		Map<Integer,InfrastructureVersionData> obj2=new LinkedHashMap<Integer,InfrastructureVersionData>();
		obj1=queryResult.stream().collect(Collectors.toMap(InfrastructureVersionData::getInfraVersionId, infraversiondata->infraversiondata));
		UpdateCache12new(obj1, obj1.keySet());
		obj2=queryResult2.stream().collect(Collectors.toMap(InfrastructureVersionData::getInfraVersionId, infraversiondata->infraversiondata));
		UpdateCache13new(obj2, obj2.keySet());
		return CompareNUpdateAccordinglyinfra();
	}
	
//	public JSONArray CompareFileOnGivenVer(int Ver1, int Ver2) {
//       List<Fhn_infra_data_history> queryResult = CVerDao.getVersionComparsion(Ver1);
//		List<Fhn_infra_data_history> queryResult2 = CVerDao.getVersionComparsion2(Ver2);
//		 Map<Integer,Fhn_infra_data_history> obj1=new LinkedHashMap<Integer,Fhn_infra_data_history>();
//		 Map<Integer,Fhn_infra_data_history> obj2=new LinkedHashMap<Integer,Fhn_infra_data_history>();
//		 obj1=queryResult.stream().collect(Collectors.toMap(Fhn_infra_data_history::getInfraVersionId, fhn_infra_data_history->fhn_infra_data_history));
//		 obj1.forEach((k,v)->System.out.println(k +"=" +v));
//		 UpdateCache12(obj1, obj1.keySet());
//		 
//		 obj2=queryResult2.stream().collect(Collectors.toMap(Fhn_infra_data_history::getInfraVersionId, fhn_infra_data_history->fhn_infra_data_history));
//		 obj2.forEach((k,v)->System.out.println(k +"=" +v));
//		 UpdateCache13(obj2, obj2.keySet());
//		 
//		  return CompareNUpdateAccordingly();
//		//Map<String,fhn_infra_data_history> obj3=new LinkedHashMap<String,fhn_infra_data_history>();
//	}

	private void UpdateCache13new(Map<Integer, InfrastructureVersionData> obj2, Set<Integer> set) {
		obj2.forEach((k, v) -> {
			 LinkedHashMap<String, String> Version1Edetai2infra = new LinkedHashMap<String, String>();	
			 Version1Edetai2infra.put("HostName", v.getHostName());
			 Version1Edetai2infra.put("Data Center",v.getDataCenter());
			 Version1Edetai2infra.put("Environment",v.getEnvironment());
		
			 Version1Edetai2infra.put("Ip Address",v.getIpAddress());
			 Version1Edetai2infra.put("Hypervisor",v.getHypervisor());
			 Version1Edetai2infra.put("Os Type",v.getOsType());
			 Version1Edetai2infra.put("Os Version",v.getOsVersion());
			 Version1Edetai2infra.put("Os Bitness",v.getOsBitness());
			 Version1Edetai2infra.put("PhysicalOrVirtual",v.getPhysicalOrVirtual());
			 Version1Edetai2infra.put("Server Type",v.getServerType());
			 Version1Edetai2infra.put("Business Unit",v.getBusinessUnit());
			 Version1Edetai2infra.put("Server Owner",v.getServerOwner());
			 Version1Edetai2infra.put("In Scope",v.getInScope());
			 Version1Edetai2infra.put("Cpu Type",v.getCpuType());
			 Version2Detailsinfra.put(v.getHostName(), Version1Edetai2infra);
		});
	}
	
	private void UpdateCache13(Map<Integer, Fhn_infra_data_history> obj2, Set<Integer> set) {
		
			
		 //Version2Details.put(obj2.get(key), value)
			
			obj2.forEach((k, v) -> {
				 LinkedHashMap<String, String> Version1Edetai2 = new LinkedHashMap<String, String>();	
			 
			 Version1Edetai2.put("AppSystem", v.getAppSystem());
//			 Version1Edetai2.put("AppSystem", v.());
//			 Version1Edetai2.put("System Admin",v.getSystemAdmin()); 
//			 Version1Edetai2.put("System Admin Employee Id",v.getSystemAdminEmployeeID()); 
//			 Version1Edetai2.put("DR Relationship Manager",v.getdRRelationshipManager()); 
//			 Version1Edetai2.put("DR Relationship Manager EmployeeID",v.getdRRelationshipManagerEmployeeID()); 
//			 Version1Edetai2.put("Main Platform",v.getMainPlatform()); 
			 //Version1Edetai2.put("Location",v.getLocation()); 
			 Version2Detailsinfra.put(v.getAppSystem(), Version1Edetai2); });
	}
	
	private void UpdateCache12new(Map<Integer, InfrastructureVersionData> obj1, Set<Integer> set) {
		
		obj1.forEach((k, v) -> {
			LinkedHashMap<String, String> Version1Edetailinfra=new LinkedHashMap<String, String>();
	        Version1Edetailinfra.put("HostName", v.getHostName());
	        Version1Edetailinfra.put("Data Center",v.getDataCenter());
	        Version1Edetailinfra.put("Environment",v.getEnvironment());
	        Version1Edetailinfra.put("Ip Address",v.getIpAddress());
			 Version1Edetailinfra.put("Hypervisor",v.getHypervisor());
			 Version1Edetailinfra.put("Os Type",v.getOsType());
			 Version1Edetailinfra.put("Os Version",v.getOsVersion());
			 Version1Edetailinfra.put("Os Bitness",v.getOsBitness());
			 Version1Edetailinfra.put("PhysicalOrVirtual",v.getPhysicalOrVirtual());
			 Version1Edetailinfra.put("Server Type",v.getServerType());
			 Version1Edetailinfra.put("Business Unit",v.getBusinessUnit());
			 Version1Edetailinfra.put("Server Owner",v.getServerOwner());
			 Version1Edetailinfra.put("In Scope",v.getInScope());
			 Version1Edetailinfra.put("Cpu Type",v.getCpuType());
	        Version1Detailsinfra.put(v.getHostName(), Version1Edetailinfra);
	    });
		
	}

	private void UpdateCache12(Map<Integer, Fhn_infra_data_history> obj1, Set<Integer> set) {
		// TODO Auto-generated method stub
		//fetch all the values of versionid from the key of obj1 and put that to Vesion1Edrtail
		
		//iterate over the obj1 and put all the values in versionId1
	System.out.println(obj1.toString());
		
	  //LinkedHashMap<String, String> Version1Edetail=new LinkedHashMap<String, String>();
	obj1.forEach((k, v) -> {
		LinkedHashMap<String, String> Version1Edetail=new LinkedHashMap<String, String>();
        Version1Edetail.put("AppSystem", v.getAppSystem());
        Version1Edetail.put("System Admin", v.getSystemAdmin());
        Version1Edetail.put("System Admin Employee Id",v.getSystemAdminEmployeeID()); 
        Version1Edetail.put("DR Relationship Manager",v.getdRRelationshipManager()); 
        Version1Edetail.put("DR Relationship Manager EmployeeID",v.getdRRelationshipManagerEmployeeID()); 
        Version1Edetail.put("Main Platform",v.getMainPlatform()); 
        Version1Detailsinfra.put(v.getAppSystem(), Version1Edetail);
    });
	
		
		
		
		/*
		 * LinkedHashMap<String, String> Version1Edetail = new LinkedHashMap<String, String>();
		 * Version1Edetail.put("App_ID", ref.getAppId());
		 * Version1Edetail.put("AppSystem", ref.getAppSystem());
		 * Version1Edetail.put("Location", ref.getLocation());
		 * Version1Edetail.put("DRRelationshipManager", ref.getdRRelationshipManager());
		 * Version1Edetail.put("dRRelationshipManagerEmployeeID",
		 * ref.getdRRelationshipManagerEmployeeID());
		 * Version1Edetail.put("mainPlatform", ref.getMainPlatform());
		 * Version1Edetail.put("SystemAdmin", ref.getSystemAdmin());
		 * Version1Details.put(ref.getAppSystem(), Version1Edetail);
		 */
	
		
	}

//private void UpdateCache(Map<String,Fhn_infra_data_history> obj1, Integer Ver) {
//		//get key from obq
//	Fhn_infra_data_history ref=obj1.get("AppId");
//		
//			LinkedHashMap<String, String> Version1Edetail = new LinkedHashMap<String, String>();
//			Version1Edetail.put("App_ID", ref.getAppId());
//			Version1Edetail.put("AppSystem", ref.getAppSystem());
//			Version1Edetail.put("Location", ref.getLocation());
//			Version1Edetail.put("DRRelationshipManager", ref.getdRRelationshipManager());
//			Version1Edetail.put("dRRelationshipManagerEmployeeID", ref.getdRRelationshipManagerEmployeeID());
//			Version1Edetail.put("mainPlatform", ref.getMainPlatform());
//			Version1Edetail.put("SystemAdmin", ref.getSystemAdmin());
//			Version1Details.put(ref.getAppSystem(), Version1Edetail);
//		
//	}
	
	
	private void UpdateCacheForVersion2(Map<String,Fhn_infra_data_history> obj, Integer Ver) {
		Fhn_infra_data_history ref = obj.get("appId");
			LinkedHashMap<String, String> Version1Edetai2 = new LinkedHashMap<String, String>();
			Version1Edetai2.put("App_ID", ref.getAppId());
			Version1Edetai2.put("AppSystem", ref.getAppSystem());
			Version1Edetai2.put("Location", ref.getLocation());
			Version1Edetai2.put("DRRelationshipManager", ref.getdRRelationshipManager());
			Version1Edetai2.put("dRRelationshipManagerEmployeeID", ref.getdRRelationshipManagerEmployeeID());
			Version1Edetai2.put("mainPlatform", ref.getMainPlatform());
			Version1Edetai2.put("SystemAdmin", ref.getSystemAdmin());
			
			Version2Detailsinfra.put(ref.getAppSystem(), Version1Edetai2);
	
	}
	
	

	public JSONArray CompareNUpdateAccordinglyapp() {
		
		JSONArray finalArray=new JSONArray();
		if (Version1Detailsapp.size() > 0 || Version2Detailsapp.size() > 0) {
			List<LinkedHashMap<String, List<LinkedHashMap<String, LinkedHashMap<String, String>>>>> ListAppSystemDetails = new ArrayList<LinkedHashMap<String, List<LinkedHashMap<String, LinkedHashMap<String, String>>>>>();
			
			for (Map.Entry m : Version1Detailsapp.entrySet()) {
				//Version1Details contains all the values fetched from the db

				LinkedHashMap<String, List<LinkedHashMap<String, LinkedHashMap<String, String>>>> VersionDifferenceCache = new LinkedHashMap<String, List<LinkedHashMap<String, LinkedHashMap<String, String>>>>();
				
				if (Version2Detailsapp.containsKey(m.getKey())) {
					// time to comapare for old and new vlues
					List<LinkedHashMap<String, LinkedHashMap<String, String>>> ListColToOldNewVal = new ArrayList<LinkedHashMap<String, LinkedHashMap<String, String>>>();

					LinkedHashMap<String, String> Version1Edetail = (LinkedHashMap<String, String>) m.getValue();
					LinkedHashMap<String, String> Version2Edetail = Version2Detailsapp.get(m.getKey());
//					
					
					
					for (Map.Entry itr : Version1Edetail.entrySet()) {
						
						// compare each header
						String col = (String) itr.getKey(); 
						if(Version2Edetail.get(col) == null) {
							Version2Edetail.put(col, "NULL");
						}else if(Version1Edetail.get(col) == null) {
							Version1Edetail.put(col, "NULL");
						}
						if(Version1Edetail.get(col) != null && Version2Edetail.get(col)!=null) {
						if (!(Version1Edetail.get(col).equals(Version2Edetail.get(col)))) {
							
							LinkedHashMap<String, LinkedHashMap<String, String>> ColToValMapping = new LinkedHashMap<String, LinkedHashMap<String, String>>();
							LinkedHashMap<String, String> oldNNew = new LinkedHashMap<String, String>();
							//List<String> oldNNew = new List<String>
							oldNNew.put("Old Value", Version1Edetail.get(col));
							oldNNew.put("New Value", Version2Edetail.get(col));
							oldNNew.put("Attribute Name",col);
							oldNNew.put("Application Name",(String)m.getKey());
							ObjectMapper objectMapper = new ObjectMapper();

					        try {
					        	List<JSONObject> jsonObj = new ArrayList<JSONObject>();
					            String json = objectMapper.writeValueAsString(oldNNew);
					            System.out.println(json);
					            JSONObject jsnobject = new JSONObject(json);
					            
					            finalArray.put(jsnobject);
					            System.out.println(finalArray);
					            
					          
								
					        } catch (JsonProcessingException e) {
					            e.printStackTrace();
					        }
							
						}
						
						}
					}
					
				} 
				
			}
			
		}
		Version1Detailsapp.clear();
		Version1Detailsinfra.clear();
		Version2Detailsapp.clear();
		Version2Detailsinfra.clear();
		return finalArray;
	
	}
	
	public JSONArray CompareNUpdateAccordinglyinfra() {
		
		JSONArray finalArray=new JSONArray();
		if (Version1Detailsinfra.size() > 0 || Version2Detailsinfra.size() > 0) {
			List<LinkedHashMap<String, List<LinkedHashMap<String, LinkedHashMap<String, String>>>>> ListAppSystemDetails = new ArrayList<LinkedHashMap<String, List<LinkedHashMap<String, LinkedHashMap<String, String>>>>>();
			
			for (Map.Entry m : Version1Detailsinfra.entrySet()) {
				//Version1Details contains all the values fetched from the db

				LinkedHashMap<String, List<LinkedHashMap<String, LinkedHashMap<String, String>>>> VersionDifferenceCache = new LinkedHashMap<String, List<LinkedHashMap<String, LinkedHashMap<String, String>>>>();

				if (Version2Detailsinfra.containsKey(m.getKey())) {
					// time to comapare for old and new vlues
					List<LinkedHashMap<String, LinkedHashMap<String, String>>> ListColToOldNewVal = new ArrayList<LinkedHashMap<String, LinkedHashMap<String, String>>>();

					LinkedHashMap<String, String> Version1Edetail = (LinkedHashMap<String, String>) m.getValue();
					LinkedHashMap<String, String> Version2Edetail = Version2Detailsinfra.get(m.getKey());
					JSONArray arr=new JSONArray();
					
					
					for (Map.Entry itr : Version1Edetail.entrySet()) {
						
						// compare each header
						String col = (String) itr.getKey(); 
						if(Version2Edetail.get(col) == null) {
							Version2Edetail.put(col, "NULL");
						}else if(Version1Edetail.get(col) == null) {
							Version1Edetail.put(col, "NULL");
						}
						if(Version1Edetail.get(col) != null && Version2Edetail.get(col)!=null) {
						if (!(Version1Edetail.get(col).equals(Version2Edetail.get(col)))) {
							
							LinkedHashMap<String, LinkedHashMap<String, String>> ColToValMapping = new LinkedHashMap<String, LinkedHashMap<String, String>>();
							LinkedHashMap<String, String> oldNNew = new LinkedHashMap<String, String>();
							//List<String> oldNNew = new List<String>
							oldNNew.put("Old Value", Version1Edetail.get(col));
							oldNNew.put("New Value", Version2Edetail.get(col));
							oldNNew.put("Attribute Name",col);
							oldNNew.put("Application Name",(String)m.getKey());
							ObjectMapper objectMapper = new ObjectMapper();

					        try {
					        	List<JSONObject> jsonObj = new ArrayList<JSONObject>();
					            String json = objectMapper.writeValueAsString(oldNNew);
					            System.out.println(json);
					            JSONObject jsnobject = new JSONObject(json);
					          
					            finalArray.put(jsnobject);
					            System.out.println(finalArray);
					            
					          
								
					        } catch (JsonProcessingException e) {
					            e.printStackTrace();
					        }
							
						}
						
						}
					}
					
				} 
				
			}
			
		}
		Version1Detailsapp.clear();
		Version1Detailsinfra.clear();
		Version2Detailsapp.clear();
		Version2Detailsinfra.clear();
		return finalArray;
	
	}

	
	public JSONArray CompareVerapp(int orgId, int Ver1, int Ver2) {
		List<ApplicationVersionData> queryResult = AppverDao.VersionComparsion(orgId,Ver1);
		List<ApplicationVersionData> queryResult2 = AppverDao.VersionComparsion2(orgId,Ver2);
//	
		Map<Integer,ApplicationVersionData> obj1=new LinkedHashMap<Integer,ApplicationVersionData>();
		Map<Integer,ApplicationVersionData> obj2=new LinkedHashMap<Integer,ApplicationVersionData>();
		obj1=queryResult.stream().collect(Collectors.toMap(ApplicationVersionData::getAppVersionId, applicationVersionData->applicationVersionData));
		UpdateCache12newApp(obj1, obj1.keySet());
		obj2=queryResult2.stream().collect(Collectors.toMap(ApplicationVersionData::getAppVersionId, applicationVersionData->applicationVersionData));
		UpdateCache13newApp(obj2, obj2.keySet());
//		Version1Details.forEach((k,v)->System.out.println(k +"=" +v));
		return CompareNUpdateAccordinglyapp();
	}
	
	
	private void UpdateCache13newApp(Map<Integer, ApplicationVersionData> obj2, Set<Integer> set) {
		obj2.forEach((k, v)->{
			 LinkedHashMap<String, String> Version1Edetai2app = new LinkedHashMap<String, String>();	
			 Version1Edetai2app.put("AppName", v.getAppName());
			 Version1Edetai2app.put("AppManager",v.getAppManager());
			 Version1Edetai2app.put("VendorName",v.getVendorName());
			 Version1Edetai2app.put("Application Criticality",v.getApplicationCriticality());
			 Version1Edetai2app.put("AppDesc",v.getAppDesc());
			 Version1Edetai2app.put("AppId",v.getAppId());
			 Version1Edetai2app.put("Data Criticality",v.getDataCatApp());
			 Version2Detailsapp.put(v.getAppName(), Version1Edetai2app);
		});
	}

	
	
	private void UpdateCache12newApp(Map<Integer, ApplicationVersionData> obj1, Set<Integer> set) {
		
		obj1.forEach((k, v) -> {
			LinkedHashMap<String, String> Version1Edetailapp=new LinkedHashMap<String, String>();
	        Version1Edetailapp.put("AppName", v.getAppName());
	        Version1Edetailapp.put("AppManager",v.getAppManager());
	        Version1Edetailapp.put("VendorName",v.getVendorName());
	        Version1Edetailapp.put("Application Criticality",v.getApplicationCriticality());
	        Version1Edetailapp.put("AppDesc",v.getAppDesc());
			 Version1Edetailapp.put("AppId",v.getAppId());
			 Version1Edetailapp.put("Data Criticality",v.getDataCatApp());
	        Version1Detailsapp.put(v.getAppName(), Version1Edetailapp);
	    });
		
	}

	
	
		
		

	
}

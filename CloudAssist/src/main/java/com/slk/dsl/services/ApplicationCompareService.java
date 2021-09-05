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
import com.slk.dsl.model.FHNAppVersionData;
import com.slk.dsl.repository.ApplicationCompareDAO;

@Service
public class ApplicationCompareService {
	String Version = "1"; 
	String Diff = "Difference";
	String Dele = "Deleted";
	String Add = "Added";
	
	@Autowired
	ApplicationCompareDAO CVerDao;
	
	LinkedHashMap<String, LinkedHashMap<String, String>> Version1Details = new LinkedHashMap<String, LinkedHashMap<String, String>>();
	LinkedHashMap<String, LinkedHashMap<String, String>> Version2Details = new LinkedHashMap<String, LinkedHashMap<String, String>>();

	LinkedHashMap<String, List<LinkedHashMap<String, List<LinkedHashMap<String, LinkedHashMap<String, String>>>>>> FinalResponseCache = new LinkedHashMap<String, List<LinkedHashMap<String, List<LinkedHashMap<String, LinkedHashMap<String, String>>>>>>();
	
	JSONArray test;
	
	public JSONArray CompareFileOnGivenVer(
			int Ver1, int Ver2) {
       List<FHNAppVersionData> queryResult = CVerDao.getVersionComparsion(Ver1);
		List<FHNAppVersionData> queryResult2 = CVerDao.getVersionComparsion2(Ver2);
		
		 Map<Integer,FHNAppVersionData> obj1=new LinkedHashMap<Integer,FHNAppVersionData>();
		 Map<Integer,FHNAppVersionData> obj2=new LinkedHashMap<Integer,FHNAppVersionData>();
		 
		 obj1=queryResult.stream().collect(Collectors.toMap(FHNAppVersionData::getAppVersionId, FHNAppVersionData->FHNAppVersionData));
		 obj1.forEach((k,v)->System.out.println(k +"=" +v));
		 UpdateCache12(obj1, obj1.keySet());
		 
		 obj2=queryResult2.stream().collect(Collectors.toMap(FHNAppVersionData::getAppVersionId, FHNAppVersionData->FHNAppVersionData));
		 obj2.forEach((k,v)->System.out.println(k +"=" +v));
		 UpdateCache13(obj2, obj2.keySet());
		  return CompareNUpdateAccordingly();
		//Map<String,FHNAppVersionData> obj3=new LinkedHashMap<String,FHNAppVersionData>();
		 
	
	}
	
	private void UpdateCache13(Map<Integer,FHNAppVersionData> obj2, Set<Integer> set) {
		
		
		 
			
			obj2.forEach((k, v) -> {
				 LinkedHashMap<String, String> Version1Edetai2 = new LinkedHashMap<String, String>();	
			 
				 //Version1Edetai2.put("AppId", v.getAppId());
					Version1Edetai2.put("AppSystem", v.getAppSystem());
					Version1Edetai2.put("description",v.getDescription());
				Version1Edetai2.put("dataCatApp",v.getDataCatApp());
				Version1Edetai2.put("rpo",v.getRpo());
			 Version2Details.put(v.getAppSystem(), Version1Edetai2); });
			
			
		
	}
	
	private void UpdateCache12(Map<Integer, FHNAppVersionData> obj1, Set<Integer> set) {
		
		System.out.println(obj1.toString());
			
			
		 	
			

		obj1.forEach((k, v) -> {
	      
			LinkedHashMap<String, String> Version1Edetail=new LinkedHashMap<String, String>();
			//Version1Edetail.put("AppId", v.getAppId());
			Version1Edetail.put("AppSystem", v.getAppSystem());
			Version1Edetail.put("description",v.getDescription());
		Version1Edetail.put("dataCatApp",v.getDataCatApp());
		Version1Edetail.put("rpo",v.getRpo());
			 Version1Details.put(v.getAppSystem(), Version1Edetail);
	    });
		
			
			
			
		
			
		}
	
	
	private void UpdateCache(Map<String,FHNAppVersionData> obj1, Integer Ver) {
		
		FHNAppVersionData ref=obj1.get("AppId");
				
				
				

		
			LinkedHashMap<String, String> Version1Edetail = new LinkedHashMap<String, String>();
			//Version1Edetail.put("AppId", ref.getAppId());
			Version1Edetail.put("AppSystem", ref.getAppSystem());
			Version1Edetail.put("description",ref.getDescription());
		Version1Edetail.put("dataCatApp",ref.getDataCatApp());
		Version1Edetail.put("rpo",ref.getRpo());
		/*
		 * Version1Edetail.put("mainPlatform", ref.getMainPlatform());
		 * Version1Edetail.put("SystemAdmin", ref.getSystemAdmin());
		 */
		Version1Details.put(ref.getAppSystem(), Version1Edetail);
		
			
		
			
		
	}
	
	
	private void UpdateCacheForVersion2(Map<String,FHNAppVersionData> obj, Integer Ver) {
		FHNAppVersionData ref = obj.get("appId");

		
		
		
			LinkedHashMap<String, String> Version1Edetai2 = new LinkedHashMap<String, String>();
			//Version1Edetai2.put("AppId", ref.getAppId());
			Version1Edetai2.put("AppSystem", ref.getAppSystem());
			Version1Edetai2.put("description",ref.getDescription());
		Version1Edetai2.put("dataCatApp",ref.getDataCatApp());
		Version1Edetai2.put("rpo",ref.getRpo());
			
			
			Version2Details.put(ref.getAppSystem(), Version1Edetai2);
		

	}
	
	

	public JSONArray CompareNUpdateAccordingly() {
		
		JSONArray finalArray=new JSONArray();
		if (Version1Details.size() > 0 || Version2Details.size() > 0) {
			List<LinkedHashMap<String, List<LinkedHashMap<String, LinkedHashMap<String, String>>>>> ListAppSystemDetails = new ArrayList<LinkedHashMap<String, List<LinkedHashMap<String, LinkedHashMap<String, String>>>>>();
			
			
			for (Map.Entry m : Version1Details.entrySet()) {
				//Version1Details contains all the values fetched from the db

				LinkedHashMap<String, List<LinkedHashMap<String, LinkedHashMap<String, String>>>> VersionDifferenceCache = new LinkedHashMap<String, List<LinkedHashMap<String, LinkedHashMap<String, String>>>>();

				if (Version2Details.containsKey(m.getKey())) {
					// time to comapare for old and new vlues
					List<LinkedHashMap<String, LinkedHashMap<String, String>>> ListColToOldNewVal = new ArrayList<LinkedHashMap<String, LinkedHashMap<String, String>>>();

					LinkedHashMap<String, String> Version1Edetail = (LinkedHashMap<String, String>) m.getValue();
					LinkedHashMap<String, String> Version2Edetail = Version2Details.get(m.getKey());
					JSONArray arr=new JSONArray();
					
					 
					for (Map.Entry itr : Version1Edetail.entrySet()) {
						
						// compare each header
						String col = (String) itr.getKey();
						if (!Version1Edetail.get(col).equals(Version2Edetail.get(col))) {
							
							LinkedHashMap<String, LinkedHashMap<String, String>> ColToValMapping = new LinkedHashMap<String, LinkedHashMap<String, String>>();
							LinkedHashMap<String, String> oldNNew = new LinkedHashMap<String, String>();
							//List<String> oldNNew = new List<String>
							oldNNew.put("OldValue", Version1Edetail.get(col));
							oldNNew.put("NewValue", Version2Edetail.get(col));
							oldNNew.put("AttributeName",col);
							oldNNew.put("AppSystem",(String)m.getKey());
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
				
				
				/*
				 * if (!VersionDifferenceCache.isEmpty()) {
				 * ListAppSystemDetails.add(VersionDifferenceCache); //
				 * VersionDifferenceCache.clear(); }
				 */
			}
			
			/*
			 * if (!ListAppSystemDetails.isEmpty()) { FinalResponseCache.put(Diff,
			 * ListAppSystemDetails); // ListAppSystemDetails.clear(); }
			 */
		}
		return finalArray;
	
	}
   
}


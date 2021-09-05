
   package com.slk.dsl.services;
   
   

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import  org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import  com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.slk.dsl.model.FHN_Process_history_data;
import com.slk.dsl.repository.FHNProcessCompareDataDAO; 
   
   
   @Service
   public class ProcessCompareService {
   
	   String Version = "1"; 
		String Diff = "Difference";
		String Dele = "Deleted";
		String Add = "Added";
		@Autowired
		FHNProcessCompareDataDAO CVerDao;
		LinkedHashMap<String, LinkedHashMap<String, String>> Version1Details = new LinkedHashMap<String, LinkedHashMap<String, String>>();
		LinkedHashMap<String, LinkedHashMap<String, String>> Version2Details = new LinkedHashMap<String, LinkedHashMap<String, String>>();

		LinkedHashMap<String, List<LinkedHashMap<String, List<LinkedHashMap<String, LinkedHashMap<String, String>>>>>> FinalResponseCache = new LinkedHashMap<String, List<LinkedHashMap<String, List<LinkedHashMap<String, LinkedHashMap<String, String>>>>>>();
		
		//JSONArray test;
		
		public JSONArray CompareFileOnGivenVerProcess(
				int Ver1, int Ver2) {
	       List<FHN_Process_history_data> queryResult = CVerDao.getVersionComparsion(Ver1);
			List<FHN_Process_history_data> queryResult2 = CVerDao.getVersionComparsion2(Ver2);
			
			 Map<String,FHN_Process_history_data> obj1=new LinkedHashMap<String,FHN_Process_history_data>();
			 Map<String,FHN_Process_history_data> obj2=new LinkedHashMap<String,FHN_Process_history_data>();
			 
			 obj1=queryResult.stream().collect(Collectors.toMap(FHN_Process_history_data::getProcessVersionId, FHN_Process_history_data->FHN_Process_history_data));
			 obj1.forEach((k,v)->System.out.println(k +"=" +v));
			 UpdateCache12(obj1, obj1.keySet());
			 
			 obj2=queryResult2.stream().collect(Collectors.toMap(FHN_Process_history_data::getProcessVersionId, FHN_Process_history_data->FHN_Process_history_data));
			 obj2.forEach((k,v)->System.out.println(k +"=" +v));
			 UpdateCache13(obj2, obj2.keySet());
			  return CompareNUpdateAccordingly();
			//Map<String,FHN_Process_history_data> obj3=new LinkedHashMap<String,FHN_Process_history_data>();
			 
		
		}

		private void UpdateCache13(Map<String, FHN_Process_history_data> obj2, Set<String> keySet) {
			
				
			 //Version2Details.put(obj2.get(key), value)
				
				obj2.forEach((k, v) -> {
					 LinkedHashMap<String, String> Version1Edetai2 = new LinkedHashMap<String, String>();	
				 
				 Version1Edetai2.put("AppSystem", v.getAppSystem());
				 Version1Edetai2.put("BusinessOwner",v.getBusinessOwner());
				 Version1Edetai2.put("BusinessManager",v.getBusinessManager());
				 Version1Edetai2.put("ETManager",v.geteTManager());
				 Version1Edetai2.put("ETDirector",v.geteTDirector());
				 Version2Details.put(v.getAppSystem(), Version1Edetai2); });
				
				
			
		}

		private void UpdateCache12(Map<String, FHN_Process_history_data> obj1, Set<String> keySet) {
			
		System.out.println(obj1.toString());
			
			
		 	
			

		obj1.forEach((k, v) -> {
	      
			LinkedHashMap<String, String> Version1Edetail=new LinkedHashMap<String, String>();
			Version1Edetail.put("AppSystem", v.getAppSystem());
			Version1Edetail.put("BusinessOwner",v.getBusinessOwner());
			Version1Edetail.put("BusinessManager",v.getBusinessManager());
			Version1Edetail.put("ETManager",v.geteTManager());
			Version1Edetail.put("ETDirector",v.geteTDirector());
			 Version1Details.put(v.getAppSystem(), Version1Edetail);
	    });
		
			
			
			
		
			
		}

		private void UpdateCache(Map<String,FHN_Process_history_data> obj1, Integer Ver) {
			
			FHN_Process_history_data ref=obj1.get("AppId");
					
					
					

			
				LinkedHashMap<String, String> Version1Edetail = new LinkedHashMap<String, String>();
				Version1Edetail.put("App_ID", ref.getAppId());
				Version1Edetail.put("AppSystem", ref.getAppSystem());
				Version1Edetail.put("BusinessOwner", ref.getBusinessOwner());
				Version1Edetail.put("BusinessManager", ref.getBusinessManager());
				Version1Edetail.put("ETManager", ref.geteTManager());
				Version1Edetail.put("ETDirector",ref.geteTDirector());
//				Version1Edetail.put("mainPlatform", ref.getMainPlatform());
//				Version1Edetail.put("SystemAdmin", ref.getSystemAdmin());
//				Version1Details.put(ref.getAppSystem(), Version1Edetail);
			
			
			
				
			
		}
		
		
		private void UpdateCacheForVersion2(Map<String,FHN_Process_history_data> obj, Integer Ver) {
			FHN_Process_history_data ref = obj.get("appId");

			
			
			
				LinkedHashMap<String, String> Version1Edetai2 = new LinkedHashMap<String, String>();
				Version1Edetai2.put("App_ID", ref.getAppId());
				Version1Edetai2.put("AppSystem", ref.getAppSystem());
				Version1Edetai2.put("BusinessOwner", ref.getBusinessOwner());
				Version1Edetai2.put("BusinessManager", ref.getBusinessManager());
				Version1Edetai2.put("ETManager", ref.geteTManager());
				Version1Edetai2.put("ETDirector",ref.geteTDirector());
//				Version1Edetail.put("mainPlatform", ref.getMainPlatform());
//				Version1Edetail.put("SystemAdmin", ref.getSystemAdmin());
//				Version1Details.put(ref.getAppSystem(), Version1Edetail);
				
				
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
								
								
								
								
								
								oldNNew.put("AppSystem",(String)m.getKey());
								oldNNew.put("AttributeName",col);
								oldNNew.put("OldValue", Version1Edetail.get(col));
								oldNNew.put("NewValue", Version2Edetail.get(col));
								
								
								ObjectMapper objectMapper = new ObjectMapper();

						        try {
						        	List<JSONObject> jsonObj = new ArrayList<JSONObject>();
						            String json = objectMapper.writeValueAsString(oldNNew);
						           // System.out.println(json);
						            
						            //Gson gson = new Gson();
						            //JsonObject jsonObject = gson.fromJson(json,JsonObject.class);
						            JSONObject jsnobject = new JSONObject(json);
						           // jsnobject.wrap();
									/*
									 * try { Field changeMap = jsnobject.getClass().getDeclaredField("map");
									 * changeMap.setAccessible(true); changeMap.set(jsnobject, new
									 * LinkedHashMap<>()); changeMap.setAccessible(false); } catch
									 * (IllegalAccessException | NoSuchFieldException e) {
									 * //log.info(e.getMessage()); }
									 */
						           // System.out.println(jsnobject);
						            finalArray.put(jsnobject);
						           // System.out.println(finalArray);
						          
						          
									
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
 
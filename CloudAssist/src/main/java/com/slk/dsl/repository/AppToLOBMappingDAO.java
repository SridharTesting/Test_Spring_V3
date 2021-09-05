package com.slk.dsl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.slk.dsl.dto.LOBAppLinking;
import com.slk.dsl.model.AppLOBLinkingTable;
import com.slk.dsl.model.AppToLOBMapping;



public interface AppToLOBMappingDAO extends JpaRepository<AppToLOBMapping, Integer> {

	

	/*
	 * @Query("select new com.slk.dsl.dto.LOBAppLinking(l.appId,l.appDesc,a.lobId) from AppToLOBMapping l JOIN AppLOBLinkingTable a on l.appId=a.appId "
	 * ) public List<LOBAppLinking> getAppsTaggedToLOBS();
	 * 
	 * 
	 * @Query("select new com.slk.dsl.dto.LOBAppLinking(l.appId,l.appDesc) from AppToLOBMapping l LEFT JOIN AppLOBLinkingTable a on l.appId=a.appId"
	 * ) public List<LOBAppLinking> getAllApps();
	 */
	

	/*
	 * @Query(
	 * value="select l.App_Id,l.App_Desc,l.App_Name from ca_app_master l inner join ca_lob_app a on l.App_Id=a.App_ID and a.lob_Id= :id "
	 * ,nativeQuery = true)
	 * 
	 * public List<AppToLOBMapping> getAppsTaggedToLOBS(Integer id);
	 */
	
	
	String findQuery = "select app.App_Id,app.Org_Id,app.LOB_Desc,app.App_Type,app.App_Name,app.App_Desc,'1' as appChecked from ca_app_master app inner join ca_lob_app lob\r\n" + 
			"	on app.App_Id=lob.App_ID and lob.lob_Id=:id\r\n" + 
			"	union \r\n" + 
			"	SELECT App_Id,App_Name,App_Desc,'0' as appChecked\r\n" + 
			"	FROM   ca_app_master\r\n" + 
			"	WHERE  App_Id NOT IN (select App_Id\r\n" + 
			"	from  ca_lob_app lob)";
	
			@Query(value = findQuery, nativeQuery = true)
	public List<Object[]> getAppsTaggedToLOBS(Integer id); 

	
	
	
	
 
    
	
}

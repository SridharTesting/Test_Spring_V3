package com.slk.dsl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slk.dsl.model.ApplicationLevelQuestioner;

@Repository
public interface ApplicationQuestionerDAO extends JpaRepository<ApplicationLevelQuestioner, Integer>{

	String lookupid = "select questioner_lookup_Id,questioner_Values,questioner_Id from ca_survey_questioner_lookup";
	@Query(value = lookupid, nativeQuery = true)
	public List<Object[]> getlookupid();
	
	String delete="delete from ca_app_survey_response where app_Id = :app_Id";
	@Transactional
	@Modifying
	@Query(value = delete, nativeQuery = true)
	public void delete(int app_Id);
	
	String subquestionvalues="select sl.questioner_lookup_Id,sl.questioner_sublookup_values from ca_survey_questioner_sublookup sl\r\n"
			+ "inner join ca_survey_questioner_lookup cql on sl.questioner_lookup_Id = cql.questioner_lookup_Id\r\n"
			+ " where cql.questioner_Values = :name";
	@Query(value = subquestionvalues, nativeQuery = true)
	public List<Object[]> bringsubquestionvalues(String name);
	
	
	String sublookup="select * from ca_survey_questioner_sublookup";
	@Query(value = sublookup, nativeQuery = true)
	public List<Object[]> getsublookupTable();
	

	@Query(value="select  distinct mastera.App_Master_Id from ca_app_survey_response ca inner join ca_app_master mastera ON ca.App_Id=mastera.App_Id where ca.App_Id=:appId and Org_Id=:orgId",nativeQuery = true)
    public int getAppMasterId(int appId,int orgId);

   
    @Modifying(clearAutomatically = true,flushAutomatically=true)
    @Transactional
	@Query(value = "update ca_app_master set App_Suv_Status = 1 where App_Master_Id =:appMasterId and Org_Id=:orgId ", nativeQuery = true)
	public void activateApplication(int appMasterId,int orgId);
}

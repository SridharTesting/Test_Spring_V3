package com.slk.dsl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slk.dsl.dto.CSBQuestionerDTO;
import com.slk.dsl.model.CSB_Questioner;
import com.slk.dsl.model.QuestionerResponse;


@Repository
public interface CSBQuestionerDAO extends JpaRepository<QuestionerResponse, Integer> {

	String findQuestionerTableQuery = "select distinct\r\n" + 
			"cq.questioner_Id, cq.question_description,cqc.questioner_Category,crt.response_Type,cql.questioner_lookup_Id,cql.questioner_Values,cqc.questioner_Category_Id\r\n" + 
			"from ca_survey_questioner as cq \r\n" + 
			"inner join ca_questioner_category as cqc on cq.questioner_Category_Id = cqc.questioner_Category_Id\r\n" + 
			"inner join ca_survey_questioner_responsetype as crt on crt.response_Type_Id = cq.response_Type_Id\r\n" + 
			"inner join ca_survey_questioner_lookup as cql on cql.questioner_Id = cq.questioner_Id\r\n" + 
			"where cq.Org_App_QuestionType=1 \r\n" + 
			"order by cq.questioner_Id,cqc.questioner_Category_Id;";
	@Query(value = findQuestionerTableQuery, nativeQuery = true)
	public List<Object[]> getQuestionList();
	
	
	String findSelectedOption = "select distinct\r\n" + 
			"cq.questioner_Id, oqr.comments as selected_val\r\n" + 
			"from ca_survey_questioner as cq\r\n" + 
			"left join ca_org_survey_response as oqr on oqr.questioner_Id = cq.questioner_Id\r\n" + 
			"where cq.Org_App_QuestionType=1 and oqr.org_Id=:orgid \r\n" + 
			"order by cq.questioner_Id;";
	@Query(value = findSelectedOption, nativeQuery = true)
	public List<Object[]> getSelectedQuestion(int orgid);
	
	String findSelectedOptionApp = "select distinct\r\n" + 
			"cq.questioner_Id, oqr.comments as selected_val\r\n" + 
			"from ca_survey_questioner as cq\r\n" + 
			"left join ca_app_survey_response as oqr on oqr.questioner_Id = cq.questioner_Id\r\n" + 
			"where cq.Org_App_QuestionType=2  and oqr.comments is not null and oqr.app_id=:appid \r\n" + 
			"order by cq.questioner_Id;";
	@Query(value = findSelectedOptionApp, nativeQuery = true)
	public List<Object[]> getSelectedQuestionapp(int appid);
	
	String delete="delete from  ca_org_survey_response where org_Id = :orgid";
	@Transactional
	@Modifying
	@Query(value = delete, nativeQuery = true)
	public void delete(int orgid);
	
	String lookupid = "select questioner_lookup_Id,questioner_Values,questioner_Id from ca_survey_questioner_lookup;";
	@Query(value = lookupid, nativeQuery = true)
	public List<Object[]> getlookupid();
	
	
	String findQuestionerTableQueryapplevel = "select distinct\r\n" + 
			"cq.questioner_Id, cq.question_description,cqc.questioner_Category,crt.response_Type,case when cql.questioner_lookup_Id is null then 0 else cql.questioner_lookup_Id end as questioner_lookup_Id,case when cql.questioner_Values is null then \"\" else cql.questioner_Values end as questioner_Values\r\n" + 
			"from ca_survey_questioner as cq \r\n" + 
			"inner join ca_questioner_category as cqc on cq.questioner_Category_Id = cqc.questioner_Category_Id\r\n" + 
			"inner join ca_survey_questioner_responsetype as crt on crt.response_Type_Id = cq.response_Type_Id\r\n" + 
			"left join ca_survey_questioner_lookup as cql on cql.questioner_Id = cq.questioner_Id\r\n" + 
			"where cq.Org_App_QuestionType=2 \r\n" + 
			"order by cq.questioner_Id";
	@Query(value = findQuestionerTableQueryapplevel, nativeQuery = true)
	public List<Object[]> getQuestionListappLevel();
	
	
}

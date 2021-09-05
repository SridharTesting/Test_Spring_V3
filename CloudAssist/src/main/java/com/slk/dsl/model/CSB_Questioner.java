package com.slk.dsl.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="ca_survey_questioner")
public class CSB_Questioner {
	@Id
	@Column(name="questioner_Id")
	private int questioner_Id;
	@Column(name="questioner_Category_Id")
	private int questioner_Category_Id;
	@Column(name="response_Type_Id")
	private int response_Type_Id;
	
	@Column(name="question_description")
	private String question_description;
	@Column(name="Org_App_QuestionType")
	private int Org_App_QuestionType;
	
	
	@Column(name="is_Active")
	private boolean is_Active;
	@Column(name="rec_Ins_Dt")
	private Date rec_Ins_Dt;
	@Column(name="rec_Upd_Dt")
	private Date rec_Upd_Dt;

	

}

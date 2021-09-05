package com.slk.dsl.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ca_survey_questioner_lookup")
public class CSB_Questioner_Lkp {
	
	@Id
	@Column(name="questioner_Id")
	private int questioner_Id;
	@Column(name="response_Type_Id")
	private int response_Type_Id;
	@Column(name="questioner_Values")
	private String questioner_Values;

	@Column(name="is_Active")
	private boolean is_Active;
	@Column(name="rec_Ins_Dt")
	private Date rec_Ins_Dt;
	@Column(name="rec_Upd_Dt")
	private Date rec_Upd_Dt;

	
}

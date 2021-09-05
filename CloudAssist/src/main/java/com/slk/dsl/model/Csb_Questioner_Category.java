package com.slk.dsl.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="ca_questioner_category")

public class Csb_Questioner_Category {
	@Id
	@Column(name="questioner_Category_Id")
	private int questioner_Category_Id;
	@Column(name="questioner_Category")
	private String questioner_Category;
	@Column(name="org_App_questiontype")
	private int org_App_questiontype;

	@Column(name="is_Active")
	private boolean is_Active;
	@Column(name="rec_Ins_Dt")
	private Date rec_Ins_Dt;
	@Column(name="rec_Upd_Dt")
	private Date rec_Upd_Dt;

}

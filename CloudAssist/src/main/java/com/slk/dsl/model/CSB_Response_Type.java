package com.slk.dsl.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="csb_response_type")
public class CSB_Response_Type {
	
	@Id
	@Column(name="response_Type_Id")
	private int response_Type_Id;
	
	@Column(name="response_Type")
	private String response_Type;

	
	@Column(name="type_Description")
	private String type_Description;

	@Column(name="is_Active")
	private boolean is_Active;
	@Column(name="rec_Ins_Dt")
	private Date rec_Ins_Dt;
	@Column(name="rec_Upd_Dt")
	private Date rec_Upd_Dt;

	
}

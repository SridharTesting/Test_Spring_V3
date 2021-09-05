package com.slk.dsl.model;



//import java.util.List;

import javax.persistence.Column;


public class QuestionerReturnedModel {
	
	@Column
	int app_Id;
	
	@Column
	String app_System;
	
	@Column
	String field_Name;
	
	
	@Column
	String questioner;
	
	@Column
	String field_Value;

	public int getApp_Id() {
		return app_Id;
	}

	public void setApp_Id(int App_Id) {
		app_Id = App_Id;
	}

	public String getApp_System() {
		return app_System;
	}

	public void setApp_System(String App_System) {
		app_System = App_System;
	}

	public String getField_Name() {
		return field_Name;
	}

	public void setField_Name(String Field_Name) {
		field_Name = Field_Name;
	}

	public String getQuestioner() {
		return questioner;
	}

	public void setquestioner(String Questioner) {
		questioner = Questioner;
	}

	public String getField_Value() {
		return field_Value;
	}

	public void setField_Value(String Field_Value) {
		field_Value = Field_Value;
	}
	
	
	
	
}

package com.slk.dsl.dto;

public class ApplicationSurveycountDTO {
	
	String LOB_Id;
	public String getLOB_Id() {
		return LOB_Id;
	}
	public void setLOB_Id(String lOB_Id) {
		LOB_Id = lOB_Id;
	}
	public String getLob_Name() {
		return Lob_Name;
	}
	public void setLob_Name(String lob_Name) {
		Lob_Name = lob_Name;
	}
	public String getApp_Name() {
		return App_Name;
	}
	public void setApp_Name(String app_Name) {
		App_Name = app_Name;
	}
	public String getApp_Suv_Status() {
		return App_Suv_Status;
	}
	public void setApp_Suv_Status(String app_Suv_Status) {
		App_Suv_Status = app_Suv_Status;
	}
	String Lob_Name;
	String App_Name;
	String App_Suv_Status;
}

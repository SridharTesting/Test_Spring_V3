package com.slk.dsl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.ParameterMode;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Table
@NamedStoredProcedureQuery
(
name="GetQuestionerTemplate",
procedureName="GetQuestionerTemplate",
parameters= 
    {
	@StoredProcedureParameter
	(mode=ParameterMode.IN,name="orgidp",type=int.class),
	@StoredProcedureParameter
	(mode=ParameterMode.IN,name="viewtype",type=int.class)
	}
)
public class questionare{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="appId")
	private int appId;
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public String getAppsystem() {
		return appsystem;
	}
	public void setAppsystem(String appsystem) {
		this.appsystem = appsystem;
	}
	public String getAttribute() {
		return Attribute;
	}
	public void setAttribute(String attribute) {
		Attribute = attribute;
	}
	@Column(name="appSystem")
	private  String appsystem;
	@Column(name="attribute")
	private  String Attribute;
	
//	public int id;
//	public String appSystem;
//	public String questioner;
//	public String attribute;
}
package com.slk.dsl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ca_infra_app_mapping")
public class Ca_infra_app_mapping {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Infra_App_Id")
	private int infra_App_Id;
	@Column(name="Infra_Id")
	private int infra_Id;
	
	@Column(name="App_Master_Id")
	private int app_Master_Id;
	public int getInfra_App_Id() {
		return infra_App_Id;
	}
	public void setInfra_App_Id(int infra_App_Id) {
		this.infra_App_Id = infra_App_Id;
	}
	public int getInfra_Id() {
		return infra_Id;
	}
	public void setInfra_Id(int infra_Id) {
		this.infra_Id = infra_Id;
	}
	public int getApp_Master_Id() {
		return app_Master_Id;
	}
	public void setApp_Master_Id(int app_Master_Id) {
		this.app_Master_Id = app_Master_Id;
	}
	
	public String getRecInsDt() {
		return recInsDt;
	}
	public void setRecInsDt(String recInsDt) {
		this.recInsDt = recInsDt;
	}
	public String getRecUpdDt() {
		return recUpdDt;
	}
	public void setRecUpdDt(String recUpdDt) {
		this.recUpdDt = recUpdDt;
	}
	public int getOrg_Id() {
		return org_Id;
	}
	public void setOrg_Id(int org_Id) {
		this.org_Id = org_Id;
	}
	@Column(name="Rec_Ins_Dt")
	private String recInsDt;
	@Column(name="Rec_Upd_Dt")
	private String recUpdDt;
	@Column(name="Org_Id")
	private int org_Id;
}

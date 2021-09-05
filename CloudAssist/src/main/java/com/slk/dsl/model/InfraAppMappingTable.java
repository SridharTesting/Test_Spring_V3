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
public class InfraAppMappingTable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Infra_App_Id",nullable = false, unique = true)
	private int infraAppId;
	

	@Column(name="Infra_Id")
	private int infraId;
	

	@Column(name="Org_Id")
	private int orgId;
	
	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}


	@Column(name="App_Master_Id")
	private int appMasterId;
	
	public int getInfraAppId() {
		return infraAppId;
	}

	public void setInfraAppId(int infraAppId) {
		this.infraAppId = infraAppId;
	}

	public int getInfraId() {
		return infraId;
	}

	public void setInfraId(int infraId) {
		this.infraId = infraId;
	}

	public int getAppMasterId() {
		return appMasterId;
	}

	public void setAppMasterId(int appMasterId) {
		this.appMasterId = appMasterId;
	}

	public Date getRecInsDt() {
		return recInsDt;
	}

	public void setRecInsDt(Date recInsDt) {
		this.recInsDt = recInsDt;
	}


	@Column(name="Rec_Ins_Dt")
	private Date recInsDt;
	
	@Column(name="Rec_Upd_Dt")
	private Date recUpdDt;

	public Date getRecUpdDt() {
		return recUpdDt;
	}

	public void setRecUpdDt(Date recUpdDt) {
		this.recUpdDt = recUpdDt;
	}

}

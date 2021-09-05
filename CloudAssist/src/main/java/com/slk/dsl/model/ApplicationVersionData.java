package com.slk.dsl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="ca_app_master_versioning")
public class ApplicationVersionData {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="app_version_id")
	private int appVersionId;
	
	@Column(name="App_Id")
	private String appId;
	

	@Column(name="versionId")
	private int versionId;
	
	@Column(name="App_Name")
	private String appName;
	
	@Column(name="Migration_Status")
	private int migrationStatus;
	
	
	public int getMigrationStatus() {
		return migrationStatus;
	}
	public void setMigrationStatus(int migrationStatus) {
		this.migrationStatus = migrationStatus;
	}

	@Column(name="App_Desc")
	private String appDesc;
	
	@Column(name="Org_Id")
	private int orgId;
	
	@Column(name="comments")
	private String comments; 
	@Column(name="Rec_Ins_Dt")
	private Date recInsDt;
	@Column(name="Rec_Upd_Dt")
	private Date recUpdDt;
	@Column(name="LOB_Id")
	private int lobId;
	
	@Column(name="App_Manager")
	private String appManager;
	
	public int getAppVersionId() {
		return appVersionId;
	}
	public void setAppVersionId(int appVersionId) {
		this.appVersionId = appVersionId;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public int getVersionId() {
		return versionId;
	}
	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAppDesc() {
		return appDesc;
	}
	public void setAppDesc(String appDesc) {
		this.appDesc = appDesc;
	}
	public int getOrgId() {
		return orgId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getRecInsDt() {
		return recInsDt;
	}
	public void setRecInsDt(Date recInsDt) {
		this.recInsDt = recInsDt;
	}
	public Date getRecUpdDt() {
		return recUpdDt;
	}
	public void setRecUpdDt(Date recUpdDt) {
		this.recUpdDt = recUpdDt;
	}
	public int getLobId() {
		return lobId;
	}
	public void setLobId(int lobId) {
		this.lobId = lobId;
	}
	public String getAppManager() {
		return appManager;
	}
	public void setAppManager(String appManager) {
		this.appManager = appManager;
	}
	public int getRlaneStrategyId() {
		return rlaneStrategyId;
	}
	public void setRlaneStrategyId(int rlaneStrategyId) {
		this.rlaneStrategyId = rlaneStrategyId;
	}
	public String getDataCatApp() {
		return dataCatApp;
	}
	public void setDataCatApp(String dataCatApp) {
		this.dataCatApp = dataCatApp;
	}
	public String getApplicationCriticality() {
		return applicationCriticality;
	}
	public void setApplicationCriticality(String applicationCriticality) {
		this.applicationCriticality = applicationCriticality;
	}
	public int getAppSuvStatus() {
		return appSuvStatus;
	}
	public void setAppSuvStatus(int appSuvStatus) {
		this.appSuvStatus = appSuvStatus;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	@Column(name="RLane_Strategy_Id")
	private int rlaneStrategyId;
	public ApplicationVersionData() {
		
	}
	public ApplicationVersionData(int appVersionId, String appId, int versionId, String appName, int migrationStatus,
			String appDesc, int orgId, String comments, Date recInsDt, Date recUpdDt, int lobId, String appManager,
			int rlaneStrategyId, String dataCatApp, String applicationCriticality, int appSuvStatus,
			String vendorName) {
		super();
		this.appVersionId = appVersionId;
		this.appId = appId;
		this.versionId = versionId;
		this.appName = appName;
		this.migrationStatus = migrationStatus;
		this.appDesc = appDesc;
		this.orgId = orgId;
		this.comments = comments;
		this.recInsDt = recInsDt;
		this.recUpdDt = recUpdDt;
		this.lobId = lobId;
		this.appManager = appManager;
		this.rlaneStrategyId = rlaneStrategyId;
		this.dataCatApp = dataCatApp;
		this.applicationCriticality = applicationCriticality;
		this.appSuvStatus = appSuvStatus;
		this.vendorName = vendorName;
	}

	@Column(name="Data_Criticality")
	private String dataCatApp;
	@Column(name="Application_Criticality")
	private String applicationCriticality;
	@Column(name="App_Suv_Status")
	private int appSuvStatus;
	@Column(name="Vendor_Name")
	private String vendorName;
	
	
}
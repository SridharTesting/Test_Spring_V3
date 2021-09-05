package com.slk.dsl.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CollectionId;

@Entity
@Table(name="ca_app_master")
public class Application {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="App_Master_Id")
	private int appMasterId;
	 
	
	@Column(name="App_Id", unique = true)
	private String appId;
	
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
	
	@Column(name="RLane_Strategy_Id")
	private int rlaneStrategyId;
	
	@Column(name="Data_Criticality")
	private String dataCatApp;
	@Column(name="Application_Criticality")
	private String applicationCriticality;


	
	public String getDataCatApp() {
		return dataCatApp;
	}
	public void setDataCatApp(String dataCatApp) {
		this.dataCatApp = dataCatApp;
	}

	/*
	 * @ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	 * 
	 * @JoinTable(name="InfraAppMappingTable",
	 * joinColumns={@JoinColumn(name="App_Master_Id")}, inverseJoinColumns =
	 * {@JoinColumn(name="Infra_Id")}) private Set<InfraDataModel> infra=new
	 * HashSet<>();
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * public Set<InfraDataModel> getInfra() { return infra; } public void
	 * setInfra(Set<InfraDataModel> infra) { this.infra = infra; }
	 */
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


	public int getAppSuvStatus() {
		return appSuvStatus;
	}
	public int getRlaneStrategyId() {
		return rlaneStrategyId;
	}
	public void setRlaneStrategyId(int rlaneStrategyId) {
		this.rlaneStrategyId = rlaneStrategyId;
	}
	public String getApplicationCriticality() {
		return applicationCriticality;
	}
	public void setApplicationCriticality(String applicationCriticality) {
		this.applicationCriticality = applicationCriticality;
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
	
	public int getAppMasterId() {
		return appMasterId;
	}
	public void setAppMasterId(int appMasterId) {
		this.appMasterId = appMasterId;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
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
	

	@Column(name="App_Suv_Status")
	private int appSuvStatus;
	@Column(name="Vendor_Name")
	private String vendorName;
	

}

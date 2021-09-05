

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

@Entity
@Table(name="ca_app_master")
public class CAAppMaster {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="App_Master_Id")
	private int appMasterId;
	@Column(name="App_Id")
	private String appId;
	
	@Column(name="App_Name")
	private String appName;
	
	@Column(name="Migration_Status")
	private String Migration_Status; 
	
	
	public String getMigration_Status() {
		return Migration_Status;
	}
	public void setMigration_Status(String migration_Status) {
		Migration_Status = migration_Status;
	}
	public String getApplicationCriticality() {
		return ApplicationCriticality;
	}
	public void setApplicationCriticality(String applicationCriticality) {
		ApplicationCriticality = applicationCriticality;
	}


	@Column(name="Application_Criticality")
	private String ApplicationCriticality;
	
	@Column(name="App_Desc")
	private String appDesc;
	
	@Column(name="Org_Id")
	private int orgId;
	
	@Column(name="RLane_Strategy_Id")
	private int RLane_Strategy_Id;
	
	


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
	
	

	
	@Column(name="Data_Criticality")
	private String Data_Criticality;


	public String getDataCatApp() {
		return Data_Criticality;
	}
	public void setDataCatApp(String dataCatApp) {
		this.Data_Criticality = dataCatApp;
	}



//	@ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
//	@JoinTable(name="InfraAppMappingTable",
//	joinColumns={@JoinColumn(name="App_Master_Id")},
//  inverseJoinColumns = {@JoinColumn(name="Infra_Id")})
//	private Set<InfraDataModel> infra=new HashSet<>();
//	
	

	
				
			
	
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
	public int getRLane_Strategy_Id() {
		return RLane_Strategy_Id;
	}
	public void setRLane_Strategy_Id(int rLane_Strategy_Id) {
		RLane_Strategy_Id = rLane_Strategy_Id;
	}
	

	@Column(name="App_Suv_Status")
	private int appSuvStatus;
	@Column(name="Vendor_Name")
	private String vendorName;
	

}
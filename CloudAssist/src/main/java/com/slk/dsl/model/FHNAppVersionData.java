package com.slk.dsl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="fhn_application_versioning_data")
public class FHNAppVersionData {

	
	
	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="app_version_id",nullable = false, unique = true)
	
		private int appVersionId;
	
	
	
	public int getAppVersionId() {
		return appVersionId;
	}
	public void setAppVersionId(int appVersionId) {
		this.appVersionId = appVersionId;
	}



	@Column(name="appId")
	private int appId;
	
	 @Column(name="AppSystem")
	private String appSystem;
	 
	 public int getVersionId() {
		return versionId;
	}
	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}



	@Column(name="versionId")
	private int versionId;
	 
	@Column(name="Description")
	private String description;
	

	
	
	



	
	
	

	


	

	
	@Column(name="HoursofOp")
	private String hoursofOp;
	
	@Column(name="DataCatApp")
	private String dataCatApp;
	
	@Column(name="CustomerFacing")
	private String customerFacing;
	
@Column(name="orgId")
private int orgId;
	

	

	public int getOrgId() {
	return orgId;
}
public void setOrgId(int orgId) {
	this.orgId = orgId;
}



	@Column(name="RTA")
	private String rta;
	
	@Column(name="RPO")
	private String rpo;
	@Column(name="RPA")
	private String rpa;
	@Column(name="VendorConfirmation")
	private String vendorConfirmation;
	
	
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public String getAppSystem() {
		return appSystem;
	}
	public void setAppSystem(String appSystem) {
		this.appSystem = appSystem;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getHoursofOp() {
		return hoursofOp;
	}
	public void setHoursofOp(String hoursofOp) {
		this.hoursofOp = hoursofOp;
	}
	public String getDataCatApp() {
		return dataCatApp;
	}
	public void setDataCatApp(String dataCatApp) {
		this.dataCatApp = dataCatApp;
	}
	public String getCustomerFacing() {
		return customerFacing;
	}
	public void setCustomerFacing(String customerFacing) {
		this.customerFacing = customerFacing;
	}

	
	
	
	public String getRta() {
		return rta;
	}
	public void setRta(String rta) {
		this.rta = rta;
	}
	public String getRpo() {
		return rpo;
	}
	public void setRpo(String rpo) {
		this.rpo = rpo;
	}
	public String getRpa() {
		return rpa;
	}
	public void setRpa(String rpa) {
		this.rpa = rpa;
	}
	public String getVendorConfirmation() {
		return vendorConfirmation;
	}
	public void setVendorConfirmation(String vendorConfirmation) {
		this.vendorConfirmation = vendorConfirmation;
	}
	public FHNAppVersionData(  int appId, String appSystem, String description,
			String vendor, String lastUpdate, String businessOwner, String businessManager,
			String businessManagerEmployeeID, String eTDirector, String eTDirectorEmployeeID, String eTManager,
			String eTManagerEmployeeID, String eTPrimaryTechnical, String eTPrimaryTechnicalEmployeeID,
			String eTSecondaryTechnical, String eTSecondaryTechnicalEmployeeID, String systemAdmin,
			String systemAdminEmployeeID, String dRRelationshipManager, String dRRelationshipManagerEmployeeID,
			String lob, String mainPlatform, String networkExposure, String scName, String soxCritical,
			String hoursofOp, String dataCatApp, String customerFacing, String qualityScore, String rto, String domain,
			String managerCertification, String os, String location, String asp, String dRExerciseResults,
			String applicationDRPlan, String dRExerciseDate, String dRTier, String dRPlanDate, String rta, String rpo,
			String rpa, String vendorConfirmation) {
		super();
		
		
		this.appId = appId;
		this.appSystem = appSystem;
		this.description = description;
		
		this.hoursofOp = hoursofOp;
		this.dataCatApp = dataCatApp;
		this.customerFacing = customerFacing;
		
		
		
		this.rta = rta;
		this.rpo = rpo;
		this.rpa = rpa;
		this.vendorConfirmation = vendorConfirmation;
	}
	
	
	
	public FHNAppVersionData() {
		
	}
}

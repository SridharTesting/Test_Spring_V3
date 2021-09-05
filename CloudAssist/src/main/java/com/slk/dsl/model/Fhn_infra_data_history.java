package com.slk.dsl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="fhn_infrastructure_data_versioning")
public class Fhn_infra_data_history {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="infraVersionId",nullable = false, unique = true)
	
	private int infraVersionId;
	
	@Column(name="orgId")
	private int orgId;
	
	@Column(name="appId")
	private String appId;
	
	 @Column(name="AppSystem")
		private String appSystem;
	
	public int getInfraVersionId() {
		return infraVersionId;
	}




	public void setInfraVersionId(int infraVersionId) {
		this.infraVersionId = infraVersionId;
	}




	public String getAppId() {
		return appId;
	}




	public void setAppId(String appId) {
		this.appId = appId;
	}




	public String getAppSystem() {
		return appSystem;
	}




	public void setAppSystem(String appSystem) {
		this.appSystem = appSystem;
	}




	@Column(name="LastUpdate")
	private String lastUpdate;
	
	@Column(name="SystemAdmin")
	private String systemAdmin;
	
	@Column(name="SystemAdminEmployeeID")
	private String systemAdminEmployeeID;
	
	@Column(name="DRRelationshipManager")
	private String dRRelationshipManager;
	
	@Column(name="DRRelationshipManagerEmployeeID")
	private String dRRelationshipManagerEmployeeID;
	
	
	@Column(name="MainPlatform")
	private String mainPlatform;
	
	
	@Column(name="NetworkExposure")
	private String networkExposure;
	
	@Column(name="RTO")
	private String rTO;
	
	
	@Column(name="Location")
	private String location;

	
	
	@Column(name="os")
	private String oS;
	
	
	
	
	@Column(name="VersionId")
	private int versionId;








	public int getOrgId() {
		return orgId;
	}




	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}




	public String getLastUpdate() {
		return lastUpdate;
	}




	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}




	public String getSystemAdmin() {
		return systemAdmin;
	}




	public void setSystemAdmin(String systemAdmin) {
		this.systemAdmin = systemAdmin;
	}




	public String getSystemAdminEmployeeID() {
		return systemAdminEmployeeID;
	}




	public void setSystemAdminEmployeeID(String systemAdminEmployeeID) {
		this.systemAdminEmployeeID = systemAdminEmployeeID;
	}




	public String getdRRelationshipManager() {
		return dRRelationshipManager;
	}




	public void setdRRelationshipManager(String dRRelationshipManager) {
		this.dRRelationshipManager = dRRelationshipManager;
	}




	public String getdRRelationshipManagerEmployeeID() {
		return dRRelationshipManagerEmployeeID;
	}




	public void setdRRelationshipManagerEmployeeID(String dRRelationshipManagerEmployeeID) {
		this.dRRelationshipManagerEmployeeID = dRRelationshipManagerEmployeeID;
	}




	public String getMainPlatform() {
		return mainPlatform;
	}




	public void setMainPlatform(String mainPlatform) {
		this.mainPlatform = mainPlatform;
	}




	public String getNetworkExposure() {
		return networkExposure;
	}




	public void setNetworkExposure(String networkExposure) {
		this.networkExposure = networkExposure;
	}




	public String getrTO() {
		return rTO;
	}




	public void setrTO(String rTO) {
		this.rTO = rTO;
	}




	public String getLocation() {
		return location;
	}




	public void setLocation(String location) {
		this.location = location;
	}




	public String getoS() {
		return oS;
	}




	public void setoS(String oS) {
		this.oS = oS;
	}




	public int getVersionId() {
		return versionId;
	}




	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}
	
	
	
}

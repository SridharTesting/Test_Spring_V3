package com.slk.dsl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="fhn_infrastructure_data")
public class fhn_infrastructure_dataTable {


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

	public String getrTO() {
		return rTO;
	}

	public void setrTO(String rTO) {
		this.rTO = rTO;
	}

	public String getoS() {
		return oS;
	}

	public void setoS(String oS) {
		this.oS = oS;
	}

	@Id
	@Column(name="appId")
	private int appId;
	
	 public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	@Column(name="AppSystem")
		private String appSystem;
	 
	
	public String getAppSystem() {
		return appSystem;
	}


	public void setAppSystem(String appSystem) {
		this.appSystem = appSystem;
	}

	
	@Column(name="orgId")
	private int orgId;
	
	@Column(name="LastUpdate")
	private String lastUpdate;
	
	@Column(name="SystemAdmin")
	private String systemAdmin;
	
	@Column(name="SystemAdminEmployeeID")
	private String SystemAdminEmployeeID;
	
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
	
	@Column(name="OS")
	private String oS;
	
	@Column(name="Location")
	private String location;

	public fhn_infrastructure_dataTable () {}
	

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

	
	public String getDRelationshipManager() {
		return dRRelationshipManager;
	}

	public void setDRelationshipManager(String dRelationshipManager) {
		this.dRRelationshipManager = dRelationshipManager;
	}

	public String getDRelationshipManagerEmployeeID() {
		return dRRelationshipManagerEmployeeID;
	}

	public void setDRelationshipManagerEmployeeID(String dRelationshipManagerEmployeeID) {
		this.dRRelationshipManagerEmployeeID = dRelationshipManagerEmployeeID;
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

	public String getRTO() {
		return rTO;
	}

	public void setRTO(String rTO) {
		this.rTO = rTO;
	}

	public String getOS() {
		return oS;
	}

	public void setOS(String oS) {
		this.oS = oS;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "fhn_infrastructure_dataTable [appId=" + appId + ", orgId=" + orgId + ", lastUpdate=" + lastUpdate
				+ ", systemAdmin=" + systemAdmin + ", systemAdminEmployeeID=" + SystemAdminEmployeeID
				+ ", dRRelationshipManager=" + dRRelationshipManager + ", dRRelationshipManagerEmployeeID="
				+ dRRelationshipManagerEmployeeID + ", mainPlatform=" + mainPlatform + ", networkExposure="
				+ networkExposure + ", rTO=" + rTO + ", oS=" + oS + ", location=" + location + "]";
	}

	public String getSystemAdminEmployeeID() {
		return SystemAdminEmployeeID;
	}

	public void setSystemAdminEmployeeID(String systemAdminEmployeeID) {
		SystemAdminEmployeeID = systemAdminEmployeeID;
	}
	
	
	
}

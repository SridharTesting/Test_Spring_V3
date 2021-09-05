package com.slk.dsl.model;


	


	import javax.persistence.Column;
	import javax.persistence.Entity;
	
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity

	@Table(name="fhn_infrastructure_data")
	public class InfrastructureQuestionsUpload {


	
		@Id
		@Column(name="appId")
		private String appId;
		
		 @Column(name="AppSystem")
			private String AppSystem;
		 
		
		
		@Column(name="orgId")
		private int orgId;
		
		@Column(name="LastUpdate")
		private String LastUpdate;
		
		@Column(name="SystemAdmin")
		private String SystemAdmin;
		
		@Column(name="SystemAdminEmployeeID")
		private String SystemAdminEmployeeID;
		
		@Column(name="DRRelationshipManager")
		private String DRRelationshipManager;
		
		@Column(name="DRRelationshipManagerEmployeeID")
		private String DRRelationshipManagerEmployeeID;
		
		@Column(name="MainPlatform")
		private String MainPlatform;
		
		@Column(name="NetworkExposure")
		private String NetworkExposure;
		
		@Column(name="RTO")
		private String RTO;
		
		public String getAppId() {
			return appId;
		}

		public void setAppId(String appId) {
			this.appId = appId;
		}

		public String getAppSystem() {
			return AppSystem;
		}

		public void setAppSystem(String appSystem) {
			AppSystem = appSystem;
		}

		public int getOrgId() {
			return orgId;
		}

		public void setOrgId(int orgId) {
			this.orgId = orgId;
		}

		public String getLastUpdate() {
			return LastUpdate;
		}

		public void setLastUpdate(String lastUpdate) {
			LastUpdate = lastUpdate;
		}

		public String getSystemAdmin() {
			return SystemAdmin;
		}

		public void setSystemAdmin(String systemAdmin) {
			SystemAdmin = systemAdmin;
		}

		public String getSystemAdminEmployeeID() {
			return SystemAdminEmployeeID;
		}

		public void setSystemAdminEmployeeID(String systemAdminEmployeeID) {
			SystemAdminEmployeeID = systemAdminEmployeeID;
		}

		public String getDRRelationshipManager() {
			return DRRelationshipManager;
		}

		public void setDRRelationshipManager(String dRRelationshipManager) {
			DRRelationshipManager = dRRelationshipManager;
		}

		public String getDRRelationshipManagerEmployeeID() {
			return DRRelationshipManagerEmployeeID;
		}

		public void setDRRelationshipManagerEmployeeID(String dRRelationshipManagerEmployeeID) {
			DRRelationshipManagerEmployeeID = dRRelationshipManagerEmployeeID;
		}

		public String getMainPlatform() {
			return MainPlatform;
		}

		public void setMainPlatform(String mainPlatform) {
			MainPlatform = mainPlatform;
		}

		public String getNetworkExposure() {
			return NetworkExposure;
		}

		public void setNetworkExposure(String networkExposure) {
			NetworkExposure = networkExposure;
		}

		public String getRTO() {
			return RTO;
		}

		public void setRTO(String rTO) {
			RTO = rTO;
		}

		public String getOS() {
			return OS;
		}

		public void setOS(String oS) {
			OS = oS;
		}

		public String getLocation() {
			return Location;
		}

		public void setLocation(String location) {
			Location = location;
		}

		@Column(name="OS")
		private String OS;
		
		@Column(name="Location")
		private String Location;

	public InfrastructureQuestionsUpload() {
			
		}
		

		
		
		
	}




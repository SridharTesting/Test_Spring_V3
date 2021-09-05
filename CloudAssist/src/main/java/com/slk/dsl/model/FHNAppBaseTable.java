package com.slk.dsl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="fhn_application_data")
public class FHNAppBaseTable {
	
		@Id
		@Column(name="appID")
		private String appId;
		
//		@Column(name="Migration_Strategy_Id")
//		private int Migration_Strategy_Id;
//		
//		public int getMigration_Strategy_Id() {
//			return Migration_Strategy_Id;
//		}
//		public void setMigration_Strategy_Id(int migration_Strategy_Id) {
//			Migration_Strategy_Id = migration_Strategy_Id;
//		}

		
		
		@Column(name="orgId")
		private int orgId;
		 public int getOrgId() {
			return orgId;
		}
		public void setOrgId(int orgId) {
			this.orgId = orgId;
		}



		@Column(name="AppSystem")
		private String appSystem;
		 
		@Column(name="Description")
		private String description;
		
		@Column(name="HoursofOp")
		private String hoursofOp;
		
		@Column(name="DataCatApp")
		private String dataCatApp;
		
		@Column(name="CustomerFacing")
		private String customerFacing;
		
		@Column(name="vendor")
		private String vendor;
	
		public String getVendor() {
			return vendor;
		}
		public void setVendor(String vendor) {
			this.vendor = vendor;
		}

		@Column(name="RTA")
		private String rta;
		
		@Column(name="RPO")
		private String rpo;
		@Column(name="RPA")
		private String rpa;
		@Column(name="VendorConfirmation")
		private String vendorConfirmation;
		
//		@Column(name="RLane_Strategy_Id")
//		private int RLane_Strategy_Id;
//		
//		
//		public int getRLane_Strategy_Id() {
//			return RLane_Strategy_Id;
//		}
//		public void setRLane_Strategy_Id(int rLane_Strategy_Id) {
//			RLane_Strategy_Id = rLane_Strategy_Id;
//		}
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
		public FHNAppBaseTable(  String appId, String appSystem, String description,
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
		
		
		
		public FHNAppBaseTable() {
			
		}
		
		
		
		
		

	

}

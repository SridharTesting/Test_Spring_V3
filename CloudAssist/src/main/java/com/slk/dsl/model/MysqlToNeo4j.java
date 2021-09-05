package com.slk.dsl.model;

import javax.persistence.Column;
import javax.persistence.Id;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity
public class MysqlToNeo4j{
	@Id
	@Property(name="App_ID")
	private String appId;
	
	 @Property(name="AppSystem")
	private String appSystem;
	 
	@Property(name="Description")
	private String description;
	
	@Property(name="Vendor")
	private String vendor;
	
	
	@Property(name="LastUpdate")
	private String lastUpdate;
	
	@Property(name="BusinessOwner")
	private String businessOwner;
	
	@Property(name="BusinessManager")
	private String businessManager;
	
	@Property(name="BusinessManagerEmployeeID")
	private String businessManagerEmployeeID;
	
	@Property(name="ETDirector")
	private String eTDirector;
	
	@Property(name="ETDirectorEmployeeID")
	private String eTDirectorEmployeeID;
	
	
	@Property(name="ETManager")
	private String eTManager;
	
	
	@Property(name="ETManagerEmployeeID")
	private String eTManagerEmployeeID;
	@Property(name="ETPrimaryTechnical")
	private String eTPrimaryTechnical;
	@Property(name="ETPrimaryTechnicalEmployeeID")
	private String eTPrimaryTechnicalEmployeeID;
	
	@Property(name="ETSecondaryTechnical")
	private String eTSecondaryTechnical;
	@Property(name="ETSecondaryTechnicalEmployeeID")
	private String eTSecondaryTechnicalEmployeeID;
	@Property(name="SystemAdmin")
	private String systemAdmin;
	
	
	@Property(name="SystemAdminEmployeeID")
	private String systemAdminEmployeeID;
	
	@Property(name="DRRelationshipManager")
	private String dRRelationshipManager;
	
	@Property(name="DRRelationshipManagerEmployeeID")
	private String dRRelationshipManagerEmployeeID;
	
	@Property(name="LOB")
	private String lob;
	@Property(name="MainPlatform")
	private String mainPlatform;
	@Property(name="NetworkExposure")
	private String networkExposure;
	
	@Property(name="SCName")
	private String scName;
	
	@Property(name="SoxCritical")
	private String soxCritical;
	
	@Property(name="HoursofOp")
	private String hoursofOp;
	
	@Property(name="DataCatApp")
	private String dataCatApp;
	
	@Property(name="CustomerFacing")
	private String customerFacing;
	
	@Property(name="QualityScore")
	private String qualityScore;
	
	@Property(name="RTO")
	private String rto;
	
	@Property(name="Domain")
	private String domain;
	
	@Property(name="ManagerCertification")
	private String managerCertification;
	
	@Property(name="OS")
	private String os;
	
	@Property(name="Location")
	private String location;
	
	@Property(name="ASP")
	private String asp;
	@Property(name="DRExerciseResults")
	private String dRExerciseResults;
	
	@Property(name="ApplicationDRPlan")
	private String applicationDRPlan;
	
	@Property(name="DRExerciseDate")
	private String dRExerciseDate;
	
	@Property(name="DRTier")
	private String dRTier;
	
	@Property(name="DRPlanDate")
	private String dRPlanDate;
	@Property(name="RTA")
	private String rta;
	
	@Property(name="RPO")
	private String rpo;
	@Property(name="RPA")
	private String rpa;
	@Property(name="VendorConfirmation")
	private String vendorConfirmation;
	
	
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
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getBusinessOwner() {
		return businessOwner;
	}
	public void setBusinessOwner(String businessOwner) {
		this.businessOwner = businessOwner;
	}
	public String getBusinessManager() {
		return businessManager;
	}
	public void setBusinessManager(String businessManager) {
		this.businessManager = businessManager;
	}
	public String getBusinessManagerEmployeeID() {
		return businessManagerEmployeeID;
	}
	public void setBusinessManagerEmployeeID(String businessManagerEmployeeID) {
		this.businessManagerEmployeeID = businessManagerEmployeeID;
	}
	public String geteTDirector() {
		return eTDirector;
	}
	public void seteTDirector(String eTDirector) {
		this.eTDirector = eTDirector;
	}
	public String geteTDirectorEmployeeID() {
		return eTDirectorEmployeeID;
	}
	public void seteTDirectorEmployeeID(String eTDirectorEmployeeID) {
		this.eTDirectorEmployeeID = eTDirectorEmployeeID;
	}
	public String geteTManager() {
		return eTManager;
	}
	public void seteTManager(String eTManager) {
		this.eTManager = eTManager;
	}
	public String geteTManagerEmployeeID() {
		return eTManagerEmployeeID;
	}
	public void seteTManagerEmployeeID(String eTManagerEmployeeID) {
		this.eTManagerEmployeeID = eTManagerEmployeeID;
	}
	public String geteTPrimaryTechnical() {
		return eTPrimaryTechnical;
	}
	public void seteTPrimaryTechnical(String eTPrimaryTechnical) {
		this.eTPrimaryTechnical = eTPrimaryTechnical;
	}
	public String geteTPrimaryTechnicalEmployeeID() {
		return eTPrimaryTechnicalEmployeeID;
	}
	public void seteTPrimaryTechnicalEmployeeID(String eTPrimaryTechnicalEmployeeID) {
		this.eTPrimaryTechnicalEmployeeID = eTPrimaryTechnicalEmployeeID;
	}
	public String geteTSecondaryTechnical() {
		return eTSecondaryTechnical;
	}
	public void seteTSecondaryTechnical(String eTSecondaryTechnical) {
		this.eTSecondaryTechnical = eTSecondaryTechnical;
	}
	public String geteTSecondaryTechnicalEmployeeID() {
		return eTSecondaryTechnicalEmployeeID;
	}
	public void seteTSecondaryTechnicalEmployeeID(String eTSecondaryTechnicalEmployeeID) {
		this.eTSecondaryTechnicalEmployeeID = eTSecondaryTechnicalEmployeeID;
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
	public String getLob() {
		return lob;
	}
	public void setLob(String lob) {
		this.lob = lob;
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
	public String getScName() {
		return scName;
	}
	public void setScName(String scName) {
		this.scName = scName;
	}
	public String getSoxCritical() {
		return soxCritical;
	}
	public void setSoxCritical(String soxCritical) {
		this.soxCritical = soxCritical;
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
	public String getQualityScore() {
		return qualityScore;
	}
	public void setQualityScore(String qualityScore) {
		this.qualityScore = qualityScore;
	}
	public String getRto() {
		return rto;
	}
	public void setRto(String rto) {
		this.rto = rto;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getManagerCertification() {
		return managerCertification;
	}
	public void setManagerCertification(String managerCertification) {
		this.managerCertification = managerCertification;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAsp() {
		return asp;
	}
	public void setAsp(String asp) {
		this.asp = asp;
	}
	public String getdRExerciseResults() {
		return dRExerciseResults;
	}
	public void setdRExerciseResults(String dRExerciseResults) {
		this.dRExerciseResults = dRExerciseResults;
	}
	public String getApplicationDRPlan() {
		return applicationDRPlan;
	}
	public void setApplicationDRPlan(String applicationDRPlan) {
		this.applicationDRPlan = applicationDRPlan;
	}
	public String getdRExerciseDate() {
		return dRExerciseDate;
	}
	public void setdRExerciseDate(String dRExerciseDate) {
		this.dRExerciseDate = dRExerciseDate;
	}
	public String getdRTier() {
		return dRTier;
	}
	public void setdRTier(String dRTier) {
		this.dRTier = dRTier;
	}
	public String getdRPlanDate() {
		return dRPlanDate;
	}
	public void setdRPlanDate(String dRPlanDate) {
		this.dRPlanDate = dRPlanDate;
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
	public MysqlToNeo4j(  String appId, String appSystem, String description,
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
		this.vendor = vendor;
		this.lastUpdate = lastUpdate;
		this.businessOwner = businessOwner;
		this.businessManager = businessManager;
		this.businessManagerEmployeeID = businessManagerEmployeeID;
		this.eTDirector = eTDirector;
		this.eTDirectorEmployeeID = eTDirectorEmployeeID;
		this.eTManager = eTManager;
		this.eTManagerEmployeeID = eTManagerEmployeeID;
		this.eTPrimaryTechnical = eTPrimaryTechnical;
		this.eTPrimaryTechnicalEmployeeID = eTPrimaryTechnicalEmployeeID;
		this.eTSecondaryTechnical = eTSecondaryTechnical;
		this.eTSecondaryTechnicalEmployeeID = eTSecondaryTechnicalEmployeeID;
		this.systemAdmin = systemAdmin;
		this.systemAdminEmployeeID = systemAdminEmployeeID;
		this.dRRelationshipManager = dRRelationshipManager;
		this.dRRelationshipManagerEmployeeID = dRRelationshipManagerEmployeeID;
		this.lob = lob;
		this.mainPlatform = mainPlatform;
		this.networkExposure = networkExposure;
		this.scName = scName;
		this.soxCritical = soxCritical;
		this.hoursofOp = hoursofOp;
		this.dataCatApp = dataCatApp;
		this.customerFacing = customerFacing;
		this.qualityScore = qualityScore;
		this.rto = rto;
		this.domain = domain;
		this.managerCertification = managerCertification;
		this.os = os;
		this.location = location;
		this.asp = asp;
		this.dRExerciseResults = dRExerciseResults;
		this.applicationDRPlan = applicationDRPlan;
		this.dRExerciseDate = dRExerciseDate;
		this.dRTier = dRTier;
		this.dRPlanDate = dRPlanDate;
		this.rta = rta;
		this.rpo = rpo;
		this.rpa = rpa;
		this.vendorConfirmation = vendorConfirmation;
	}
	
	
	
	public MysqlToNeo4j() {
		
	}
	
	
	
	
	


	
}

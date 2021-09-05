package com.slk.dsl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fhn_process_data")
public class FHN_Process_Data {
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
	@Column(name="BusinessOwner")
	private String businessOwner;
	
	@Column(name="BusinessManager")
	private String businessManager;
	@Column(name="BusinessOwnerEmployeeID")
	private String businessOwnerEmployeeID;
	
	@Column(name="BusinessManagerEmployeeID")
	private String businessManagerEmployeeID;
	@Column(name="ETDirector")
	private String eTDirector;
	
	@Column(name="ETDirectorEmployeeID")
	private String eTDirectorEmployeeID;
	
	
	@Column(name="ETManager")
	private String eTManager;
	
	
	@Column(name="ETManagerEmployeeID")
	private String eTManagerEmployeeID;
	@Column(name="ETPrimaryTechnical")
	private String eTPrimaryTechnical;
	@Column(name="ETPrimaryTechnicalEmployeeID")
	private String eTPrimaryTechnicalEmployeeID;
	
	@Column(name="ETSecondaryTechnical")
	private String eTSecondaryTechnical;
	@Column(name="ETSecondaryTechnicalEmployeeID")
	private String eTSecondaryTechnicalEmployeeID;
	
	@Column(name="LOB")
	private String lob;

	@Column(name="SCName")
	private String scName;
	@Column(name="QualityScore")
	private String qualityScore;
	@Column(name="Domain")
	private String domain;
	
	@Column(name="ManagerCertification")
	private String managerCertification;
	
	@Column(name="DRExerciseResults")
	private String dRExerciseResults;
	
	@Column(name="ApplicationDRPlan")
	private String applicationDRPlan;
	
	

	public int getOrgId() {
		return orgId;
	}

	
	public FHN_Process_Data() {
		
	}
	public FHN_Process_Data(int processId, int orgId, String businessOwner, String businessManager,
			String businessOwnerEmployeeID, String businessManagerEmployeeID, String eTDirector,
			String eTDirectorEmployeeID, String eTManager, String eTManagerEmployeeID, String eTPrimaryTechnical,
			String eTPrimaryTechnicalEmployeeID, String eTSecondaryTechnical, String eTSecondaryTechnicalEmployeeID,
			String lob, String scName, String qualityScore, String domain, String managerCertification,
			String dRExerciseResults, String applicationDRPlan, String dRExerciseDate, String dRTier,
			String dRPlanDate) {
		super();
		
		this.orgId = orgId;
		this.businessOwner = businessOwner;
		this.businessManager = businessManager;
		this.businessOwnerEmployeeID = businessOwnerEmployeeID;
		this.businessManagerEmployeeID = businessManagerEmployeeID;
		this.eTDirector = eTDirector;
		this.eTDirectorEmployeeID = eTDirectorEmployeeID;
		this.eTManager = eTManager;
		this.eTManagerEmployeeID = eTManagerEmployeeID;
		this.eTPrimaryTechnical = eTPrimaryTechnical;
		this.eTPrimaryTechnicalEmployeeID = eTPrimaryTechnicalEmployeeID;
		this.eTSecondaryTechnical = eTSecondaryTechnical;
		this.eTSecondaryTechnicalEmployeeID = eTSecondaryTechnicalEmployeeID;
		this.lob = lob;
		this.scName = scName;
		this.qualityScore = qualityScore;
		this.domain = domain;
		this.managerCertification = managerCertification;
		this.dRExerciseResults = dRExerciseResults;
		this.applicationDRPlan = applicationDRPlan;
		this.dRExerciseDate = dRExerciseDate;
		this.dRTier = dRTier;
		this.dRPlanDate = dRPlanDate;
	}

	

	public void setOrgId(int orgId) {
		this.orgId = orgId;
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

	public String getBusinessOwnerEmployeeID() {
		return businessOwnerEmployeeID;
	}

	public void setBusinessOwnerEmployeeID(String businessOwnerEmployeeID) {
		this.businessOwnerEmployeeID = businessOwnerEmployeeID;
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

	public String getLob() {
		return lob;
	}

	public void setLob(String lob) {
		this.lob = lob;
	}

	public String getScName() {
		return scName;
	}

	public void setScName(String scName) {
		this.scName = scName;
	}

	public String getQualityScore() {
		return qualityScore;
	}

	public void setQualityScore(String qualityScore) {
		this.qualityScore = qualityScore;
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

	@Column(name="DRExerciseDate")
	private String dRExerciseDate;
	
	@Column(name="DRTier")
	private String dRTier;
	
	@Column(name="DRPlanDate")
	private String dRPlanDate;


}

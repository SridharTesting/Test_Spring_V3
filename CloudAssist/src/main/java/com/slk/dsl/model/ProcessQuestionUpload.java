package com.slk.dsl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fhn_process_data")
public class ProcessQuestionUpload {
	@Id
	@Column(name="appId")
	private String appId;
	
	 @Column(name="AppSystem")
		private String AppSystem;
	

	@Column(name="orgId")
	private int orgId;
	@Column(name="BusinessOwner")
	private String BusinessOwner;
	
	@Column(name="BusinessManager")
	private String BusinessManager;
	@Column(name="BusinessOwnerEmployeeID")
	private String BusinessOwnerEmployeeID;
	
	@Column(name="BusinessManagerEmployeeID")
	private String BusinessManagerEmployeeID;
	@Column(name="ETDirector")
	private String ETDirector;
	
	@Column(name="ETDirectorEmployeeID")
	private String ETDirectorEmployeeID;
	
	
	@Column(name="ETManager")
	private String ETManager;
	
	
	@Column(name="ETManagerEmployeeID")
	private String ETManagerEmployeeID;
	@Column(name="ETPrimaryTechnical")
	private String ETPrimaryTechnical;
	@Column(name="ETPrimaryTechnicalEmployeeID")
	private String ETPrimaryTechnicalEmployeeID;
	
	@Column(name="ETSecondaryTechnical")
	private String ETSecondaryTechnical;
	@Column(name="ETSecondaryTechnicalEmployeeID")
	private String ETSecondaryTechnicalEmployeeID;
	
	@Column(name="LOB")
	private String LOB;

	@Column(name="SCName")
	private String SCName;
	@Column(name="QualityScore")
	private String QualityScore;
	@Column(name="Domain")
	private String Domain;
	
	@Column(name="ManagerCertification")
	private String ManagerCertification;
	
	@Column(name="DRExerciseResults")
	private String DRExerciseResults;
	
	@Column(name="ApplicationDRPlan")
	private String ApplicationDRPlan;
	@Column(name="DRExerciseDate")
	private String DRExerciseDate;
	
	

	

	@Column(name="DRTier")
	private String DRTier;
	
	@Column(name="DRPlanDate")
	private String DRPlanDate;

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

	public String getBusinessOwner() {
		return BusinessOwner;
	}

	public void setBusinessOwner(String businessOwner) {
		BusinessOwner = businessOwner;
	}

	public String getBusinessManager() {
		return BusinessManager;
	}

	public void setBusinessManager(String businessManager) {
		BusinessManager = businessManager;
	}

	public String getBusinessOwnerEmployeeID() {
		return BusinessOwnerEmployeeID;
	}

	public void setBusinessOwnerEmployeeID(String businessOwnerEmployeeID) {
		BusinessOwnerEmployeeID = businessOwnerEmployeeID;
	}

	public String getBusinessManagerEmployeeID() {
		return BusinessManagerEmployeeID;
	}

	public void setBusinessManagerEmployeeID(String businessManagerEmployeeID) {
		BusinessManagerEmployeeID = businessManagerEmployeeID;
	}

	public String getETDirector() {
		return ETDirector;
	}

	public void setETDirector(String eTDirector) {
		ETDirector = eTDirector;
	}

	public String getETDirectorEmployeeID() {
		return ETDirectorEmployeeID;
	}

	public void setETDirectorEmployeeID(String eTDirectorEmployeeID) {
		ETDirectorEmployeeID = eTDirectorEmployeeID;
	}

	public String getETManager() {
		return ETManager;
	}

	public void setETManager(String eTManager) {
		ETManager = eTManager;
	}

	public String getETManagerEmployeeID() {
		return ETManagerEmployeeID;
	}

	public void setETManagerEmployeeID(String eTManagerEmployeeID) {
		ETManagerEmployeeID = eTManagerEmployeeID;
	}

	public String getETPrimaryTechnical() {
		return ETPrimaryTechnical;
	}

	public void setETPrimaryTechnical(String eTPrimaryTechnical) {
		ETPrimaryTechnical = eTPrimaryTechnical;
	}

	public String getETPrimaryTechnicalEmployeeID() {
		return ETPrimaryTechnicalEmployeeID;
	}

	public void setETPrimaryTechnicalEmployeeID(String eTPrimaryTechnicalEmployeeID) {
		ETPrimaryTechnicalEmployeeID = eTPrimaryTechnicalEmployeeID;
	}

	public String getETSecondaryTechnical() {
		return ETSecondaryTechnical;
	}

	public void setETSecondaryTechnical(String eTSecondaryTechnical) {
		ETSecondaryTechnical = eTSecondaryTechnical;
	}

	public String getETSecondaryTechnicalEmployeeID() {
		return ETSecondaryTechnicalEmployeeID;
	}

	public void setETSecondaryTechnicalEmployeeID(String eTSecondaryTechnicalEmployeeID) {
		ETSecondaryTechnicalEmployeeID = eTSecondaryTechnicalEmployeeID;
	}

	public String getLOB() {
		return LOB;
	}

	public void setLOB(String lOB) {
		LOB = lOB;
	}

	public String getSCName() {
		return SCName;
	}

	public void setSCName(String sCName) {
		SCName = sCName;
	}

	public String getQualityScore() {
		return QualityScore;
	}

	public void setQualityScore(String qualityScore) {
		QualityScore = qualityScore;
	}

	public String getDomain() {
		return Domain;
	}

	public void setDomain(String domain) {
		Domain = domain;
	}

	public String getManagerCertification() {
		return ManagerCertification;
	}

	public void setManagerCertification(String managerCertification) {
		ManagerCertification = managerCertification;
	}

	public String getDRExerciseResults() {
		return DRExerciseResults;
	}

	public void setDRExerciseResults(String dRExerciseResults) {
		DRExerciseResults = dRExerciseResults;
	}

	public String getApplicationDRPlan() {
		return ApplicationDRPlan;
	}

	public void setApplicationDRPlan(String applicationDRPlan) {
		ApplicationDRPlan = applicationDRPlan;
	}

	public String getDRExerciseDate() {
		return DRExerciseDate;
	}

	public void setDRExerciseDate(String dRExerciseDate) {
		DRExerciseDate = dRExerciseDate;
	}

	public String getDRTier() {
		return DRTier;
	}

	public void setDRTier(String dRTier) {
		DRTier = dRTier;
	}

	public String getDRPlanDate() {
		return DRPlanDate;
	}

	public void setDRPlanDate(String dRPlanDate) {
		DRPlanDate = dRPlanDate;
	}
}

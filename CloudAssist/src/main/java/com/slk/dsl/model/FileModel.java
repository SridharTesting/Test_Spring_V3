package com.slk.dsl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="ca_app_master")
public class FileModel {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="App_Id")
	private int appId;
	
	public FileModel(int appId, String appSeq, String appName, String appDesc, int orgId, String lobDesc,
			String appCriticality, String vendorName, String appType, String appArchitecture, String hostingEnvironment,
			String programmingLanguage, String programmingLangVersion, String integrationType, String inboundInterface,
			String authentication, String challenges, String licenceModel, String retirementTimeline,
			String appserverHostname, String appserverOSVersion, String appserverIP, String webserverHostname,
			String webserverOSVersion, String webserverIP, String databaseserverHost, String databaseserverOSVersion,
			String databaseserverDBtype, String databaseserverDBVersion, String databaseserverDBInstance,
			String databaseServerVolume, String dataSecurity, String dataRetentionRequirements, String comments,
			Date recInsDt, Date recUpdDt,String outboundInterface,String databaseserverIP) {
		super();
		this.appId = appId;
		this.appSeq = appSeq;
		this.appName = appName;
		this.appDesc = appDesc;
		this.orgId = orgId;
		this.lobDesc = lobDesc;
		this.appCriticality = appCriticality;
		this.vendorName = vendorName;
		this.appType = appType;
		this.appArchitecture = appArchitecture;
		this.hostingEnvironment = hostingEnvironment;
		this.programmingLanguage = programmingLanguage;
		this.programmingLangVersion = programmingLangVersion;
		this.integrationType = integrationType;
		this.inboundInterface = inboundInterface;
		this.authentication = authentication;
		this.challenges = challenges;
		this.licenceModel = licenceModel;
		this.retirementTimeline = retirementTimeline;
		this.appserverHostname = appserverHostname;
		this.appserverOSVersion = appserverOSVersion;
		this.appserverIP = appserverIP;
		this.webserverHostname = webserverHostname;
		this.webserverOSVersion = webserverOSVersion;
		this.webserverIP = webserverIP;
		this.databaseserverHost = databaseserverHost;
		this.databaseserverOSVersion = databaseserverOSVersion;
		this.databaseserverDBtype = databaseserverDBtype;
		this.databaseserverDBVersion = databaseserverDBVersion;
		this.databaseserverDBInstance = databaseserverDBInstance;
		this.databaseServerVolume = databaseServerVolume;
		this.dataSecurity = dataSecurity;
		this.dataRetentionRequirements = dataRetentionRequirements;
		this.comments = comments;
		this.recInsDt = recInsDt;
		this.recUpdDt = recUpdDt;
		this.outboundInterface=outboundInterface;
		this.databaseserverIP=databaseserverIP;
	}
	public FileModel(MultipartFile file) {
		// TODO Auto-generated constructor stub
	}
	public FileModel() {
		// TODO Auto-generated constructor stub
	}
	@Column(name="App_Seq")
	private String appSeq;
	
	@Column(name="App_Name")
	private String appName;
	
	
	@Column(name="App_Desc")
	private String appDesc;
	
	@Column(name="Org_Id")
	private int orgId;
	
	@Column(name="LOB_Desc")
	private String lobDesc;
	
	@Column(name="Application_Criticality")
	private String appCriticality;
	
	@Column(name="Vendor_Name")
	private String vendorName;
	@Column(name="App_Type")
	private String appType;
	@Column(name="Application_Architecture")
	private String appArchitecture;
	@Column(name="Hosting_Environment")
	private String hostingEnvironment;
	@Column(name="Programming_Language")
	private String programmingLanguage;
	@Column(name="Programming_Language_Version")
	private String programmingLangVersion;
	@Column(name="Integration_Type")
	private String integrationType;
	
	@Column(name="Number_of_Inbound_Interface")
	private String inboundInterface;
	@Column(name="Authentication")
	private String authentication;
	@Column(name="Challenges_To_Move_To_Cloud")
	private String challenges;
	@Column(name="Licence_Model")
	private String licenceModel;
	@Column(name="Retirement_Timeline")
	private String retirementTimeline;
	@Column(name="AppServer_Hostname")
	private String appserverHostname;
	@Column(name="AppServer_OS_Version")
	private String appserverOSVersion;
	
	@Column(name="AppServer_IP")
	private String appserverIP;
	@Column(name="WebServer_Hostname")
	private String webserverHostname;
	@Column(name="WebServer_OS_Version")
	private String webserverOSVersion;
	@Column(name="WebServer_IP")
	private String webserverIP;
	@Column(name="DatabaseServer_Host")
	private String databaseserverHost;
	@Column(name="DatabaseServer_OS_Version")
	private String databaseserverOSVersion;
	@Column(name="DatabaseServer_DBtype")
	private String databaseserverDBtype;
	@Column(name="DatabaseServer_DBVersion")
	private String databaseserverDBVersion;
	@Column(name="DatabaseServer_IP")
	private String databaseserverIP;
	
	
	
	public String getDatabaseserverIP() {
		return databaseserverIP;
	}
	public void setDatabaseserverIP(String databaseserverIP) {
		this.databaseserverIP = databaseserverIP;
	}
	public String getOutboundInterface() {
		return outboundInterface;
	}
	public void setOutboundInterface(String outboundInterface) {
		this.outboundInterface = outboundInterface;
	}
	@Column(name="DatabaseServer_DBInsatance")
	private String databaseserverDBInstance;
	@Column(name="DatabaseServer_Volume")
	private String databaseServerVolume;
	@Column(name="DatabaseServer_Data_Security")
	private String dataSecurity;
	
	@Column(name="Number_of_Oubound_Interface")
	private String outboundInterface;
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public String getAppSeq() {
		return appSeq;
	}
	public void setAppSeq(String appSeq) {
		this.appSeq = appSeq;
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
	public String getLobDesc() {
		return lobDesc;
	}
	public void setLobDesc(String lobDesc) {
		this.lobDesc = lobDesc;
	}
	public String getAppCriticality() {
		return appCriticality;
	}
	public void setAppCriticality(String appCriticality) {
		this.appCriticality = appCriticality;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getAppType() {
		return appType;
	}
	public void setAppType(String appType) {
		this.appType = appType;
	}
	public String getAppArchitecture() {
		return appArchitecture;
	}
	public void setAppArchitecture(String appArchitecture) {
		this.appArchitecture = appArchitecture;
	}
	public String getHostingEnvironment() {
		return hostingEnvironment;
	}
	public void setHostingEnvironment(String hostingEnvironment) {
		this.hostingEnvironment = hostingEnvironment;
	}
	public String getProgrammingLanguage() {
		return programmingLanguage;
	}
	public void setProgrammingLanguage(String programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}
	public String getProgrammingLangVersion() {
		return programmingLangVersion;
	}
	public void setProgrammingLangVersion(String programmingLangVersion) {
		this.programmingLangVersion = programmingLangVersion;
	}
	public String getIntegrationType() {
		return integrationType;
	}
	public void setIntegrationType(String integrationType) {
		this.integrationType = integrationType;
	}
	public String getInboundInterface() {
		return inboundInterface;
	}
	public void setInboundInterface(String inboundInterface) {
		this.inboundInterface = inboundInterface;
	}
	public String getAuthentication() {
		return authentication;
	}
	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}
	public String getChallenges() {
		return challenges;
	}
	public void setChallenges(String challenges) {
		this.challenges = challenges;
	}
	public String getLicenceModel() {
		return licenceModel;
	}
	public void setLicenceModel(String licenceModel) {
		this.licenceModel = licenceModel;
	}
	public String getRetirementTimeline() {
		return retirementTimeline;
	}
	public void setRetirementTimeline(String retirementTimeline) {
		this.retirementTimeline = retirementTimeline;
	}
	public String getAppserverHostname() {
		return appserverHostname;
	}
	public void setAppserverHostname(String appserverHostname) {
		this.appserverHostname = appserverHostname;
	}
	public String getAppserverOSVersion() {
		return appserverOSVersion;
	}
	public void setAppserverOSVersion(String appserverOSVersion) {
		this.appserverOSVersion = appserverOSVersion;
	}
	public String getAppserverIP() {
		return appserverIP;
	}
	public void setAppserverIP(String appserverIP) {
		this.appserverIP = appserverIP;
	}
	public String getWebserverHostname() {
		return webserverHostname;
	}
	public void setWebserverHostname(String webserverHostname) {
		this.webserverHostname = webserverHostname;
	}
	public String getWebserverOSVersion() {
		return webserverOSVersion;
	}
	public void setWebserverOSVersion(String webserverOSVersion) {
		this.webserverOSVersion = webserverOSVersion;
	}
	public String getWebserverIP() {
		return webserverIP;
	}
	public void setWebserverIP(String webserverIP) {
		this.webserverIP = webserverIP;
	}
	public String getDatabaseserverHost() {
		return databaseserverHost;
	}
	public void setDatabaseserverHost(String databaseserverHost) {
		this.databaseserverHost = databaseserverHost;
	}
	public String getDatabaseserverOSVersion() {
		return databaseserverOSVersion;
	}
	public void setDatabaseserverOSVersion(String databaseserverOSVersion) {
		this.databaseserverOSVersion = databaseserverOSVersion;
	}
	public String getDatabaseserverDBtype() {
		return databaseserverDBtype;
	}
	public void setDatabaseserverDBtype(String databaseserverDBtype) {
		this.databaseserverDBtype = databaseserverDBtype;
	}
	public String getDatabaseserverDBVersion() {
		return databaseserverDBVersion;
	}
	public void setDatabaseserverDBVersion(String databaseserverDBVersion) {
		this.databaseserverDBVersion = databaseserverDBVersion;
	}
	public String getDatabaseserverDBInstance() {
		return databaseserverDBInstance;
	}
	public void setDatabaseserverDBInstance(String databaseserverDBInstance) {
		this.databaseserverDBInstance = databaseserverDBInstance;
	}
	public String getDatabaseServerVolume() {
		return databaseServerVolume;
	}
	public void setDatabaseServerVolume(String databaseServerVolume) {
		this.databaseServerVolume = databaseServerVolume;
	}
	public String getDataSecurity() {
		return dataSecurity;
	}
	public void setDataSecurity(String dataSecurity) {
		this.dataSecurity = dataSecurity;
	}
	public String getDataRetentionRequirements() {
		return dataRetentionRequirements;
	}
	public void setDataRetentionRequirements(String dataRetentionRequirements) {
		this.dataRetentionRequirements = dataRetentionRequirements;
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
	@Column(name="Data_Retention_Requirements")
	private String dataRetentionRequirements;
	@Column(name="comments")
	private String comments; 
	
	
	
	@Column(name="Rec_Ins_Dt")
	private Date recInsDt;
	@Column(name="Rec_Upd_Dt")
	private Date recUpdDt;
}

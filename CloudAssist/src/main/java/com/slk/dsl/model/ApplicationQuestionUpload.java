package com.slk.dsl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity

@Table(name="fhn_application_data")
public class ApplicationQuestionUpload {
	@Id
	@Column(name="appID")
	private String appId;
	
	
	@Column(name="orgId")
	private int orgId;
	 public int getOrgId() {
		return orgId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}



	@Column(name="AppSystem")
	private String AppSystem;
	 
	@Column(name="Description")
	private String Description;
	
	@Column(name="HoursofOp")
	private String HoursofOp;
	
	@Column(name="DataCatApp")
	private String DataCatApp;
	
	@Column(name="CustomerFacing")
	private String CustomerFacing;
	



	@Column(name="vendor")
	private String vendor;

	

	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}



	@Column(name="RTA")
	private String RTA;
	
	@Column(name="RPO")
	private String RPO;
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
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getHoursofOp() {
		return HoursofOp;
	}
	public void setHoursofOp(String hoursofOp) {
		HoursofOp = hoursofOp;
	}
	public String getDataCatApp() {
		return DataCatApp;
	}
	public void setDataCatApp(String dataCatApp) {
		DataCatApp = dataCatApp;
	}
	public String getCustomerFacing() {
		return CustomerFacing;
	}
	public void setCustomerFacing(String customerFacing) {
		CustomerFacing = customerFacing;
	}
	public String getRTA() {
		return RTA;
	}
	public void setRTA(String rTA) {
		RTA = rTA;
	}
	public String getRPO() {
		return RPO;
	}
	public void setRPO(String rPO) {
		RPO = rPO;
	}
	public String getRPA() {
		return RPA;
	}
	public void setRPA(String rPA) {
		RPA = rPA;
	}
	public String getVendorConfirmation() {
		return VendorConfirmation;
	}
	public void setVendorConfirmation(String vendorConfirmation) {
		VendorConfirmation = vendorConfirmation;
	}



	@Column(name="RPA")
	private String RPA;
	@Column(name="VendorConfirmation")
	private String VendorConfirmation;
}

package com.slk.dsl.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ca_app_master")
public class AppToLOBMapping {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="App_Id")
	private int appId;
	
	@Column(name="Org_Id")
	private int orgId;
	
	@Column(name="LOB_Desc")
	private String lobdesc;
	
	@Column(name="App_Type")
	private String apptype;
	
	@Column(name="App_Seq")
	private String appSeq;
	
	@Column(name="App_Name")
	private String appName;
	
	
	@Column(name="App_Desc")
	private String appDesc;
	
	@Column(name="Rec_Ins_Dt")
	private Date recInsDt;
	@Column(name="Rec_Upd_Dt")
	private Date recUpdDt;
	
	
	@OneToMany(targetEntity=AppLOBLinkingTable.class,cascade = {
	        CascadeType.ALL
	    })
	@JoinColumn(referencedColumnName = "App_Id")
private List<AppLOBLinkingTable> apps;
	
	
	public int getAppId() {
		return appId;
	}
	public int getOrgId() {
		return orgId;
	}
	public String getLOBDesc() {
		 if(lobdesc==null)
			return "null";
					return	lobdesc;
	}
	public String getAppType() {
		 if(lobdesc==null)
			return "null";
					return	apptype;
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
}

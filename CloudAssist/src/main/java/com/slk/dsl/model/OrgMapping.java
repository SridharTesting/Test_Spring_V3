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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="ca_org_master")
public class OrgMapping {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Org_Id",nullable = false, unique = true)
	private int orgId;
	
	@Column(name="Org_Name")
	private String orgName;
	@Column(name="Org_Type")
   private Boolean orgType;
	@Column(name="Org_Add")
	private String orgAdd;
	


	@Column(name="Org_Post_Cd")
	private String orgPostCd;
	@Column(name="Org_Cnt_Name")
	private String orgCntName;
	@Column(name="Org_Cnt_Num")
	private String orgCntNum;
	@Column(name="Org_Cnt_Mail")
	private String orgCntMail;
	
	
	@OneToMany(targetEntity=LOBMapping.class,cascade = {
	        CascadeType.ALL
	    })
	@JoinColumn(referencedColumnName = "Org_Id")
private List<LOB> lobs;
	
	public int getOrgId() {
		return orgId;
	}
	public OrgMapping(int orgId, String orgName, Boolean orgType, String orgAdd, String orgPostCd, String orgCntName,
			String orgCntNum, String orgCntMail, List<LOB> lobs, Date recInsDt, Date recUpdDt) {
		super();
		this.orgId = orgId;
		this.orgName = orgName;
		this.orgType = orgType;
		this.orgAdd = orgAdd;
		this.orgPostCd = orgPostCd;
		this.orgCntName = orgCntName;
		this.orgCntNum = orgCntNum;
		this.orgCntMail = orgCntMail;
		this.lobs = lobs;
		this.recInsDt = recInsDt;
		this.recUpdDt = recUpdDt;
	}
	public List<LOB> getLobs() {
		return lobs;
	}
	public void setLobs(List<LOB> lobs) {
		this.lobs = lobs;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
	public String getOrgAdd() {
		return orgAdd;
	}
	public void setOrgAdd(String orgAdd) {
		this.orgAdd = orgAdd;
	}
	public String getOrgPostCd() {
		return orgPostCd;
	}
	public void setOrgPostCd(String orgPostCd) {
		this.orgPostCd = orgPostCd;
	}
	public String getOrgCntName() {
		return orgCntName;
	}
	public void setOrgCntName(String orgCntName) {
		this.orgCntName = orgCntName;
	}
	
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public Boolean getOrgType() {
		return orgType;
	}
	public void setOrgType(Boolean orgType) {
		this.orgType = orgType;
	}
	public String getOrgCntNum() {
		return orgCntNum;
	}
	public void setOrgCntNum(String orgCntNum) {
		this.orgCntNum = orgCntNum;
	}
	public String getOrgCntMail() {
		return orgCntMail;
	}
	public void setOrgCntMail(String orgCntMail) {
		this.orgCntMail = orgCntMail;
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
	
	
	@Column(name="Rec_Ins_Dt")
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
	private Date recInsDt;
	@Column(name="Rec_Upd_Dt")
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
	private Date recUpdDt;
	
	
}

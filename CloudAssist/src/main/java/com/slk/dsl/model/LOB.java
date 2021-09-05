package com.slk.dsl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ca_lob_master")
public class LOB {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Lob_Id")
	private int lobId;
	
	public int getLobId() {
		return lobId;
	}
	public void setLobId(int lobId) {
		this.lobId = lobId;
	}
	@Column(name="Org_Id")
	private int orgId;
	
	public int getOrgId() {
		return orgId;
	}
	@Column(name="Lob_Name")
   private String lobName;
	
	@Column(name="Lob_Manager")
	private String lobManager;
	
	@Column(name="Rec_Ins_Dt")
	private Date recInsDt;
	@Column(name="Rec_Upd_Dt")
	private Date recUpdDt;
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="Org_Id",nullable=false) private Org org;
	 * 
	 * 
	 * 
	 * public Org getOrg() { return org; }
	 */
	
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
	public String getLobName() {
		return lobName;
	}
	public void setLobName(String lobName) {
		this.lobName = lobName;
	}
	public String getLobManager() {
		return lobManager;
	}
	public void setLobManager(String lobManager) {
		this.lobManager = lobManager;
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

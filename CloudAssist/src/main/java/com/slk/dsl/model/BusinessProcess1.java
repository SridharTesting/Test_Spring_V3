package com.slk.dsl.model;

import java.util.Date;

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
@Table(name="ca_buspro_level1")
public class BusinessProcess1 {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BusPro_Level1_Id",nullable = false, unique = true)
	private int busproLevel1Id;
	
	@Column(name="BusPro_Level1_Name")
    private String busproLevel1Name;
	@Column(name="BusPro_Level1_Desc")
	private String busproLevel1Desc;
	@Column(name="Org_Id")
	private int orgId;
	
	@OneToMany(targetEntity=LOBMapping.class,cascade = {
	        CascadeType.ALL
	    })
	@JoinColumn(referencedColumnName = "Org_Id")
	
	public int getBusproLevel1Id() {
		return busproLevel1Id;
	}
	public void setBusproLevel1Id(int busproLevel1Id) {
		this.busproLevel1Id = busproLevel1Id;
	}
	public String getBusproLevel1Name() {
		return busproLevel1Name;
	}
	public void setBusproLevel1Name(String busproLevel1Name) {
		this.busproLevel1Name = busproLevel1Name;
	}
	public String getBusproLevel1Desc() {
		return busproLevel1Desc;
	}
	public void setBusproLevel1Desc(String busproLevel1Desc) {
		this.busproLevel1Desc = busproLevel1Desc;
	}
	public int getOrgId() {
		return orgId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
	@Column(name="Rec_Ins_dt")
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
	private Date recInsDt;
	@Column(name="Rec_Upd_dt")
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
	private Date recUpdDt;
	
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

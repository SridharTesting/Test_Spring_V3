package com.slk.dsl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity

@Table(name="ca_lob_app")
public class AppLOBLinkingTable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LOB_App_ID")
	private int lobAppId;
	
	@Column(name="Lob_Id" ,columnDefinition = "Integer default 0")
	
	private Integer lobId;
	
	@Column(name="App_ID")
	private int appId;
	
	@Column(name="Rec_Ins_Dt")
	private Date recInsDt;
	@Column(name="Rec_Upd_Dt")
	private Date recUpdDt;
	public int getLobAppId() {
		return lobAppId;
	}
	
	public Integer getLobId() {
		return lobId;
	}

	public void setLobId(Integer lobId) {
		this.lobId = lobId;
	}

	public void setLobAppId(int lobAppId) {
		this.lobAppId = lobAppId;
	}

	public void setLobId(int lobId) {
		this.lobId = lobId;
	}
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
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

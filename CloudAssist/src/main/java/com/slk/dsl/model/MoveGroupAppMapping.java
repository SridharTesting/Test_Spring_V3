package com.slk.dsl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ca_movegroup_app_mapping")

public class MoveGroupAppMapping {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "Movegroup_App_Id")
	private int moveGroupAppID;
	
	@Column(name="Move_Group_Id")
	private int moveGroupID;
	
	@Column(name="App_Master_Id")
	private int appMasterId;
	
	@Column(name="Rec_Ins_Dt")
	private Date recInsDT;
	
	@Column(name="Rec_Upd_Dt")
	private Date recUpDT;
	
	
	public int getMoveGroupAppID() {
		return moveGroupAppID;
	}


	public void setMoveGroupAppID(int moveGroupAppID) {
		this.moveGroupAppID = moveGroupAppID;
	}


	public int getMoveGroupID() {
		return moveGroupID;
	}


	public void setMoveGroupID(int moveGroupID) {
		this.moveGroupID = moveGroupID;
	}


	public int getAppMasterId() {
		return appMasterId;
	}


	public void setAppMasterId(int appMasterId) {
		this.appMasterId = appMasterId;
	}


	public Date getRecInsDT() {
		return recInsDT;
	}


	public void setRecInsDT(Date recInsDT) {
		this.recInsDT = recInsDT;
	}


	public Date getRecUpDT() {
		return recUpDT;
	}


	public void setRecUpDT(Date recUpDT) {
		this.recUpDT = recUpDT;
	}


	

	
	
	    
}

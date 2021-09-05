package com.slk.dsl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Table(name="ca_move_group")
public class MoveGroup {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Move_Group_Id")
	private int moveGroupId;
	
	@Column(name="Org_Id")
	private int  orgId;
	
	@Column(name="Move_Group_Name")
	private String moveGroupName;
	
	@Column(name="Migration_Start_dt")
	private Date migrationStartdt;
	
	@Column(name="Migration_End_dt")
	private Date migrationEnddt;
	
	@Column(name="Rec_Ins_Dt")
	private Date recInsDt;
	
	@Column(name="Rec_Upd_Dt")
	private Date recUpdDt;

	public int getMoveGroupId() {
		return moveGroupId;
	}

	public void setMoveGroupId(int moveGroupId) {
		this.moveGroupId = moveGroupId;
	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public String getMoveGroupName() {
		return moveGroupName;
	}

	public void setMoveGroupName(String moveGroupName) {
		this.moveGroupName = moveGroupName;
	}

	public Date getMigrationStartdt() {
		return migrationStartdt;
	}

	public void setMigrationStartdt(Date migrationStartdt) {
		this.migrationStartdt = migrationStartdt;
	}

	public Date getMigrationEnddt() {
		return migrationEnddt;
	}

	public void setMigrationEnddt(Date migrationEnddt) {
		this.migrationEnddt = migrationEnddt;
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

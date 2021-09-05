package com.slk.dsl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="ca_usr_tbl")

public class DAOUser {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Usr_Id")
	private int Usr_Id;
	
	@Column(name="Lob_Id")
	private int lobId;
	@Column(name="Email_Id")
   private String email;
	@Column(name="Password")
	private String password;
	@Column(name="First_Name")
	private String firstName;
	@Column(name="Last_Name")
	private String lastName;
	@Column(name="Rec_Type")
	private Boolean recType;
	@Column(name="Rec_Ins_Dt")
	private Date recInsDt;
	@Column(name="Rec_Upd_Dt")
	private Date recUpdDt;
	public int getUser_role_id() {
		return user_role_id;
	}
	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}
	@Column(name="user_role_id")
	private int user_role_id;
	
	public int getUsr_Id() {
		return Usr_Id;
	}
	public void setUsr_Id(int usr_Id) {
		Usr_Id = usr_Id;
	}
	public int getLobId() {
		return lobId;
	}
	public void setLobId(int lobId) {
		this.lobId = lobId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Boolean getRecType() {
		return recType;
	}
	public void setRecType(Boolean recType) {
		this.recType = recType;
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
package com.slk.dsl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name="ca_usr_tbl")
public class UserSetup {
	

		@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="Usr_Id",nullable = false, unique = true)
		private int userId;
		
		
		@Column(name="user_role_id",nullable = false)
		private int user_role_id;
		
		public int getUser_role_id() {
			return user_role_id;
		}
		public void setUser_role_id(int user_role_id) {
			this.user_role_id = user_role_id;
		}
		@Column(name="Lob_Id")
		private int lobId;
		@Column(name="Email_Id")
	   private String emailId;
		@Column(name="Password")
		private String password;
		@Column(name="First_Name")
		private String firstName;
		@Column(name="Last_Name")
		private String lastName;
		@Column(name="Rec_Type")
		private boolean recType;
		
		
		@Column(name="Rec_Ins_Dt")
		@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
		private Date recInsDt;
		@Column(name="Rec_Upd_Dt")
		@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
		private Date recUpdDt;
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public int getLobId() {
			return lobId;
		}
		public void setLobId(int lobId) {
			this.lobId = lobId;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
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
		public boolean isRecType() {
			return recType;
		}
		public void setRecType(boolean recType) {
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

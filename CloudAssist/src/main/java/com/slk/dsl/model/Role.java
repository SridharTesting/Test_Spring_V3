package com.slk.dsl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ca_user_role")
public class Role {
	@Id 
	@Column(name="user_role_id")
	public int UserRoleId;
	
	@Column(name="user_role_type")
	public String UserRoleType;
	
	@Column(name="user_role_description")
	public String UserRoleDescription;
	
	public int getUserRoleId() {
		return UserRoleId;
	}
	public void setUserRoleId(int userRoleId) {
		UserRoleId = userRoleId;
	}
	public String getUserRoleType() {
		return UserRoleType;
	}
	public void setUserRoleType(String userRoleType) {
		UserRoleType = userRoleType;
	}
	public String getUserRoleDescription() {
		return UserRoleDescription;
	}
	public void setUserRoleDescription(String userRoleDescription) {
		UserRoleDescription = userRoleDescription;
	}

	
}

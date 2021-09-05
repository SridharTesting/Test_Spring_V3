package com.slk.dsl.dto;


public class OrgNameDTO {
	String org_name;
	int Org_Id;
	int user_role_id;
	int Lob_Id;
	public int getUser_role_id() {
		return user_role_id;
	}
	public int getLob_Id() {
		return Lob_Id;
	}
	public void setLob_Id(int lob_Id) {
		Lob_Id = lob_Id;
	}
	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}
	public String getOrg_name() {
		return org_name;
	}
	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}
	public int getOrg_Id() {
		return Org_Id;
	}
	public void setOrg_Id(int org_Id) {
		Org_Id = org_Id;
	}


}

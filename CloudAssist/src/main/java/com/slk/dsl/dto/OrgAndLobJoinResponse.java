package com.slk.dsl.dto;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class OrgAndLobJoinResponse {

	
	public int getLobId() {
		return lobId;
	}

	public void setLobId(int lobId) {
		this.lobId = lobId;
	}
	private int lobId;
	private String orgName;
	private String lobName;
	private String lobManager;
	private int orgId;
	
	
	public OrgAndLobJoinResponse(int orgId,String orgName, String lobName, String lobManager,int lobId) {
		super();
		
		this.orgId=orgId;
		this.orgName = orgName;
		this.lobName = lobName;
		this.lobManager = lobManager;
		this.lobId=lobId;
	}
	
	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
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
}

package com.slk.dsl.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class BusinessProcess1AndOrgJoinResponse {

	public int getBusproLevel1Id() {
		return busproLevel1Id;
	}
	public void setBusproLevel1Id(int busproLevel1Id) {
		this.busproLevel1Id = busproLevel1Id;
	}
	
	private int busproLevel1Id;
	private String orgName;
	private String busproLevel1Name;
	private String busproLevel1Desc;
	private int orgId;
	
	public BusinessProcess1AndOrgJoinResponse(int orgId, String orgName, String busproLevel1Name,
			String busproLevel1Desc, int busproLevel1Id) {
		super();
		this.orgId = orgId;
		this.orgName = orgName;
		this.busproLevel1Name = busproLevel1Name;
		this.busproLevel1Desc = busproLevel1Desc;
		this.busproLevel1Id = busproLevel1Id;
	}
	
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
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
	
	
}

package com.slk.dsl.dto;

public class AddInfraDTO {
	int appMasterId;
	public int getAppMasterId() {
		return appMasterId;
	}
	public void setAppMasterId(int appMasterId) {
		this.appMasterId = appMasterId;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	String hostName;
	String ipAddress;
	int  orgId;
	int infraId;
	
	public int getInfraId() {
		return infraId;
	}
	public void setInfraId(int infraId) {
		this.infraId = infraId;
	}
	public int getOrgId() {
		return orgId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

}

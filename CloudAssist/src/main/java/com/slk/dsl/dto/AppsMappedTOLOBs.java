package com.slk.dsl.dto;

public class AppsMappedTOLOBs {
	private int appId;
	private String appName;
	private String appDesc;
	private String appChecked;
	public String getAppChecked() {
		return appChecked;
	}
	public void setAppChecked(String appChecked) {
		this.appChecked = appChecked;
	}
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public AppsMappedTOLOBs(int appId, String appName, String appDesc, String appChecked) {
		super();
		this.appId = appId;
		this.appName = appName;
		this.appDesc = appDesc;
		this.appChecked = appChecked;
	}
	public String getAppDesc() {
		return appDesc;
	}
	public AppsMappedTOLOBs() {
		super();
	}
	public void setAppDesc(String appDesc) {
		this.appDesc = appDesc;
	}
	

}

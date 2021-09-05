package com.slk.dsl.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class LOBAppLinking {
	
	private int appId;
	private String appDesc;
	
	public LOBAppLinking(int appId, String appDesc, Integer lobId, String appName) {
		super();
		this.appId = appId;
		this.appDesc = appDesc;
		this.lobId = lobId;
		this.appName = appName;
	}
	private Integer lobId;
	private String appName;
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public String getAppDesc() {
		return appDesc;
	}
	public void setAppDesc(String appDesc) {
		this.appDesc = appDesc;
	}
	
	
	
	public LOBAppLinking(int appId, String appDesc, Integer lobId) {
		super();
		this.appId = appId;
		this.appDesc = appDesc;
		this.lobId = lobId;
	}
	public Integer getLobId() {
		return lobId;
	}
	public void setLobId(Integer lobId) {
		this.lobId = lobId;
	}
	public LOBAppLinking(int appId, String appDesc) {
		super();
		this.appId = appId;
		this.appDesc = appDesc;
		
	}
	public LOBAppLinking(int appId, String appDesc, String appName) {
		super();
		this.appId = appId;
		this.appDesc = appDesc;
		this.appName = appName;
	}
	
	
	
	
	
}
	
	

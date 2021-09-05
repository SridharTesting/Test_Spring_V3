package com.slk.dsl.dto;

import java.io.Serializable;
import java.util.List;

import com.slk.dsl.model.ApplicationVersionData;
import com.slk.dsl.model.FHNAppVersionData;

public class ApplicationVersionDto  implements Serializable  {
	private int versionId;
	private List<ApplicationVersionData> appData;
	public int getVersionId() {
		return versionId;
	}
	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}
	public List<ApplicationVersionData> getAppData() {
		return appData;
	}
	public void setAppData(List<ApplicationVersionData> appData) {
		this.appData = appData;
	}
	
}
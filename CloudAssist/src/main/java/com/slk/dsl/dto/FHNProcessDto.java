package com.slk.dsl.dto;

import java.util.List;

import com.slk.dsl.model.FHN_Process_Data;

public class FHNProcessDto {
	List<FHN_Process_Data> processData;
	int orgId;
	public List<FHN_Process_Data> getProcessData() {
		return processData;
	}
	public void setProcessData(List<FHN_Process_Data> processData) {
		this.processData = processData;
	}
	public int getOrgId() {
		return orgId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

}

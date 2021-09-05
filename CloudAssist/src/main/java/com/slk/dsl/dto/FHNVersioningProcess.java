package com.slk.dsl.dto;

import java.io.Serializable;
import java.util.List;

import com.slk.dsl.model.FHN_Process_history_data;

public class FHNVersioningProcess implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int versionId;
private List<FHN_Process_history_data> processData;
public int getVersionId() {
	return versionId;
}
public void setVersionId(int versionId) {
	this.versionId = versionId;
}
public List<FHN_Process_history_data> getProcessData() {
	return processData;
}
public void setProcessData(List<FHN_Process_history_data> processData) {
	this.processData = processData;
}
}
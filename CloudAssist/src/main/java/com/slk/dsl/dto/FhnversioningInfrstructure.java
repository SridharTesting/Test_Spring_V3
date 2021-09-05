package com.slk.dsl.dto;

import java.io.Serializable;
import java.util.List;

import com.slk.dsl.model.Fhn_infra_data_history;



public class FhnversioningInfrstructure implements Serializable{
	private static final long serialVersionUID = 1L;
	private int versionId;
	private List<Fhn_infra_data_history> processData;
	public int getVersionId() {
		return versionId;
	}
	
	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}
	
	public List<Fhn_infra_data_history> getProcessData() {
		return processData;
	}
	public void setProcessData(List<Fhn_infra_data_history> processData) {
		this.processData = processData;
	}
}

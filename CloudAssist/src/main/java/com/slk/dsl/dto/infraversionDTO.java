package com.slk.dsl.dto;

import java.util.List;

import com.slk.dsl.model.ApplicationVersionData;
import com.slk.dsl.model.InfrastructureVersionData;

public class infraversionDTO {
	private int versionId;
	public int getVersionId() {
		return versionId;
	}
	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}
	public List<InfrastructureVersionData> getInfraData() {
		return infraData;
	}
	public void setInfraData(List<InfrastructureVersionData> infraData) {
		this.infraData = infraData;
	}
	private List<InfrastructureVersionData> infraData;
}

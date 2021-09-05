package com.slk.dsl.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.ParameterMode;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Table(name="versioning_table")
@NamedStoredProcedureQueries({ 
	@NamedStoredProcedureQuery(name = "getversions",procedureName="getversions",parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN,name = "org_name", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN,name = "viewId", type = int.class)}),
	@NamedStoredProcedureQuery
    (
	name="firststoredprocedure",
	procedureName="getversionforcomparision",
	parameters= 
        {
		@StoredProcedureParameter
		(mode=ParameterMode.IN,name="orgidp",type=int.class),
		@StoredProcedureParameter
		(mode=ParameterMode.IN,name="viewtype",type=int.class)
		}
	)})
public class Version_Table {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Versionid")
	private int versionId;
	
	





	public int getSelectview() {
		return selectview;
	}

	public void setSelectview(int selectview) {
		this.selectview = selectview;
	}





	@Column(name="selectview")
	private int selectview;
	

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



		
	 
	@Column(name="Description")
	private String description;
	
	@Column(name="Author")
	private String author;

	@Column(name="VersionNum")
	private String versionNum;

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getVersionNum() {
		return versionNum;
	}

	public void setVersionNum(String versionNum) {
		this.versionNum = versionNum;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
//		is not there
	}

	@Column(name="createdDate")
	private Date createdDate;
	@Column(name="orgId")
	private int orgId;


}

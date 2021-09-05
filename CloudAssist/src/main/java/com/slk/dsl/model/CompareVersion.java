package com.slk.dsl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="versioning_table")

public class CompareVersion {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Versionid")
	private int versionId;
	
	
	
	
	
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



		
	 
	@Column(name="Description")
	private String description;
	
	@Column(name="selectview")
	private int selectview;
	
	




	@Column(name="Author")
	private String author;

	@Column(name="VersionNum")
	private int versionNum;

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

	public int getVersionNum() {
		return versionNum;
	}

	public void setVersionNum(int versionNum) {
		this.versionNum = versionNum;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public int getSelectview() {
		return selectview;
	}

	public void setSelectview(int selectview) {
		this.selectview = selectview;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}





	@Column(name="createdDate")
	private Date createdDate;
	
	
	@Column(name="orgId")
	private int orgId;

	

}

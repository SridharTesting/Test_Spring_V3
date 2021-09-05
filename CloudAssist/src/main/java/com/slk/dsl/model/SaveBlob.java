package com.slk.dsl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="uploaded_files")
public class SaveBlob {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "fileId")
    private int fileId;
	

	
	
	public SaveBlob() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SaveBlob(int orgId, int viewtype, byte[] dataup, String uploaded_by, Date created_date, int is_active,
			String docType) {
		super();
		OrgId = orgId;
		Viewtype = viewtype;
		this.dataup = dataup;
		this.uploaded_by = uploaded_by;
		this.created_date = created_date;
		Is_active = is_active;
		this.docType = docType;
	}
	@Column(name = "OrgId")
	    private int OrgId;
		
	@Column(name = "Viewtype")
    private int Viewtype;
	
	@Lob
	@Column(name = "dataup")
    private byte[] dataup;
	
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public int getOrgId() {
		return OrgId;
	}
	public void setOrgId(int orgId) {
		OrgId = orgId;
	}
	public int getViewtype() {
		return Viewtype;
	}
	public void setViewtype(int viewtype) {
		Viewtype = viewtype;
	}
	public byte[] getDataup() {
		return dataup;
	}
	public void setDataup(byte[] dataup) {
		this.dataup = dataup;
	}
	public String getUploaded_by() {
		return uploaded_by;
	}
	public void setUploaded_by(String uploaded_by) {
		this.uploaded_by = uploaded_by;
	}
	
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public int getIs_active() {
		return Is_active;
	}
	public void setIs_active(int is_active) {
		Is_active = is_active;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	@Column(name = "uploaded_by")
    private String uploaded_by;
	@Column(name = "created_date")
    private Date created_date;
	
	@Column(name = "Is_active")
    private int Is_active;
	@Column(name = "docType")
    private String docType;
	
}

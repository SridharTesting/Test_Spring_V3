package com.slk.dsl.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="ca_org_survey_response")
public class QuestionerResponse {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="response_Id")
	int response_Id  ;
	@Column(name="org_Id")
	int org_Id  ;
	@Column(name="questioner_Id")
	int questioner_Id  ;
	@Column(name="questioner_Lkp_Id")
	int questioner_Lkp_Id;
	@Column(name="comments")
	String comments ;
	@Column(name="rec_Ins_Dt")
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	Date rec_Ins_Dt ;
	@Column(name="rec_Upd_Dt")
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	Date rec_Upd_Dt ;
	public int getResponse_Id() {
		return response_Id;
	}
	public void setResponse_Id(int response_Id) {
		this.response_Id = response_Id;
	}
	public int getOrg_Id() {
		return org_Id;
	}
	public void setOrg_Id(int org_Id) {
		this.org_Id = org_Id;
	}
	public int getQuestioner_Id() {
		return questioner_Id;
	}
	public void setQuestioner_Id(int questioner_Id) {
		this.questioner_Id = questioner_Id;
	}
	
	
	public int getQuestioner_Lkp_Id() {
		return questioner_Lkp_Id;
	}
	public void setQuestioner_Lkp_Id(int questioner_Lkp_Id) {
		this.questioner_Lkp_Id = questioner_Lkp_Id;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getRec_Ins_Dt() {
		return rec_Ins_Dt;
	}
	public void setRec_Ins_Dt(Date rec_Ins_Dt) {
		this.rec_Ins_Dt = rec_Ins_Dt;
	}
	public Date getRec_Upd_Dt() {
		return rec_Upd_Dt;
	}
	public void setRec_Upd_Dt(Date rec_Upd_Dt) {
		this.rec_Upd_Dt = rec_Upd_Dt;
	}
	
	
}

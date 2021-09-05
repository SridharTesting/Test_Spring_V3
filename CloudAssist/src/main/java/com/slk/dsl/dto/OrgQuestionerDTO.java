package com.slk.dsl.dto;

import java.math.BigInteger;

public class OrgQuestionerDTO {
	int questioner_Id;
	String questioner;
	String questioner_category;
	String questioner_values;
	int questioner_Lkp_Id;
	String response_Type;
	public int getQuestioner_Id() {
		return questioner_Id;
	}
	public void setQuestioner_Id(int questioner_Id) {
		this.questioner_Id = questioner_Id;
	}
	public String getQuestioner() {
		return questioner;
	}
	public void setQuestioner(String questioner) {
		this.questioner = questioner;
	}
	public String getQuestioner_category() {
		return questioner_category;
	}
	public void setQuestioner_category(String questioner_category) {
		this.questioner_category = questioner_category;
	}
	public String getQuestioner_values() {
		return questioner_values;
	}
	public void setQuestioner_values(String questioner_values) {
		this.questioner_values = questioner_values;
	}
	public int getQuestioner_Lkp_Id() {
		return questioner_Lkp_Id;
	}
	public void setQuestioner_Lkp_Id(int questioner_Lkp_Id) {
		this.questioner_Lkp_Id = questioner_Lkp_Id;
	}
	public String getResponse_Type() {
		return response_Type;
	}
	public void setResponse_Type(String response_Type) {
		this.response_Type = response_Type;
	}
	public String getSelected_val() {
		return selected_val;
	}
	public void setSelected_val(String selected_val) {
		this.selected_val = selected_val;
	}
	public int getQuestioner_Cat_Id() {
		return questioner_Cat_Id;
	}
	public void setQuestioner_Cat_Id(int questioner_Cat_Id) {
		this.questioner_Cat_Id = questioner_Cat_Id;
	}
	String selected_val;
	int questioner_Cat_Id;
}

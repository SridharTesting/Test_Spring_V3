package com.slk.dsl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="questioner_list")
public class QuestionerList {
	
	@Id
	@Column(name="question_Id")
	private int question_Id;
	
	public int getQuestion_Id() {
		return question_Id;
	}

	public void setQuestion_Id(int question_Id) {
		this.question_Id = question_Id;
	}

	public int getField_Id() {
		return field_Id;
	}

	public void setField_Id(int field_Id) {
		this.field_Id = field_Id;
	}

	public String getQuestioner() {
		return questioner;
	}

	public void setQuestioner(String questioner) {
		this.questioner = questioner;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	@Column(name="field_Id")
	private int field_Id;
	
	@Column(name="questioner")
	private String questioner;

	@Column(name="sequence")
	private int sequence;
}

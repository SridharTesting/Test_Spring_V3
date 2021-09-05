package com.slk.dsl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="field_lookup")
public class FieldLookup {

	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="field_Id",nullable = false, unique = true)
	private int field_Id;
	
	@Column(name="field_Name")
	private String field_Name;
	
	@Column(name="field_AliasName")
	private String field_AliasName;
	
	@Column(name="field_Description")
	private String field_Description;

	public int getField_Id() {
		return field_Id;
	}

	public void setField_Id(int field_Id) {
		this.field_Id = field_Id;
	}

	public String getField_Name() {
		return field_Name;
	}

	public void setField_Name(String field_Name) {
		this.field_Name = field_Name;
	}

	public String getField_AliasName() {
		return field_AliasName;
	}

	public void setField_AliasName(String field_AliasName) {
		this.field_AliasName = field_AliasName;
	}

	public String getField_Description() {
		return field_Description;
	}

	public void setField_Description(String field_Description) {
		this.field_Description = field_Description;
	}
	
	
}

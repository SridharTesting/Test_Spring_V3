package com.slk.dsl.model;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Table;

@Entity
@Table(name="ca_app_master")
public class override {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="App_Id")
	private int appId;
	
	
	@Column(name="RLane_Strategy_Id")
	private int RLane_Strategy_Id;
	
	
	@ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(name="InfraAppMappingTable",
	joinColumns={@JoinColumn(name="App_Master_Id")},
  inverseJoinColumns = {@JoinColumn(name="Infra_Id")})
	private Set<InfraDataModel> infra=new HashSet<>();

	
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	
	public int getRLane_Strategy_Id() {
		return RLane_Strategy_Id;
	}
	public void setRLane_Strategy_Id(int rLane_Strategy_Id) {
		RLane_Strategy_Id = rLane_Strategy_Id;
	}
	



}

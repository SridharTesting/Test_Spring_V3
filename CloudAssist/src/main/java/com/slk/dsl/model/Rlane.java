package com.slk.dsl.model;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="ca_rlane_strategy_lookup")

public class Rlane {
	
	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RLane_Strategy_Id",nullable = false, unique = true)
	private int RLane_Strategy_Id;
	
	@Column(name="RLane_Strategy")
	private String RLane_Strategy;

public int getRLane_Strategy_Id() {
		return RLane_Strategy_Id;
	}

	public void setRLane_Strategy_Id(int rLane_Strategy_Id) {
		RLane_Strategy_Id = rLane_Strategy_Id;
	}

	public String getRLane_Strategy() {
		return RLane_Strategy;
	}

	public void setRLane_Strategy(String rLane_Strategy) {
		RLane_Strategy = rLane_Strategy;
	}

	
}

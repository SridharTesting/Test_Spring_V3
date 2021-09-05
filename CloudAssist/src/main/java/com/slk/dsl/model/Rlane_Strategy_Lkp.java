package com.slk.dsl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ca_rlane_strategy_lookup")
public class Rlane_Strategy_Lkp {
	
	@Id
	@Column(name="RLane_Strategy_Id")
	private int RLane_Strategy_Id;
	
	@Column(name="Is_Active")
	private int Is_Active;
	
	public int getIs_Active() {
		return Is_Active;
	}

	public void setIs_Active(int is_Active) {
		Is_Active = is_Active;
	}

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

	@Column(name="RLane_Strategy")
	private String RLane_Strategy;
}

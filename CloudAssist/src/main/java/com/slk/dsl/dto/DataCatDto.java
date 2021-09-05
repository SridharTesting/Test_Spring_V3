package com.slk.dsl.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class DataCatDto {

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigInteger getNum() {
		return num;
	}
	public void setNum(BigInteger num) {
		this.num = num;
	}
	public String getMigration_Strategy() {
		return migration_Strategy;
	}
	public void setMigration_Strategy(String migration_Strategy) {
		this.migration_Strategy = migration_Strategy;
	}
	String name;
	BigInteger num;
	String migration_Strategy;
}

package com.slk.dsl.dto;

import java.math.BigInteger;

public class UserDashboardDTO {

	BigInteger total;
	BigInteger completed_survey;
	String lob_manager;
	BigInteger vendor_count;
	
	
	public String getLob_manager() {
		return lob_manager;
	}
	public void setLob_manager(String lob_manager) {
		this.lob_manager = lob_manager;
	}
	public BigInteger getTotal() {
		return total;
	}
	public void setTotal(BigInteger total) {
		this.total = total;
	}
	public BigInteger getCompleted_survey() {
		return completed_survey;
	}
	public void setCompleted_survey(BigInteger completed_survey) {
		this.completed_survey = completed_survey;
	}
	public BigInteger getVendor_count() {
		return vendor_count;
	}
	public void setVendor_count(BigInteger vendor_count) {
		this.vendor_count = vendor_count;
	}
	
}

package com.slk.dsl.dto;

public class LOBandUserJoinResponse {
	private int userId;
	private String lobName;
	private String firstName;
	private String lastName;
	private String emailId;
	private Integer lobId;
	public LOBandUserJoinResponse(int userId,Integer lobId,String lobName, String firstName, String lastName, String emailId) {
		super();
		this.userId=userId;
		this.lobId=lobId;
		this.lobName = lobName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Integer getLobId() {
		return lobId;
	}

	public void setLobId(Integer lobId) {
		this.lobId = lobId;
	}

	public String getLobName() {
		return lobName;
	}

	public void setLobName(String lobName) {
		this.lobName = lobName;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	

}

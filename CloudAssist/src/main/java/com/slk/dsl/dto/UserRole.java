package com.slk.dsl.dto;

public class UserRole {

	
private int Usr_Id;
private String Password;
	
	public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
	public int getUsr_Id() {
	return Usr_Id;
}
public void setUsr_Id(int usr_Id) {
	Usr_Id = usr_Id;
}
public int getLob_Id() {
	return Lob_Id;
}
public void setLob_Id(int lob_Id) {
	Lob_Id = lob_Id;
}
public String getLob_Name() {
	return Lob_Name;
}
public void setLob_Name(String lob_Name) {
	Lob_Name = lob_Name;
}
public String getFirst_Name() {
	return First_Name;
}
public void setFirst_Name(String first_Name) {
	First_Name = first_Name;
}
public String getLast_Name() {
	return Last_Name;
}
public void setLast_Name(String last_Name) {
	Last_Name = last_Name;
}
public String getEmail_Id() {
	return Email_Id;
}
public void setEmail_Id(String email_Id) {
	Email_Id = email_Id;
}
public String getUser_role_type() {
	return user_role_type;
}
public void setUser_role_type(String user_role_type) {
	this.user_role_type = user_role_type;
}
	private int Lob_Id;
private String Lob_Name;
	
	private String First_Name;
private String Last_Name;
	
	private String Email_Id;
private String user_role_type;
	

	
}


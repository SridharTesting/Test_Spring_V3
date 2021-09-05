package com.slk.dsl.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.slk.dsl.dto.Email_passwordDTO;
import com.slk.dsl.dto.OrgNameDTO;
import com.slk.dsl.dto.OsNamesDTO;
import com.slk.dsl.dto.UserRole;
import com.slk.dsl.dto.migrationdto;
import com.slk.dsl.model.Role;
import com.slk.dsl.model.UserSetup;
import com.slk.dsl.repository.RoleRepo;
import com.slk.dsl.repository.UserSetupDao;

import org.springframework.beans.factory.annotation.Value;
@Service
public class UserService {
	
	@Autowired
    private JavaMailSender mailSender;
	
	@Autowired
	UserSetupDao userRepo;
	@Autowired
	RoleRepo Repo;
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Value("${test}")
	private String url;

	
	public void updateUser(UserSetup userDetails) {

		String firstname =userDetails.getFirstName();
		String lastname =userDetails.getLastName();
		String email = userDetails.getEmailId();
		int lobid = userDetails.getLobId();
		int roleid = userDetails.getUser_role_id();
		int id = userDetails.getUserId();
		
		 userRepo.updateUser(firstname,lastname,email,lobid,roleid,id);
		
		
	}
	
	public UserSetup saveUser(UserSetup userDetails) {
		
		
		userDetails.setFirstName(userDetails.getFirstName());
		userDetails.setLastName(userDetails.getLastName());
		userDetails.setEmailId(userDetails.getEmailId());
		userDetails.setLobId(userDetails.getLobId());
		userDetails.setRecInsDt(userDetails.getRecInsDt());
		userDetails.setRecUpdDt(userDetails.getRecUpdDt());
		userDetails.setRecType(userDetails.isRecType());
		userDetails.setUser_role_id(userDetails.getUser_role_id());
//		userDetails.setPassword(bcryptEncoder.encode(userDetails.getPassword()));
		userDetails.setPassword(Base64.getEncoder().encodeToString(userDetails.getPassword().getBytes()));
		
		return userRepo.save(userDetails);
	}
	
	
	
	 public List<UserSetup> getUsers() {  
	        return userRepo.findAll();  
	    } 
 

	 
	 public List<Role> 	 getrolelist() {  
	        return Repo.findAll();  
	    } 
	 
	 
	 public Optional<UserSetup> getUserByID(int id) {
		 return userRepo.findById(id);
	 }
	 public void delete(int id) {
		 userRepo.deleteById(id);
	 }
	 
	 
 public void sendSimpleEmail(List<Email_passwordDTO> toEmail,
             
             String subject) {
		
		 

for(int i=0;i<toEmail.size();i++) {
	SimpleMailMessage message = new SimpleMailMessage();
	message.setTo(toEmail.get(i).getEmailid());
	 String body = "Welcome to Cloud Strategy Builder!\r\n"
			 + "\r\n"
				+ "Login details:\r\n"
				+ "You now have access to CSB application to take up the Application Survey, please log in to the "
				+ "Application at: "+url+"\r\n"
				+ "\r\n"
				+ "Use the below credentials (username and password) to access the site.\r\n"
				+ "\r\n"
				+ "Username: "+ toEmail.get(i).getEmailid()+"\r\n"
				+ "Password: "+ toEmail.get(i).getPassword() +"\r\n"
				+ "\r\n"
				+ "Thank you,\r\n"
				 + "\r\n"
				+ "This message is for informational purposes only. Please do not reply to this email.\r\n";
	 message.setText(body);
	 message.setSubject(subject);

	 mailSender.send(message);
}
 }

	 public List<OrgNameDTO> getorgname(String emailId) {  
		 List<Object[]> queryResult = userRepo.getorgname(emailId);
		 
		 List<OrgNameDTO> temp = new ArrayList<OrgNameDTO>();
		 queryResult.stream().forEach(object->{
			 OrgNameDTO obj = new OrgNameDTO();
			 obj.setOrg_name(object[0].toString());
			 obj.setOrg_Id((Integer)object[1]);
			 obj.setUser_role_id((Integer)object[2]);
			 obj.setLob_Id((Integer)object[3]);
			 temp.add(obj);
		 });
		 return temp;
		 }

	 
	 public List<migrationdto> loginvalidation() {  
		 List<Object[]> queryResult = userRepo.getuservalidation();
		 List<migrationdto> result = new ArrayList<migrationdto>();

		 queryResult.stream().forEach(objects->{
		 	migrationdto temp = new migrationdto();
		 	temp.setNum(BigInteger.valueOf((Integer)objects[0]));
		 	temp.setMigration_Strategy(objects[1].toString());
		 	result.add(temp);
		 	});
		 return result;
		 }
	 public List<UserRole> getLOBUserMapping(int orgId){
			List<Object[]> queryResult = userRepo.getLOBUserMapping(orgId);
			List<UserRole> usr = new ArrayList<UserRole>();
			queryResult.stream().forEach(object->{
				UserRole temp = new UserRole();
				temp.setUsr_Id((Integer)object[0]);
				temp.setLob_Id((Integer)object[1]);
				temp.setLob_Name(object[2].toString());
				temp.setFirst_Name(object[3].toString());
				temp.setLast_Name(object[4].toString());
				temp.setEmail_Id(object[5].toString());
				temp.setUser_role_type(object[6].toString());
				temp.setPassword(object[7].toString());
				usr.add(temp);
				
			});
			
			return usr;
			
		 }
	
	 
}

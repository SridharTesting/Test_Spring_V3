package com.slk.dsl.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.slk.dsl.model.DAOUser;
@Repository
public interface UserDao  extends JpaRepository<DAOUser, Integer>{
	

		//Email_ID from db
	
	DAOUser findByEmail(String email);
	
	
	String password = "select password from ca_usr_tbl where  email_id= :emailid";
	@Query(value = password, nativeQuery = true)
	public String getPasswordforUser(String emailid);



	
	
	
}

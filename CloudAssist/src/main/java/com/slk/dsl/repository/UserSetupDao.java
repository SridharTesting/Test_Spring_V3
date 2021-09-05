package com.slk.dsl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.slk.dsl.dto.LOBandUserJoinResponse;
import com.slk.dsl.dto.OrgNameDTO;
import com.slk.dsl.dto.migrationdto;
import com.slk.dsl.model.UserSetup;


@Repository
public interface UserSetupDao  extends JpaRepository<UserSetup, Integer>{
	
	
	String orgname = "select org_name ,cm.Org_Id,cu.user_role_id,cu.Lob_Id from ca_org_master cm\r\n"
			+ "			inner join ca_lob_master cl on cm.org_id=cl.Org_Id\r\n"
			+ "			inner join ca_usr_tbl cu on cu.Lob_Id = cl.Lob_Id\r\n"
			+ "			where cu.Email_Id= :emailId ;";
	@Query(value = orgname, nativeQuery = true)
	public List<Object[]> getorgname(String emailId);
	
	
	String uservalidation = "select user_role_id,Email_Id from ca_usr_tbl ;";
	@Query(value = uservalidation, nativeQuery = true)
	public List<Object[]> getuservalidation();
	
	
	
	String updateuser = "update ca_usr_tbl set first_name = :firstname,last_name = :lastname,email_id = :email, lob_id = :lobid,user_role_id = :roleid where usr_id= :id ";
	@Transactional
	@Modifying
	@Query(value = updateuser, nativeQuery = true)
	public void updateUser(String firstname,String lastname,String email,int lobid,int roleid,int id);
	
	
	String abc = "select cu.Usr_Id,cu.Lob_Id,lb.Lob_Name,cu.First_Name,cu.Last_Name,cu.Email_Id,ur.user_role_type,cu.Password from ca_usr_tbl cu \r\n"
			+ "		inner join ca_lob_master lb on lb.Lob_Id=cu.Lob_Id\r\n"
			+ "		inner join ca_user_role ur on cu.user_role_id = ur.user_role_id where lb.Org_Id=:orgId";
	@Query(value = abc, nativeQuery = true)
	public List<Object[]> getLOBUserMapping(int orgId);

}

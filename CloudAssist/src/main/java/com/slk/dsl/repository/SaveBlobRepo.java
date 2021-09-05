package com.slk.dsl.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.slk.dsl.model.Application;
import com.slk.dsl.model.FileModel;
import com.slk.dsl.model.SaveBlob;

@Repository
public interface SaveBlobRepo extends JpaRepository<SaveBlob,Integer >{
	
String ca_app_master = "select * From uploaded_files where fileId=:fileId  and OrgId=:orgId  ";
@Query(value = ca_app_master, nativeQuery = true)
public Optional<SaveBlob> getlatestfile(int fileId, int orgId);
	

}

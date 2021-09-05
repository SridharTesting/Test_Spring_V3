package com.slk.dsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slk.dsl.model.FileModel;

@Repository
public interface FileUploadDAO extends JpaRepository<FileModel,Integer > {

	

}

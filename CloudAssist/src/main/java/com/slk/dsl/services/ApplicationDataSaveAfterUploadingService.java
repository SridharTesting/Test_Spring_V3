package com.slk.dsl.services;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public interface ApplicationDataSaveAfterUploadingService {

	boolean saveAppDataFromUploadFile(MultipartFile file, int orgId) throws IOException ;
}

package com.slk.dsl.serviceImpl;


import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.aspectj.weaver.patterns.IScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.slk.dsl.model.FileModel;
import com.slk.dsl.model.InfraDataModel;
import com.slk.dsl.repository.FileUploadDAO;
import com.slk.dsl.repository.InfraDataUploadDAO;
import com.slk.dsl.services.FileStorageService; 
@Service

public class FileStorageImpl implements FileStorageService{
	
	
	@Autowired
	FileUploadDAO  repo;
	
	@Autowired
	InfraDataUploadDAO infraRepo;

	

	@Override
	public boolean saveDataFromUploadFile(MultipartFile file,String orgId) {
		
		boolean isFlag=false;
		
		isFlag=readDataFromExcel(file,orgId);
		
		return isFlag;
	}

	private boolean readDataFromExcel(MultipartFile file,String orgId) {
		// TODO Auto-generated method stub
		
		boolean FileUploaded=false;
		String fileNameWithOutExt = FilenameUtils.removeExtension(file.getOriginalFilename());
		 
if(fileNameWithOutExt.equalsIgnoreCase("app_sample_data") ) {
		Workbook workbook=getWorkbook(file);
Sheet sheet= workbook.getSheetAt(0);



System.out.println(sheet.getLastRowNum());

Iterator<Row> rows=sheet.iterator();

rows.next();
rows.next();

while(rows.hasNext() ) {
	
    

	
	Row row=rows.next(); 
	
	
	if (isCellEmpty(row.getCell(1))) {
        break;
    }
	
	FileModel files=new FileModel();
	
	files.setOrgId(Integer.parseInt(orgId));
	files.setAppSeq("1");
	files.setRecInsDt(new java.util.Date());
	files.setRecUpdDt(new java.util.Date());
	
	
	
	  
	  
	 
	if(row.getCell(1)!=null&&row.getCell(1).getCellType()==CellType.STRING) {
	files.setAppName(row.getCell(1).getStringCellValue());
	
	}
	
	if(row.getCell(2)!=null&& row.getCell(2).getCellType()==CellType.STRING) {
	files.setAppDesc(row.getCell(2).getStringCellValue());
	}
	if(row.getCell(3)!=null && row.getCell(3).getCellType()==CellType.STRING) {
	files.setLobDesc(row.getCell(3).getStringCellValue());
	}
	if( row.getCell(4)!=null &&row.getCell(4).getCellType()==CellType.STRING) {
	files.setAppCriticality(row.getCell(4).getStringCellValue());
	}
	
	
	if(row.getCell(5)!=null && row.getCell(5).getCellType()==CellType.STRING) {
	files.setVendorName(row.getCell(5).getStringCellValue());
	}
	if(row.getCell(6)!=null &&row.getCell(6).getCellType()==CellType.STRING) {
	files.setAppType(row.getCell(6).getStringCellValue());
	}
	if(row.getCell(7)!=null && row.getCell(7).getCellType()==CellType.STRING) {
	files.setAppArchitecture(row.getCell(7).getStringCellValue());
	}
	if(row.getCell(8)!=null && row.getCell(8).getCellType()==CellType.STRING) {
	files.setHostingEnvironment(row.getCell(8).getStringCellValue());
	}
	if(row.getCell(9)!=null && row.getCell(9).getCellType()==CellType.STRING) {
	files.setProgrammingLanguage(row.getCell(9).getStringCellValue());
	}
	if(row.getCell(10)!=null && row.getCell(10).getCellType()==CellType.NUMERIC) {
		String version=String.valueOf(row.getCell(10).getNumericCellValue());
	
	files.setProgrammingLangVersion(version);
	}
	if( row.getCell(11)!=null &&row.getCell(11).getCellType()==CellType.STRING) {
	files.setIntegrationType(row.getCell(11).getStringCellValue());
	}
	if(row.getCell(12)!=null && row.getCell(12).getCellType()==CellType.NUMERIC) {
		
		String inbound=String.valueOf(row.getCell(12).getNumericCellValue());
	files.setInboundInterface(inbound);
	}
	if(row.getCell(13)!=null && row.getCell(13).getCellType()==CellType.NUMERIC) {
		String outbound=String.valueOf(row.getCell(13).getNumericCellValue());
	files.setOutboundInterface(outbound);
	}
	if(row.getCell(14)!=null && row.getCell(14).getCellType()==CellType.STRING) {
	files.setAuthentication(row.getCell(14).getStringCellValue());
	}
	if(row.getCell(15)!=null && row.getCell(15).getCellType()==CellType.STRING) {
	files.setChallenges(row.getCell(15).getStringCellValue());
	}
	if(row.getCell(16)!=null && row.getCell(16).getCellType()==CellType.STRING) {
	files.setLicenceModel(row.getCell(16).getStringCellValue());
	}
	if(row.getCell(17)!=null && row.getCell(17).getCellType()==CellType.STRING) {
	files.setRetirementTimeline(row.getCell(17).getStringCellValue());
	}
	if(row.getCell(18)!=null && row.getCell(18).getCellType()==CellType.STRING) {
	files.setAppserverHostname(row.getCell(18).getStringCellValue());
	}
	if(row.getCell(19)!=null && row.getCell(19).getCellType()==CellType.STRING) {
	files.setAppserverOSVersion(row.getCell(19).getStringCellValue());
	}
	if(row.getCell(20)!=null &&row.getCell(20).getCellType()==CellType.STRING) {
	files.setAppserverIP(row.getCell(20).getStringCellValue());
	}
	if(row.getCell(21)!=null && row.getCell(21).getCellType()==CellType.STRING) {
	files.setWebserverHostname(row.getCell(21).getStringCellValue());
	}
	if(row.getCell(22)!=null &&row.getCell(22).getCellType()==CellType.STRING) {
	files.setWebserverOSVersion(row.getCell(22).getStringCellValue());
	}
	if(row.getCell(23)!=null &&row.getCell(23).getCellType()==CellType.STRING) {
	files.setWebserverIP(row.getCell(23).getStringCellValue());
	}
	if(row.getCell(24)!=null &&row.getCell(24).getCellType()==CellType.STRING) {
	files.setDatabaseserverHost(row.getCell(24).getStringCellValue());
	}
	if(row.getCell(25)!=null &&row.getCell(25).getCellType()==CellType.STRING) {
	files.setDatabaseserverOSVersion(row.getCell(25).getStringCellValue());
	}
	if(row.getCell(26)!=null &&row.getCell(26).getCellType()==CellType.STRING) {
	files.setDatabaseserverIP(row.getCell(26).getStringCellValue());
	}
	if(row.getCell(27)!=null &&row.getCell(27).getCellType()==CellType.STRING) {
	files.setDatabaseserverDBtype(row.getCell(27).getStringCellValue());
	}
	if(row.getCell(28)!=null &&row.getCell(28).getCellType()==CellType.STRING) {
	files.setDatabaseserverDBVersion(row.getCell(28).getStringCellValue());
	}
	if(row.getCell(29)!=null&&row.getCell(29).getCellType()==CellType.STRING  ) {
	files.setDatabaseserverDBInstance(row.getCell(29).getStringCellValue());
	}
	if(row.getCell(30)!=null &&row.getCell(30).getCellType()==CellType.STRING) {
	files.setDatabaseServerVolume(row.getCell(30).getStringCellValue());
	}
	if(row.getCell(31)!=null &&row.getCell(31).getCellType()==CellType.STRING) {
	files.setDataSecurity(row.getCell(31).getStringCellValue());
	}
	if(row.getCell(32)!=null &&row.getCell(32).getCellType()==CellType.STRING) {
	files.setDataRetentionRequirements(row.getCell(32).getStringCellValue());
	}
	if(row.getCell(33)!=null &&row.getCell(33).getCellType()==CellType.STRING) {
	files.setComments(row.getCell(33).getStringCellValue());
	}

	repo.save(files);
	
}
FileUploaded=true;
return FileUploaded;

		 }
		 
		 else if(fileNameWithOutExt.equalsIgnoreCase("Infra Discovery Data")) {
			 Workbook workbook=getWorkbook(file);
			 Sheet sheet= workbook.getSheetAt(0);



			 System.out.println(sheet.getLastRowNum());

			 Iterator<Row> rows=sheet.iterator();

			 rows.next();
			

			 while(rows.hasNext() ) {
			 	
			     

			 	
			 	Row row=rows.next(); 
			 	
			 	
			 	if (isCellEmpty(row.getCell(1)) ) {
			         break;
			     }
			 	
			 	InfraDataModel serverData=new InfraDataModel();
			 	
			 	
			 	serverData.setOrgId(Integer.parseInt(orgId));
			 	serverData.setRecInsDt(new java.util.Date());
			 	  
			 	 
			 	if( row.getCell(1)!=null&&row.getCell(1).getCellType()==CellType.STRING) {
			 		serverData.setHostName((row.getCell(1).getStringCellValue()));
			 	
			 	}
			 	
			 	if(row.getCell(2)!=null&& row.getCell(2).getCellType()==CellType.STRING) {
			 		serverData.setIpAddress(row.getCell(2).getStringCellValue());
			 	}
			 	if(row.getCell(3)!=null && row.getCell(3).getCellType()==CellType.STRING) {
			 		serverData.setHypervisor(row.getCell(3).getStringCellValue());
			 	}
			 	if( row.getCell(4)!=null &&row.getCell(4).getCellType()==CellType.STRING) {
			 		serverData.setOsType(row.getCell(4).getStringCellValue());
			 	}
			 	
			 	
			 	if(row.getCell(5)!=null && row.getCell(5).getCellType()==CellType.STRING) {
			 		serverData.setOsVersion(row.getCell(5).getStringCellValue());
			 	}
			 	if(row.getCell(6)!=null &&row.getCell(6).getCellType()==CellType.STRING) {
			 		serverData.setOsBitness(row.getCell(6).getStringCellValue());
			 	}
			 	if(row.getCell(7)!=null && row.getCell(7).getCellType()==CellType.STRING) {
			 		serverData.setPhysicalOrVirtual(row.getCell(7).getStringCellValue());
			 	}
			 	if(row.getCell(8)!=null && row.getCell(8).getCellType()==CellType.STRING) {
			 		serverData.setServerType(row.getCell(8).getStringCellValue());
			 	}
			 	if(row.getCell(9)!=null && row.getCell(9).getCellType()==CellType.STRING) {
			 		serverData.setEnvironment(row.getCell(9).getStringCellValue());
			 	}
			 	
			 	
			 	
			 	if(row.getCell(10)!=null && row.getCell(10).getCellType()==CellType.STRING) {
			 		serverData.setDataCenter(row.getCell(10).getStringCellValue());
			 	}
			 	if(row.getCell(11)!=null && row.getCell(11).getCellType()==CellType.STRING) {
			 		serverData.setBusinessUnit(row.getCell(11).getStringCellValue());
			 	}
			 	if(row.getCell(12)!=null && row.getCell(12).getCellType()==CellType.STRING) {
			 		serverData.setServerOwner(row.getCell(12).getStringCellValue());
			 	}
			 	if(row.getCell(13)!=null && row.getCell(13).getCellType()==CellType.STRING) {
			 		serverData.setInScope(row.getCell(13).getStringCellValue());
			 	}
			 	if(row.getCell(14)!=null && row.getCell(14).getCellType()==CellType.STRING) {
			 		serverData.setCpuType(row.getCell(14).getStringCellValue());
			 	}
			 	if(row.getCell(15)!=null && row.getCell(15).getCellType()==CellType.STRING) {
			 		serverData.setCpu(row.getCell(15).getStringCellValue());
			 	}
			 	if(row.getCell(16)!=null &&row.getCell(16).getCellType()==CellType.STRING) {
			 		serverData.setTotalCores(row.getCell(16).getStringCellValue());
			 	}
			 	if(row.getCell(17)!=null && row.getCell(17).getCellType()==CellType.STRING) {
			 		serverData.setMemory(row.getCell(17).getStringCellValue());
			 	}
			 	if(row.getCell(18)!=null &&row.getCell(18).getCellType()==CellType.STRING) {
			 		serverData.setDiskSize(row.getCell(18).getStringCellValue());
			 	}
			 	if(row.getCell(19)!=null &&row.getCell(19).getCellType()==CellType.STRING) {
			 		serverData.setDiskFreeSpace(row.getCell(19).getStringCellValue());
			 	}
			 	if(row.getCell(20)!=null &&row.getCell(20).getCellType()==CellType.STRING) {
			 		serverData.setAvgCpuUsage(row.getCell(20).getStringCellValue());
			 	}
			 	if(row.getCell(21)!=null &&row.getCell(21).getCellType()==CellType.STRING) {
			 		serverData.setAvgMemoryUsage(row.getCell(21).getStringCellValue());
			 	}
			 	if(row.getCell(22)!=null &&row.getCell(22).getCellType()==CellType.STRING) {
			 		serverData.setPeakCpuUsage(row.getCell(22).getStringCellValue());
			 	}
			 	if(row.getCell(23)!=null &&row.getCell(23).getCellType()==CellType.STRING) {
			 		serverData.setPeakMemoryUsage(row.getCell(23).getStringCellValue());
			 	}
			 	if(row.getCell(24)!=null &&row.getCell(24).getCellType()==CellType.STRING) {
			 		serverData.setAvarageStorageIOPS(row.getCell(24).getStringCellValue());
			 	}
			 	if(row.getCell(25)!=null&&row.getCell(25).getCellType()==CellType.STRING  ) {
			 		serverData.setPeakStorageIOPS(row.getCell(25).getStringCellValue());
			 	}
			 	if(row.getCell(26)!=null &&row.getCell(26).getCellType()==CellType.STRING) {
			 		serverData.setAvgStorageReadIOPS(row.getCell(26).getStringCellValue());
			 	}
			 	if(row.getCell(27)!=null &&row.getCell(27).getCellType()==CellType.STRING) {
			 		serverData.setAvgStorageWriteIOPS(row.getCell(27).getStringCellValue());
			 	}
			 	if(row.getCell(28)!=null &&row.getCell(28).getCellType()==CellType.STRING) {
			 		serverData.setPeakNetworkUsage(row.getCell(28).getStringCellValue());
			 	}
			 	if(row.getCell(29)!=null &&row.getCell(29).getCellType()==CellType.STRING) {
			 		serverData.setMaxNetworkUsageRate(row.getCell(29).getStringCellValue());
			 	}
			 	
			 	
			 	
			 	
			 	infraRepo.save(serverData);
			 	
			 }
			 FileUploaded=true;
				return FileUploaded;
			 	
			 }
			 
			
			 
		
return FileUploaded;

		

	}
	

	private boolean isRowEmpty(Row row1) {
		boolean isEmpty = true;
		DataFormatter dataFormatter = new DataFormatter();

		if (row1 != null) {
			for (Cell cell : row1) {
				if (dataFormatter.formatCellValue(cell).trim().length() > 0) {
					isEmpty = false;
					break;
				}
			}
		}

		return isEmpty;
	}

	private Workbook getWorkbook(MultipartFile file) {
		// TODO Auto-generated method stub
		
		
		Workbook workbook=null;
	 try {
		workbook=new XSSFWorkbook(file.getInputStream());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return workbook;
	}
	
	public static boolean isCellEmpty(final Cell cell) {
	    if (cell == null || cell.getCellType() == CellType.BLANK) {
	        return true;
	    }
	    if (cell.getCellType() == CellType.STRING && cell.getStringCellValue().isEmpty()) {
	        return true;
	    }
	    return false;
	}
	
	public static boolean isColumnEmpty(Sheet sheet, int columnIndex, int startRow) {
	    for (Row row : sheet) {
	        if (row.getRowNum() < startRow) continue;
	        Cell cell = row.getCell(columnIndex);
	        if (cell != null) {
	            return false;
	        }
	    }
	    return true;
	}
	
	

}

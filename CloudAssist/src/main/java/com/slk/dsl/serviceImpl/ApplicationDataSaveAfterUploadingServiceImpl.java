package com.slk.dsl.serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.slk.dsl.model.Application;
import com.slk.dsl.model.InfraAppMappingTable;
import com.slk.dsl.model.InfraDataModel;
import com.slk.dsl.model.LOB;
import com.slk.dsl.repository.ApplicationRepository;
import com.slk.dsl.repository.InfraApplicationMappingDAO;
import com.slk.dsl.repository.InfraDataUploadDAO;
import com.slk.dsl.repository.LOBRepo;
import com.slk.dsl.services.ApplicationDataSaveAfterUploadingService;



@Service

	public class ApplicationDataSaveAfterUploadingServiceImpl  implements ApplicationDataSaveAfterUploadingService{
		
		
		@Autowired
		ApplicationRepository repo;
		
		@Autowired
		 InfraApplicationMappingDAO mappingRepo;
		
		@Autowired
		LOBRepo repoLob;
		@Autowired
		InfraDataUploadDAO infraRepo;


		

		@Override
		public boolean saveAppDataFromUploadFile(MultipartFile file,int orgId) throws IOException {
			
			boolean isFlag=false;
			
			
			
			isFlag=readDataFromExcel(file,orgId);
			
			return isFlag;
		}

		private boolean readDataFromExcel(MultipartFile file,int orgId) throws IOException {
			// TODO Auto-generated method stub
			//int org_Id=Integer.parseInt(orgId);
			
			boolean FileUploaded=false;
			String fileNameWithOutExt = FilenameUtils.removeExtension(file.getOriginalFilename());
			 
	if(fileNameWithOutExt.equalsIgnoreCase("App Discovery Data") ) {
		
		
		//Delete ca_infra_mapping details,ca_infra_details and ca_app_master details
	
		
		
		
		List<Application>  appDet=new ArrayList<Application>();
		//List<InfraAppMappingTable> mapping=new ArrayList<InfraAppMappingTable>();

			Workbook workbook=getWorkbook(file);
	Sheet sheet= workbook.getSheetAt(0);
	
	

	System.out.println(sheet.getLastRowNum());

	Iterator<Row> rows=sheet.iterator();

	rows.next();


	while(rows.hasNext() ) {
		
	    
		long size=file.getSize();
		System.out.println("Intial file byte"+ size);
		
		Row row=rows.next(); 
		
		
		if (isCellEmpty(row.getCell(0))) {
	        break;
	    }
		LOB lob=new LOB();
		
		lob.setRecInsDt(new java.util.Date());
		lob.setRecUpdDt(new java.util.Date());
		lob.setOrgId(orgId);
		if(row.getCell(5)!=null&&row.getCell(5).getCellType()==CellType.STRING) {
			lob.setLobManager(row.getCell(5).getStringCellValue());
			
			}
		
		if(row.getCell(3)!=null&&row.getCell(3).getCellType()==CellType.STRING) {
			lob.setLobName(row.getCell(3).getStringCellValue());
			
			}
		
		
		

	List<Object[]> lobVal=repoLob.getlobDistinctValues(lob.getOrgId(), lob.getLobName());

		if(lobVal.isEmpty()) {
		//if lobval is null then save the record into db
			repoLob.save(lob);

			Application files=new Application();
			
			files.setOrgId(orgId);
			//files.setAppSeq("1");
			files.setRecInsDt(new java.util.Date());
			files.setRecUpdDt(new java.util.Date());
		
			files.setLobId(lob.getLobId());
				  
			  
			 
			if(row.getCell(0)!=null&&row.getCell(0).getCellType()==CellType.NUMERIC) {
				double appId= Double.parseDouble(row.getCell(0).toString());
				int applicationId=(int)appId;
				
				String appsId=String.valueOf(applicationId);
				//int appId=new BigDecimal(row.getCell(0).getNumericCellValue()).setScale(0,RoundingMode.HALF_UP).intValue();
			files.setAppId(appsId);
			}
			
			if(row.getCell(1)!=null&& row.getCell(1).getCellType()==CellType.STRING) {
			files.setAppName(row.getCell(1).getStringCellValue());
			}
			
			if(row.getCell(2)!=null&& row.getCell(2).getCellType()==CellType.STRING) {
				files.setAppDesc(row.getCell(2).getStringCellValue());
				}
			
			
			
			if(row.getCell(4)!=null &&row.getCell(4).getCellType()==CellType.STRING) {
			files.setAppManager(row.getCell(4).getStringCellValue());
			}
			if(row.getCell(6)!=null &&row.getCell(6).getCellType()==CellType.STRING) {
				files.setVendorName(row.getCell(6).getStringCellValue());
				}
			if(row.getCell(7)!=null &&row.getCell(7).getCellType()==CellType.STRING) {
				files.setDataCatApp(row.getCell(7).getStringCellValue());
				}
			if(row.getCell(8)!=null &&row.getCell(8).getCellType()==CellType.STRING) {
				files.setApplicationCriticality(row.getCell(8).getStringCellValue());
				}
			
			appDet.add(files);

			
		}
		else {
		//else just take the lobid from that record
			lobVal.stream().forEach(objects->{ 
				
				lob.setLobId((Integer) objects[0]);
			});	

			Application files=new Application();
			
			files.setOrgId(orgId);
			//files.setAppSeq("1");
			files.setRecInsDt(new java.util.Date());
			files.setRecUpdDt(new java.util.Date());
		
			files.setLobId(lob.getLobId());
				  
			  
			 
			if(row.getCell(0)!=null&&row.getCell(0).getCellType()==CellType.NUMERIC) {
				double appId= Double.parseDouble(row.getCell(0).toString());
				int applicationId=(int)appId;
				
				
				String appsId=String.valueOf(applicationId);
				
				
				
				//int appId=new BigDecimal(row.getCell(0).getNumericCellValue()).setScale(0,RoundingMode.HALF_UP).intValue();
			files.setAppId(appsId);
			}
			
			if(row.getCell(1)!=null&& row.getCell(1).getCellType()==CellType.STRING) {
			files.setAppName(row.getCell(1).getStringCellValue());
			}
			
			if(row.getCell(2)!=null&& row.getCell(2).getCellType()==CellType.STRING) {
				files.setAppDesc(row.getCell(2).getStringCellValue());
				}
			
			
			
			if(row.getCell(4)!=null &&row.getCell(4).getCellType()==CellType.STRING) {
			files.setAppManager(row.getCell(4).getStringCellValue());
			}
			if(row.getCell(6)!=null &&row.getCell(6).getCellType()==CellType.STRING) {
				files.setVendorName(row.getCell(6).getStringCellValue());
				}
			if(row.getCell(7)!=null &&row.getCell(7).getCellType()==CellType.STRING) {
				files.setDataCatApp(row.getCell(7).getStringCellValue());
				}
			if(row.getCell(8)!=null &&row.getCell(8).getCellType()==CellType.STRING) {
				files.setApplicationCriticality(row.getCell(8).getStringCellValue());
				}
		
			appDet.add(files);
			
			//if(repo.findAllById(appDet.get(0).getAppId()))
		}

		
		
		
		
		
	}
	
	//check if appId is already exist
	
	mappingRepo.deleteInfraMapping(orgId);
	infraRepo.deleteInfraMapping(orgId);
	repo.deleteApps(orgId);
	
	repo.saveAll(appDet);
	
	FileUploaded=true;
	return FileUploaded;

			 }
			 
			
				 
				
				 
	 else if(fileNameWithOutExt.equalsIgnoreCase("Infra Discovery Data")) {
			
			List<InfraDataModel>  infraDet=new ArrayList<InfraDataModel>();
			List<InfraAppMappingTable> mapping=new ArrayList<InfraAppMappingTable>();
		 Workbook workbook=getWorkbook(file);
	byte Bytes[]=file.getBytes();
		  
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
		 	
		 	
		 	serverData.setOrgId(orgId);
		 	serverData.setRecInsDt(new java.util.Date());
		 	  
		 	 
		 	if( row.getCell(0)!=null&&row.getCell(0).getCellType()==CellType.STRING) {
		 		serverData.setHostName((row.getCell(0).getStringCellValue()));
		 	
		 	}
		 	
		 	if(row.getCell(1)!=null&& row.getCell(1).getCellType()==CellType.STRING) {
		 		serverData.setIpAddress(row.getCell(1).getStringCellValue());
		 	}
		 	if(row.getCell(2)!=null && row.getCell(2).getCellType()==CellType.STRING) {
		 		serverData.setHypervisor(row.getCell(2).getStringCellValue());
		 	}
		 	if( row.getCell(3)!=null &&row.getCell(3).getCellType()==CellType.STRING) {
		 		serverData.setOsType(row.getCell(3).getStringCellValue());
		 	}
		 	
		 	
		 	if(row.getCell(4)!=null && row.getCell(4).getCellType()==CellType.STRING) {
		 		serverData.setOsVersion(row.getCell(4).getStringCellValue());
		 	}
		 	if(row.getCell(5)!=null &&row.getCell(5).getCellType()==CellType.STRING) {
		 		serverData.setOsBitness(row.getCell(5).getStringCellValue());
		 	}
		 	if(row.getCell(6)!=null && row.getCell(6).getCellType()==CellType.STRING) {
		 		serverData.setPhysicalOrVirtual(row.getCell(6).getStringCellValue());
		 	}
		 	if(row.getCell(7)!=null && row.getCell(7).getCellType()==CellType.STRING) {
		 		serverData.setServerType(row.getCell(7).getStringCellValue());
		 	}
		 	if(row.getCell(8)!=null && row.getCell(8).getCellType()==CellType.STRING) {
		 		serverData.setEnvironment(row.getCell(8).getStringCellValue());
		 	}
		 	
		 	
		 	
		 	if(row.getCell(9)!=null && row.getCell(9).getCellType()==CellType.STRING) {
		 		serverData.setDataCenter(row.getCell(9).getStringCellValue());
		 	}
		 	if(row.getCell(10)!=null && row.getCell(10).getCellType()==CellType.STRING) {
		 		serverData.setBusinessUnit(row.getCell(10).getStringCellValue());
		 	}
		 	if(row.getCell(11)!=null && row.getCell(11).getCellType()==CellType.STRING) {
		 		serverData.setServerOwner(row.getCell(11).getStringCellValue());
		 	}
		 	if(row.getCell(12)!=null && row.getCell(12).getCellType()==CellType.STRING) {
		 		serverData.setInScope(row.getCell(12).getStringCellValue());
		 	}
		 	if(row.getCell(13)!=null && row.getCell(13).getCellType()==CellType.STRING) {
		 		serverData.setCpuType(row.getCell(13).getStringCellValue());
		 	}
		 	if(row.getCell(14)!=null && row.getCell(14).getCellType()==CellType.STRING) {
		 		serverData.setCpu(row.getCell(14).getStringCellValue());
		 	}
		 	if(row.getCell(15)!=null &&row.getCell(15).getCellType()==CellType.STRING) {
		 		serverData.setTotalCores(row.getCell(15).getStringCellValue());
		 	}
		 	if(row.getCell(16)!=null && row.getCell(16).getCellType()==CellType.STRING) {
		 		serverData.setMemory(row.getCell(16).getStringCellValue());
		 	}
		 	if(row.getCell(17)!=null &&row.getCell(17).getCellType()==CellType.STRING) {
		 		serverData.setDiskSize(row.getCell(17).getStringCellValue());
		 	}
		 	if(row.getCell(18)!=null &&row.getCell(18).getCellType()==CellType.STRING) {
		 		serverData.setDiskFreeSpace(row.getCell(18).getStringCellValue());
		 	}
		 	if(row.getCell(19)!=null &&row.getCell(19).getCellType()==CellType.STRING) {
		 		serverData.setAvgCpuUsage(row.getCell(19).getStringCellValue());
		 	}
		 	if(row.getCell(20)!=null &&row.getCell(20).getCellType()==CellType.STRING) {
		 		serverData.setAvgMemoryUsage(row.getCell(20).getStringCellValue());
		 	}
		 	if(row.getCell(21)!=null &&row.getCell(21).getCellType()==CellType.STRING) {
		 		serverData.setPeakCpuUsage(row.getCell(21).getStringCellValue());
		 	}
		 	if(row.getCell(22)!=null &&row.getCell(22).getCellType()==CellType.STRING) {
		 		serverData.setPeakMemoryUsage(row.getCell(22).getStringCellValue());
		 	}
		 	if(row.getCell(23)!=null &&row.getCell(23).getCellType()==CellType.STRING) {
		 		serverData.setAvarageStorageIOPS(row.getCell(23).getStringCellValue());
		 	}
		 	if(row.getCell(24)!=null&&row.getCell(24).getCellType()==CellType.STRING  ) {
		 		serverData.setPeakStorageIOPS(row.getCell(24).getStringCellValue());
		 	}
		 	if(row.getCell(25)!=null &&row.getCell(25).getCellType()==CellType.STRING) {
		 		serverData.setAvgStorageReadIOPS(row.getCell(25).getStringCellValue());
		 	}
		 	if(row.getCell(26)!=null &&row.getCell(26).getCellType()==CellType.STRING) {
		 		serverData.setAvgStorageWriteIOPS(row.getCell(26).getStringCellValue());
		 	}
		 	if(row.getCell(27)!=null &&row.getCell(27).getCellType()==CellType.STRING) {
		 		serverData.setPeakNetworkUsage(row.getCell(27).getStringCellValue());
		 	}
		 	if(row.getCell(28)!=null &&row.getCell(28).getCellType()==CellType.STRING) {
		 		serverData.setMaxNetworkUsageRate(row.getCell(28).getStringCellValue());
		 	}
		 	
		 	infraDet.add(serverData);
		 
	
		 	
		 }
		 mappingRepo.deleteInfraMapping(orgId);
			infraRepo.deleteInfraMapping(orgId);

			infraRepo.saveAll(infraDet);
		 
		 
		


			
			Sheet sheet1= workbook.getSheetAt(1);



			System.out.println(sheet.getLastRowNum());

			Iterator<Row> row=sheet1.iterator();

			row.next();


			while(row.hasNext() ) {
				

				
				Row row1=row.next(); 
				
				
				if (isCellEmpty(row1.getCell(0))) {
			        break;
			    }
				



					InfraAppMappingTable files=new InfraAppMappingTable();
					
					//files.setAppSeq("1");
					files.setRecInsDt(new java.util.Date());
					files.setRecUpdDt(new java.util.Date());
					files.setOrgId(orgId);
					//infraDetails.getApplications().set
					
					String appsId = null;
					String hostName=null;
					String IpAddress=null;;
					if(row1.getCell(0)!=null&&row1.getCell(0).getCellType()==CellType.NUMERIC) {
						double appId= Double.parseDouble(row1.getCell(0).toString());
						int applicationId=(int)appId;
						appsId=String.valueOf(applicationId);
					//appDetails.setAppId(appId);
					}
					if(row1.getCell(2)!=null&&row1.getCell(2).getCellType()==CellType.STRING) {
						//String appId=String.valueOf(row.getCell(2).getNumericCellValue());
						
					 hostName=row1.getCell(2).getStringCellValue();
					}
					if(row1.getCell(3)!=null&&row1.getCell(3).getCellType()==CellType.STRING) {
						//String appId=String.valueOf(row.getCell(2).getNumericCellValue());
					 IpAddress=row1.getCell(3).getStringCellValue();
					 
					}
					List<Object[]> appMasterId=mappingRepo.getAppMasterId(	appsId);
					System.out.println(appMasterId + "App master ID");
					List<Object[]> infraId=mappingRepo.getInfraId(hostName, IpAddress);
					
					if(!appMasterId.isEmpty() && !infraId.isEmpty()) {
					appMasterId.stream().forEach(objects->{ 
						
						files.setAppMasterId((Integer) objects[0]);
						
					});	
					
					infraId.stream().forEach(objects->{ 
						
						files.setInfraId((Integer) objects[0]);
						mapping.add(files);
					});	
					
					
					
					
				
				
					}
					
					
						  
			
					 
					
					

					
				}
			
		
			
			mappingRepo.saveAll(mapping);
				
				
				
				

				 
			 
		 
		  
		
		 
		 FileUploaded=true;
			return FileUploaded;
		 	
		
		 
	 }
		 
	
return FileUploaded;

	

}


private String lobDesc() {
	// TODO Auto-generated method stub
	return null;
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

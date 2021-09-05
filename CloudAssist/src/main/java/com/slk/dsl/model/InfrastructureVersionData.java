package com.slk.dsl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="ca_infra_data_versioning")
public class InfrastructureVersionData {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Infra_VersionId",nullable = false, unique = true)
	private int infraVersionId;
	
	
	@Column(name="versionId")
	private int versionId;
	public InfrastructureVersionData(int infraVersionId, int versionId, int orgId, String hostName, String ipAddress,
			String hypervisor, String osType, String osVersion, String osBitness, String physicalOrVirtual,
			String serverType, String environment, String dataCenter, String businessUnit, String serverOwner,
			String inScope, Date recInsDt, String cpuType, String cpu, String totalCores, String memory,
			String diskSize, String diskFreeSpace, String avgCpuUsage, String avgMemoryUsage, String peakCpuUsage,
			String peakMemoryUsage, String avarageStorageIOPS, String peakStorageIOPS, String avgStorageReadIOPS,
			String avgStorageWriteIOPS, String peakNetworkUsage, String maxNetworkUsageRate) {
		super();
		this.infraVersionId = infraVersionId;
		this.versionId = versionId;
		this.orgId = orgId;
		this.hostName = hostName;
		this.ipAddress = ipAddress;
		this.hypervisor = hypervisor;
		this.osType = osType;
		this.osVersion = osVersion;
		this.osBitness = osBitness;
		this.physicalOrVirtual = physicalOrVirtual;
		this.serverType = serverType;
		this.environment = environment;
		this.dataCenter = dataCenter;
		this.businessUnit = businessUnit;
		this.serverOwner = serverOwner;
		this.inScope = inScope;
		this.recInsDt = recInsDt;
		this.cpuType = cpuType;
		this.cpu = cpu;
		this.totalCores = totalCores;
		this.memory = memory;
		this.diskSize = diskSize;
		this.diskFreeSpace = diskFreeSpace;
		this.avgCpuUsage = avgCpuUsage;
		this.avgMemoryUsage = avgMemoryUsage;
		this.peakCpuUsage = peakCpuUsage;
		this.peakMemoryUsage = peakMemoryUsage;
		this.avarageStorageIOPS = avarageStorageIOPS;
		this.peakStorageIOPS = peakStorageIOPS;
		this.avgStorageReadIOPS = avgStorageReadIOPS;
		this.avgStorageWriteIOPS = avgStorageWriteIOPS;
		this.peakNetworkUsage = peakNetworkUsage;
		this.maxNetworkUsageRate = maxNetworkUsageRate;
	}
	@Column(name="Org_Id")
	private int orgId;
	
	public int getInfraVersionId() {
		return infraVersionId;
	}
	public void setInfraVersionId(int infraVersionId) {
		this.infraVersionId = infraVersionId;
	}
	public int getVersionId() {
		return versionId;
	}
	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}
	@Column(name="Host_Name")
	private String hostName;
	
	@Column(name="IP_Address")
	private String ipAddress;
	
	@Column(name="Hypervisor")
	private String hypervisor;
	
	@Column(name="OS_Type")
	private String osType;
	
	
	@Column(name="OS_Version")
	private String osVersion;
	
	@Column(name="OS_Bitness")
	private String osBitness;
	
	@Column(name="Physical_OR_Virtual")
	private String physicalOrVirtual;
	
	@Column(name="Server_Type")
	private String serverType;
	
	@Column(name="Environment")
	private String environment;
	
	@Column(name="Data_Center")
	private String dataCenter;
	
	@Column(name="Business_Unit")
	private String businessUnit;
	
	@Column(name="Server_Owner")
	private String serverOwner;
	
	@Column(name="In_Scope")
	private String inScope;
	@Column(name="Rec_Ins_Dt")
	private Date recInsDt;
	@Column(name="CPU_Type")
	private String cpuType;
	
	@Column(name="CPU")
	private String cpu;
	
	@Column(name="Total_Cores")
	private String totalCores;
	
	@Column(name="Memory")
	private String memory;
	
	@Column(name="Disk_Size")
	private String diskSize;
	
	@Column(name="Disk_Free_Space")
	private String diskFreeSpace;
	
	@Column(name="Avg_CPU_Usage")
	private String avgCpuUsage;
	
	public String getAvgMemoryUsage() {
		return avgMemoryUsage;
	}
	public void setAvgMemoryUsage(String avgMemoryUsage) {
		this.avgMemoryUsage = avgMemoryUsage;
	}
	@Column(name="Avg_Memory_Usage")
	private String avgMemoryUsage;
	
	@Column(name="Peak_CPU_Usage")
	private String peakCpuUsage;
	
	
	@Column(name="Peak_Memory_Usage")
	private String peakMemoryUsage;
	
	@Column(name="Avg_Storage_IOPS")
	private String avarageStorageIOPS;
	
	@Column(name="Peak_Storage_IOPS")
	private String peakStorageIOPS;
	
	
	//to map application and infra
	/*
	 * @ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL,mappedBy =
	 * "infra") private Set<ApplicationModel> applications=new HashSet<>();
	 */
	

	/*
	 * public Set<ApplicationModel> getApplications() { return applications; }
	 * public void setApplications(Set<ApplicationModel> applications) {
	 * this.applications = applications; }
	 */
	public InfrastructureVersionData( int orgId, String hostName, String ipAddress, String hypervisor, String osType,
			String osVersion, String osBitness, String physicalOrVirtual, String serverType, String environment,
			String dataCenter, String businessUnit, String serverOwner, String inScope, String cpuType, String cpu,
			String totalCores, String memory, String diskSize, String diskFreeSpace, String avgCpuUsage,
			String peakCpuUsage, String peakMemoryUsage, String avarageStorageIOPS, String peakStorageIOPS,
			String avgStorageReadIOPS, String avgStorageWriteIOPS, String peakNetworkUsage,
			String maxNetworkUsageRate,String avgMemoryUsage,Date recInsDt) {}
	
	public InfrastructureVersionData() {
		// TODO Auto-generated constructor stub
	}
	
	public InfrastructureVersionData(MultipartFile file) {
		// TODO Auto-generated constructor stub
	}
	
	public int getOrgId() {
		return orgId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getHypervisor() {
		return hypervisor;
	}
	public void setHypervisor(String hypervisor) {
		this.hypervisor = hypervisor;
	}
	public String getOsType() {
		return osType;
	}
	public void setOsType(String osType) {
		this.osType = osType;
	}
	public String getOsVersion() {
		return osVersion;
	}
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
	public String getOsBitness() {
		return osBitness;
	}
	public void setOsBitness(String osBitness) {
		this.osBitness = osBitness;
	}
	public String getPhysicalOrVirtual() {
		return physicalOrVirtual;
	}
	public void setPhysicalOrVirtual(String physicalOrVirtual) {
		this.physicalOrVirtual = physicalOrVirtual;
	}
	public String getServerType() {
		return serverType;
	}
	public void setServerType(String serverType) {
		this.serverType = serverType;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	public String getDataCenter() {
		return dataCenter;
	}
	public void setDataCenter(String dataCenter) {
		this.dataCenter = dataCenter;
	}
	public String getBusinessUnit() {
		return businessUnit;
	}
	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}
	public String getServerOwner() {
		return serverOwner;
	}
	public void setServerOwner(String serverOwner) {
		this.serverOwner = serverOwner;
	}
	public String getInScope() {
		return inScope;
	}
	public Date getRecInsDt() {
		return recInsDt;
	}
	public void setRecInsDt(Date recInsDt) {
		this.recInsDt = recInsDt;
	}
	public void setInScope(String inScope) {
		this.inScope = inScope;
	}
	public String getCpuType() {
		return cpuType;
	}
	public void setCpuType(String cpuType) {
		this.cpuType = cpuType;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getTotalCores() {
		return totalCores;
	}
	public void setTotalCores(String totalCores) {
		this.totalCores = totalCores;
	}
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	public String getDiskSize() {
		return diskSize;
	}
	public void setDiskSize(String diskSize) {
		this.diskSize = diskSize;
	}
	public String getDiskFreeSpace() {
		return diskFreeSpace;
	}
	public void setDiskFreeSpace(String diskFreeSpace) {
		this.diskFreeSpace = diskFreeSpace;
	}
	public String getAvgCpuUsage() {
		return avgCpuUsage;
	}
	public void setAvgCpuUsage(String avgCpuUsage) {
		this.avgCpuUsage = avgCpuUsage;
	}
	public String getPeakCpuUsage() {
		return peakCpuUsage;
	}
	public void setPeakCpuUsage(String peakCpuUsage) {
		this.peakCpuUsage = peakCpuUsage;
	}
	public String getPeakMemoryUsage() {
		return peakMemoryUsage;
	}
	public void setPeakMemoryUsage(String peakMemoryUsage) {
		this.peakMemoryUsage = peakMemoryUsage;
	}
	public String getAvarageStorageIOPS() {
		return avarageStorageIOPS;
	}
	public void setAvarageStorageIOPS(String avarageStorageIOPS) {
		this.avarageStorageIOPS = avarageStorageIOPS;
	}
	public String getPeakStorageIOPS() {
		return peakStorageIOPS;
	}
	public void setPeakStorageIOPS(String peakStorageIOPS) {
		this.peakStorageIOPS = peakStorageIOPS;
	}
	public String getAvgStorageReadIOPS() {
		return avgStorageReadIOPS;
	}
	public void setAvgStorageReadIOPS(String avgStorageReadIOPS) {
		this.avgStorageReadIOPS = avgStorageReadIOPS;
	}
	public String getAvgStorageWriteIOPS() {
		return avgStorageWriteIOPS;
	}
	public void setAvgStorageWriteIOPS(String avgStorageWriteIOPS) {
		this.avgStorageWriteIOPS = avgStorageWriteIOPS;
	}
	public String getPeakNetworkUsage() {
		return peakNetworkUsage;
	}
	public void setPeakNetworkUsage(String peakNetworkUsage) {
		this.peakNetworkUsage = peakNetworkUsage;
	}
	public String getMaxNetworkUsageRate() {
		return maxNetworkUsageRate;
	}
	public void setMaxNetworkUsageRate(String maxNetworkUsageRate) {
		this.maxNetworkUsageRate = maxNetworkUsageRate;
	}
	@Column(name="Avg_Storage_Read_IOPS")
	private String avgStorageReadIOPS;
	@Column(name="Avg_Storage_Write_IOPS")
	private String avgStorageWriteIOPS;
	@Column(name="Peak_Network_Usage")
	private String peakNetworkUsage;
	
	@Column(name="Max_Network_Usage_Rate")
	private String maxNetworkUsageRate;
	
	public int getInfraId() {
		return infraId;
	}
	public void setInfraId(int infraId) {
		this.infraId = infraId;
	}
	@Column(name="infra_id")
	private int infraId;
	
	

}
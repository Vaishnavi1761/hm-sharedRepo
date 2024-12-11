package com.cg.dto;


import com.cg.model.Patient;

public class PatientDTO {
	 private int pid;
	    private String pname;
	    private long phonenumber;
	    private String address;


public PatientDTO(int pid, String pname, long phonenumber, String address) {
	super();
	this.pid = pid;
	this.pname = pname;
	this.phonenumber = phonenumber;
	this.address = address;
}

public int getPid() {
	return pid;
}

public void setPid(int pid) {
	this.pid = pid;
}

public String getPname() {
	return pname;
}

public void setPname(String pname) {
	this.pname = pname;
}

public long getPhonenumber() {
	return phonenumber;
}

public void setPhonenumber(long phonenumber) {
	this.phonenumber = phonenumber;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public static PatientDTO fromEntity(Patient patient)
{
	//to convert productEntity to DTO Object
  return new PatientDTO(patient.getPid(),patient.getPname(),patient.getPhoneNumber(),patient.getAddress());
}
public Patient toEntity()
{    //from DTO to product object
	return new Patient(this.pid,this.pname,this.phonenumber,this.address);
}




}

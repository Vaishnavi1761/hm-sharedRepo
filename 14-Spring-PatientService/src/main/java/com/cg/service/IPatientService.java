package com.cg.service;

import java.util.List;
import java.util.Optional;

import com.cg.model.Patient;

public interface IPatientService  {
	List<Patient> findAllPatient() ;
	 Optional<Patient> findPatinetById(int pid);
	 public Patient createPatient(Patient p);
	 public void deletePatient(int pid);
	 public Patient updatePatient(int pid,Patient p);
//	List<Patient> getPatientByname(String name);
//	int getPatinetCount(String name);
	 

}

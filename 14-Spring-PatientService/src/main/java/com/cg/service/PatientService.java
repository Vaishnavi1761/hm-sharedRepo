package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.model.Patient;
import com.cg.repository.PatientRepository;
@Service
public class PatientService implements IPatientService {
	
	@Autowired
	PatientRepository patientRepo;

	@Override
	public List<Patient> findAllPatient() {
		// TODO Auto-generated method stub
		return patientRepo.findAll();
	}

	@Override
	public Optional<Patient> findPatinetById(int pid) {
		// TODO Auto-generated method stub
		return patientRepo.findById(pid);
	}

	@Override
	public Patient createPatient(Patient p) {
		// TODO Auto-generated method stub
		return patientRepo.save(p);
	}

	@Override
	public void deletePatient(int pid) {
		patientRepo.deleteById(pid);
		
	}

	@Override
	public Patient updatePatient(int pid, Patient p) {
		// TODO Auto-generated method stub
		return patientRepo.save(p);
	}

//	@Override
//	public List<Patient> getPatientByname(String name) {
//		// TODO Auto-generated method stub
//		return patientRepo.findAllByPName(name);
//	}
//
//	@Override
//	public int getPatinetCount(String name) {
//		// TODO Auto-generated method stub
//		return patientRepo.getCountByPName(name);
//	}
	

}

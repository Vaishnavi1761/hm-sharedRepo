package com.cg.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.PatientDTO;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.Patient;
import com.cg.service.IPatientService;

//http://localhost:9091/patients

@RequestMapping("/api")
@RestController
public class PatientController {
	@Autowired
	IPatientService patientService;
	  // Injecting error messages from application.properties
    @Value("${error.patientNotFound}")
    private String patientNotFoundMessage;
 
    @Value("${error.patientDeletionFailed}")
    private String patientDeletionFailedMessage;
    
    @Value("${error.patientUpdation}")
    private String patientUpdationMessage;
 
   

        // Get all patients as DTOs
        @GetMapping("/patients")
        public List<PatientDTO> getAllPatients() {
            return patientService.findAllPatient()
                                 .stream()
                                 .map(PatientDTO::fromEntity) // Convert Entities to DTOs
                                 .collect(Collectors.toList());
        }

        @GetMapping("/hello")
        public String sayHello() {
            return "Hello Application Spring";
        }

        // Get patient by ID with DTO
        @GetMapping("/patients/{id}")
        public PatientDTO getPatientById(@PathVariable int id) throws ResourceNotFoundException {
            return patientService.findPatinetById(id)
                                 .map(PatientDTO::fromEntity) // Convert Entity to DTO
                                 .orElseThrow(() -> new ResourceNotFoundException(String.format(patientNotFoundMessage, id)));
        }

        // Create a new patient with DTO
        @PostMapping("/patients")
        public PatientDTO createPatient(@RequestBody PatientDTO patientDTO) {
            Patient patient = patientDTO.toEntity(); // Convert DTO to Entity
            Patient createdPatient = patientService.createPatient(patient);
            return PatientDTO.fromEntity(createdPatient); // Convert Entity back to DTO
        }

        // Update patient with DTO
        @PutMapping("/patients/{id}")
        public PatientDTO updatePatient(@PathVariable int id, @RequestBody PatientDTO patientDTO) throws ResourceNotFoundException {
            Patient existingPatient = patientService.findPatinetById(id)
                                                    .orElseThrow(() -> new ResourceNotFoundException(String.format(patientUpdationMessage, id)));

            // Update properties
            existingPatient.setPname(patientDTO.getPname());
            existingPatient.setAddress(patientDTO.getAddress());
            existingPatient.setPhoneNumber(patientDTO.getPhonenumber());

            Patient updatedPatient = patientService.updatePatient(id, existingPatient);
            return PatientDTO.fromEntity(updatedPatient);
        }

        // Delete patient by ID
        @DeleteMapping("/patients/{id}")
        public void deletePatient(@PathVariable int id) throws ResourceNotFoundException {
            patientService.findPatinetById(id)
                          .orElseThrow(() -> new ResourceNotFoundException(String.format(patientDeletionFailedMessage, id)));
            patientService.deletePatient(id);
        }

        // Get patients by name
//        @GetMapping("/patients/name/{name}")
//        public List<PatientDTO> getPatientsByName(@PathVariable String name) throws ResourceNotFoundException {
//            List<Patient> patients = patientService.getPatientByname(name);
//            if (patients.isEmpty()) {
//                throw new ResourceNotFoundException("No Patient found with the name :: " + name);
//            }
//            return patients.stream()
//                           .map(PatientDTO::fromEntity) // Convert Entities to DTOs
//                           .collect(Collectors.toList());
//        }
//
//        // Get patient count by name
//        @GetMapping("/patients/count/{name}")
//        public int getPatientCount(@PathVariable String name) throws ResourceNotFoundException {
//            int count = patientService.getPatinetCount(name);
//            if (count == 0) {
//                throw new ResourceNotFoundException("No patient found with the name :: " + name);
//            }
//            return count;
//        }
    }
//	//@GetMapping("/product")
//	@GetMapping(path = "/patients", produces = {MediaType.APPLICATION_JSON_VALUE})
//	public List<Patient> getDoctor()
//	{
//		return patientService.findAllPatient();
//	}
//	
//	@GetMapping("/hello")
//	public String sayHello()
//	{
//		return "Hello Application Sprig";
//	}
//
//	@GetMapping("/patients/{id}")
//	Optional<Patient>findByDoctorIdFromDBWithException(@PathVariable int id) throws ResourceNotFoundException
//	{	Optional<Patient> doctor =patientService.findPatinetById(id);
//	
//    	doctor.orElseThrow(() -> new ResourceNotFoundException(String.format(patientNotFoundMessage, id)));
//    	System.out.println(id);
//    return doctor;	
//	}
//	
//	
//	
//	@PostMapping("/patients")
//	
//	public Patient createMyDoctor(@RequestBody Patient p)
//	{
//		return patientService.createPatient(p);
//	}
//
//	@DeleteMapping("/patients/{id}")
//	public void deleteMyPatient(@PathVariable int id) throws ResourceNotFoundException {
//	    // Check if product exists before deleting
//	    Optional<Patient> doctor = patientService.findPatinetById(id);
//	    doctor.orElseThrow(() -> new ResourceNotFoundException(String.format(patientDeletionFailedMessage, id)));
//	    
//	    // Proceed with deletion if product is found
//	    patientService.findPatinetById(id);
//	}
//
//	// Update product by ID
//	@PutMapping("/patients/{id}")
//	public Patient updateMyPatient(@PathVariable int id, @RequestBody Patient p) throws ResourceNotFoundException {
//	    // Check if product exists before updating
//	    Optional<Patient> existingDoctor = patientService.findPatinetById(id);
//	    existingDoctor.orElseThrow(() -> new ResourceNotFoundException(String.format(patientUpdationMessage, id)));
//	    
//	    // Set the ID of the product to be updated
//	    p.getpId();
//	    return patientService.updatePatient(id, p);
//	}
//
//	// Get products by name
//	@GetMapping("/patients/name/{name}")
//	public List<Patient> getDoctorByname(@PathVariable String name) throws ResourceNotFoundException {
//	    List<Patient> patient = patientService.getPatientByname(name);
//	    if (patient.isEmpty()) {
//	        throw new ResourceNotFoundException("No Doctor found with the name :: " + name);
//	    }
//	    return patient;
//	}
//
//	// Get product count by name
//	@GetMapping("/patient/count/{name}")
//	public int getPatientCount(@PathVariable String name) throws ResourceNotFoundException {
//	    int count = patientService.getPatinetCount(name);
//	    if (count == 0) {
//	        throw new ResourceNotFoundException("No doctor found with the name :: " + name);
//	    }
//	    return count;
//	}
//
//
//}

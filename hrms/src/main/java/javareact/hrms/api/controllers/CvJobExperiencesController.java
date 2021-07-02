package javareact.hrms.api.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javareact.hrms.business.abstracts.CvJobExperienceService;
import javareact.hrms.entities.concretes.CvJobExperience;

@RestController
@RequestMapping("/api/cvjobexperiences")
@CrossOrigin
public class CvJobExperiencesController {
	
	private CvJobExperienceService cvJobExperienceService;
	
	@Autowired
	public CvJobExperiencesController(CvJobExperienceService cvJobExperienceService) {
		super();
		this.cvJobExperienceService = cvJobExperienceService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody CvJobExperience cvJobExperience) {
		return ResponseEntity.ok(this.cvJobExperienceService.add(cvJobExperience));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.cvJobExperienceService.getAll());
	}
	
	@GetMapping("/getallbycandidateidorderbyleavedatedesc")
	public ResponseEntity<?> getAllByCandidateIdOrderByLeaveDateDesc(@RequestParam int candidateId){
		return ResponseEntity.ok(this.cvJobExperienceService.getAllByCandidateIdOrderByLeaveDateDesc(candidateId));
	}
	
	@GetMapping("/getallbycandidateid")
	public ResponseEntity<?> getAllByCandidateId(@RequestParam int candidateId){
		return ResponseEntity.ok(this.cvJobExperienceService.getAllByCandidateId(candidateId));
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody CvJobExperience cvJobExperience) {
		return ResponseEntity.ok(this.cvJobExperienceService.delete(cvJobExperience));
	}
	
}

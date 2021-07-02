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

import javareact.hrms.business.abstracts.CvEducationService;
import javareact.hrms.entities.concretes.CvEducation;
@RestController
@RequestMapping("/api/cveducations")
@CrossOrigin
public class CvEducationsController {
	
	private CvEducationService cvEducationService;
	
	@Autowired
	public CvEducationsController(CvEducationService cvEducationService) {
		super();
		this.cvEducationService = cvEducationService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody CvEducation cvEducation) {
		return ResponseEntity.ok(this.cvEducationService.add(cvEducation));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.cvEducationService.getAll());
	}

	@GetMapping("/getallbycandidateidorderbyfinishdatedesc")
	public ResponseEntity<?> getAllByCandidateIdOrderByFinishDateDesc(@RequestParam int candidateId){
		return ResponseEntity.ok(this.cvEducationService.getAllByCandidateIdOrderByFinishDateDesc(candidateId));
	}
	
	@GetMapping("/getallbycandidateid")
	public ResponseEntity<?> getAllByCandidateId(@RequestParam int candidateId){
		return ResponseEntity.ok(this.cvEducationService.getAllByCandidateId(candidateId));
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody CvEducation cvEducation) {
		return ResponseEntity.ok(this.cvEducationService.delete(cvEducation));
	}
}

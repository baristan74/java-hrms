package javareact.hrms.api.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javareact.hrms.business.abstracts.JobPositionService;
import javareact.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {
	
	private JobPositionService jobPositionService;
	
	@Autowired
	public JobPositionsController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}


	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.jobPositionService.getAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobPosition jobPosition) {
		return ResponseEntity.ok(this.jobPositionService.add(jobPosition));
	}
}

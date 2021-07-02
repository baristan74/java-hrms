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

import javareact.hrms.business.abstracts.CandidateService;
import javareact.hrms.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidatesController {
	
	private CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.candidateService.getAll());
	}
	
	@PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody Candidate candidate){
        return ResponseEntity.ok(this.candidateService.add(candidate));
    }
	
	@GetMapping("/getcvbycandidateid")
	public ResponseEntity<?> getCvByCandidateId(@RequestParam int candidateId){
		return ResponseEntity.ok(this.candidateService.getCvByCandidateId(candidateId));
	}
	
	@GetMapping("/getbyid")
	public ResponseEntity<?> getById(int candidateId){
		return ResponseEntity.ok(this.candidateService.getById(candidateId));
	}
	
	
}

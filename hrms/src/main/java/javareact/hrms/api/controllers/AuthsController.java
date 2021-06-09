package javareact.hrms.api.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javareact.hrms.business.abstracts.AuthService;
import javareact.hrms.entities.concretes.Candidate;
import javareact.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/auths")
public class AuthsController {
	private AuthService authService;

	@Autowired
	public AuthsController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@PostMapping("/registerCandidate")
	public ResponseEntity<?> registerCandidate(@Valid @RequestBody Candidate candidate,@RequestParam String confirmedPassword) {
		return ResponseEntity.ok(this.authService.registerCandidate(candidate, confirmedPassword));
	}
	
	@PostMapping("/registerEmployer")
	public ResponseEntity<?> registerEmployer(@Valid @RequestBody Employer employer,@RequestParam String confirmedPassword) {
		return ResponseEntity.ok(this.authService.registerEmployer(employer, confirmedPassword));
	}
	
	
	
}

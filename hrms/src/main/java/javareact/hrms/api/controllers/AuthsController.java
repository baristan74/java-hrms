package javareact.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javareact.hrms.business.abstracts.AuthService;
import javareact.hrms.core.utilities.results.Result;
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
	public Result registerCandidate(@RequestBody Candidate candidate,String confirmedPassword) {
		return this.authService.registerCandidate(candidate, confirmedPassword);
	}
	
	@PostMapping("/registerEmployer")
	public Result registerEmployer(@RequestBody Employer employer,String confirmedPassword) {
		return this.authService.registerEmployer(employer, confirmedPassword);
	}
}

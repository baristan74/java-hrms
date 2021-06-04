package javareact.hrms.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javareact.hrms.business.abstracts.AuthService;
import javareact.hrms.core.utilities.results.ErrorDataResult;
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
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String,String> validationErrors = new HashMap<String,String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors);
		return errors;
	}
}

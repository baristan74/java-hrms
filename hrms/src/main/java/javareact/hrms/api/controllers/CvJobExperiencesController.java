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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javareact.hrms.business.abstracts.CvJobExperienceService;
import javareact.hrms.core.utilities.results.ErrorDataResult;
import javareact.hrms.entities.concretes.CvJobExperience;

@RestController
@RequestMapping("/api/cvjobexperiences")
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

package javareact.hrms.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javareact.hrms.business.abstracts.CvEducationService;
import javareact.hrms.core.utilities.results.ErrorDataResult;
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

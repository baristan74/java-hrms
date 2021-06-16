package javareact.hrms.api.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javareact.hrms.business.abstracts.EmploymentTypeService;
import javareact.hrms.entities.concretes.EmploymentType;

@RestController
@RequestMapping("/api/employmenttypes")
@CrossOrigin
public class EmploymentTypesController {
	private EmploymentTypeService employmentTypeService;
	
	@Autowired
	public EmploymentTypesController(EmploymentTypeService employmentTypeService) {
		super();
		this.employmentTypeService = employmentTypeService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody EmploymentType employmentType) {
		return ResponseEntity.ok(this.employmentTypeService.add(employmentType));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.employmentTypeService.getAll());
	}
}

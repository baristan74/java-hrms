package javareact.hrms.api.controllers;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javareact.hrms.business.abstracts.WorkingTypeService;
import javareact.hrms.entities.concretes.WorkingType;
@RestController
@RequestMapping("/api/workingtypes")
@CrossOrigin
public class WorkingTypesController {
	
	private WorkingTypeService workingTypeService;
	
	public WorkingTypesController(WorkingTypeService workingTypeService) {
		super();
		this.workingTypeService = workingTypeService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody WorkingType workingType) {
		return ResponseEntity.ok(this.workingTypeService.add(workingType));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.workingTypeService.getAll());
	}
}

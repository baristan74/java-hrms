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

import javareact.hrms.business.abstracts.EmployerUpdateConfirmByEmployeeService;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.entities.concretes.EmployerUpdateConfirmByEmployee;

@RestController
@RequestMapping("/api/employerupdateconfirmbyemployees")
@CrossOrigin
public class EmployerUpdateConfirmByEmployeesController {
	
	private EmployerUpdateConfirmByEmployeeService employerUpdateConfirmByEmployeeService;
	
	@Autowired
	public EmployerUpdateConfirmByEmployeesController(
			EmployerUpdateConfirmByEmployeeService employerUpdateConfirmByEmployeeService) {
		super();
		this.employerUpdateConfirmByEmployeeService = employerUpdateConfirmByEmployeeService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody EmployerUpdateConfirmByEmployee employerUpdateConfirmByEmployee) {
		return ResponseEntity.ok(this.employerUpdateConfirmByEmployeeService.add(employerUpdateConfirmByEmployee)); 
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam int id) {
		return ResponseEntity.ok(this.employerUpdateConfirmByEmployeeService.delete(id));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAlll(){
		return ResponseEntity.ok(this.employerUpdateConfirmByEmployeeService.getAlll());
	}
	
	@GetMapping("/getById")
	public ResponseEntity<?> getById(@RequestParam int employerId){
		return ResponseEntity.ok(this.employerUpdateConfirmByEmployeeService.getById(employerId));
	}
	
	@GetMapping("/getallbyconfirmfalse")
	public ResponseEntity<?> getAllByConfirmFalse(){
		return ResponseEntity.ok(this.employerUpdateConfirmByEmployeeService.getAllByConfirmFalse());
	}
	
	@PostMapping("/changeisconfirmedbyemployee")
	public ResponseEntity<?> changeIsConfirmedByEmployee(@RequestParam int employerId) {
		return ResponseEntity.ok(this.employerUpdateConfirmByEmployeeService.changeIsConfirmedByEmployee(employerId));
	}
}

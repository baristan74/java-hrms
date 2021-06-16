package javareact.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javareact.hrms.business.abstracts.JobAdvertService;
import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.entities.concretes.JobAdvert;

@RestController
@RequestMapping("/api/jobAdverts")
@CrossOrigin
public class JobAdvertsController {

	private JobAdvertService jobAdvertService;

	public JobAdvertsController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobAdvert jobAdvert) {
		return ResponseEntity.ok(this.jobAdvertService.add(jobAdvert));
	}

	@PostMapping("/changeactivestatus")
	public Result changeActiveStatus(@RequestParam int id) {
		return this.jobAdvertService.changeActiveStatus(id);
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.jobAdvertService.getAll());
	}

	@GetMapping("/getallbyemployerid")
	public ResponseEntity<?> getAllByEmployer(@RequestParam int employerId) {
		return ResponseEntity.ok(this.jobAdvertService.getAllByEmployer(employerId));
	}

	@GetMapping("/getbyisactivated")
	public DataResult<List<JobAdvert>> getByIsActivated() {
		return this.jobAdvertService.getByIsActivated();

	}
	
	@GetMapping("/getById")
	public ResponseEntity<?>  getById(int id){
		return ResponseEntity.ok(this.jobAdvertService.getById(id));
	}

	@GetMapping("/getallsortedbypublisheddate")
	public ResponseEntity<?> getAllSortedByPublishedDate() {
		return ResponseEntity.ok(this.jobAdvertService.getAllSortedByPublishedDate());
	}
	
	@GetMapping("/getallbyisconfirmedbyemployee")
	public ResponseEntity<?> getAllByIsConfirmedByEmployee(){
		return ResponseEntity.ok(this.jobAdvertService.getAllByIsConfirmedByEmployee());
	}

	@PostMapping("/changeisconfirmedbyemployee")
	public Result changeIsConfirmedByEmployee(@RequestParam int jobAdvertId) {
		return this.jobAdvertService.changeIsConfirmedByEmployee(jobAdvertId);
	}
	
	@GetMapping("/getallbyisconfirmedbyemployeefalse")
	public ResponseEntity<?> getAllByIsConfirmedByEmployeeFalse(){
		return ResponseEntity.ok(this.jobAdvertService.getAllByIsConfirmedByEmployeeFalse());
	}

}

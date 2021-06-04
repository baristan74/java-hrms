package javareact.hrms.api.controllers;

import java.util.List;

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
public class JobAdvertsController {

	private JobAdvertService jobAdvertService;

	public JobAdvertsController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvert jobAdvert) {
		return this.jobAdvertService.add(jobAdvert);
	}
	
	@PostMapping("/changeactivestatus")
	public Result changeActiveStatus(@RequestParam int id) {
		return this.jobAdvertService.changeActiveStatus(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvert>> getAll(){
		return this.jobAdvertService.getAll();
	}
	
	@GetMapping("/getallbyemployer")
	public DataResult<List<JobAdvert>> getAllByEmployer(@RequestParam int employerId){
		return this.jobAdvertService.getAllByEmployer(employerId);
	}
	
	@GetMapping("/getbyisactivated")
	public DataResult <List<JobAdvert>> getByIsActivated(){
		return this.jobAdvertService.getByIsActivated();
		
	}
	
	@GetMapping("/getallsortedbypublisheddate")
	public DataResult<List<JobAdvert>> getAllSortedByPublishedDate(){
		return this.jobAdvertService.getAllSortedByPublishedDate();
	}
	
}

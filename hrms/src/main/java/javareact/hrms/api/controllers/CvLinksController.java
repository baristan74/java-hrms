package javareact.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javareact.hrms.business.abstracts.CvLinkService;
import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.entities.concretes.CvLink;

@RestController
@RequestMapping("/api/cvlinks")
public class CvLinksController {
	
	private CvLinkService cvLinkService;

	@Autowired
	public CvLinksController(CvLinkService cvLinkService) {
		super();
		this.cvLinkService = cvLinkService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvLink cvLink) {
		return this.cvLinkService.add(cvLink);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CvLink>> getAll(){
		return this.cvLinkService.getAll();
	}
	
	@GetMapping("getallbycandidateId")
	public DataResult<List<CvLink>> getAllByCandidateId(@RequestParam int candidateId){
		return this.cvLinkService.getAllByCandidateId(candidateId);
	}
	

}

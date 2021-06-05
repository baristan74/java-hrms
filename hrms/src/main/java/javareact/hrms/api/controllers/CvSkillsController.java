package javareact.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javareact.hrms.business.abstracts.CvSkillService;
import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.entities.concretes.CvSkill;
@RestController
@RequestMapping("/api/cvskills")
public class CvSkillsController {
	private CvSkillService cvSkillService;
	
	@Autowired
	public CvSkillsController(CvSkillService cvSkillService) {
		super();
		this.cvSkillService = cvSkillService;
	}

	@PostMapping("/add")
	public Result add(CvSkill cvSkill) {
		return this.cvSkillService.add(cvSkill);
	}
	
	@GetMapping("/getall")
    public DataResult<List<CvSkill>> getAll(){
		return this.cvSkillService.getAll();
	}
	
	@GetMapping("/getallbycandidateid")
    public DataResult<List<CvSkill>> getAllByCandidateId(int candidateId){
    	return this.cvSkillService.getAllByCandidateId(candidateId);
    }
}

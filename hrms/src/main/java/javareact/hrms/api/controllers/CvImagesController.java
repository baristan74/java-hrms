package javareact.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javareact.hrms.business.abstracts.CandidateService;
import javareact.hrms.business.abstracts.CvImageService;
import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.entities.concretes.Candidate;
import javareact.hrms.entities.concretes.CvImage;
@RestController
@RequestMapping("/api/cvimages")
public class CvImagesController {

	private CvImageService cvImageService;
	private CandidateService candidateService;
	
	@Autowired
	public CvImagesController(CvImageService cvImageService,CandidateService candidateService) {
		super();
		this.cvImageService = cvImageService;
		this.candidateService = candidateService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestParam(value = "id") int id, @RequestParam(value = "imageFile") MultipartFile imageFile) {
		Candidate candidate = this.candidateService.getById(id).getData();
		CvImage cvImage= new CvImage();
		cvImage.setCandidate(candidate);
		return this.cvImageService.add(cvImage, imageFile);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CvImage>> getAll(){
		return this.cvImageService.getAll();
	}
	
	@GetMapping("getbycandidateid")
	public DataResult<CvImage> getByCandidateId(int candidateId){
		return this.cvImageService.getByCandidateId(candidateId);
	}
}

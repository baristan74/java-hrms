package javareact.hrms.api.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javareact.hrms.business.abstracts.CandidateService;
import javareact.hrms.business.abstracts.CvImageService;
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
	
	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@Valid @RequestParam(value = "candidateId") int candidateId, @RequestParam(value = "imageFile") MultipartFile imageFile){
        Candidate candidate = this.candidateService.getById(candidateId).getData();
		CvImage cvImage=new CvImage();
		cvImage.setCandidate(candidate);
        return ResponseEntity.ok(this.cvImageService.add(cvImage,imageFile));
    }
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.cvImageService.getAll());
	}
	
	@GetMapping("/getbycandidateid")
	public ResponseEntity<?> getByCandidateId(@RequestParam int candidateId){
		return ResponseEntity.ok(this.cvImageService.getByCandidateId(candidateId));
	}
}

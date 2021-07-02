package javareact.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javareact.hrms.business.abstracts.CvLinkService;
import javareact.hrms.entities.concretes.CvLink;

@RestController
@RequestMapping("/api/cvlinks")
@CrossOrigin
public class CvLinksController {
	
	private CvLinkService cvLinkService;

	@Autowired
	public CvLinksController(CvLinkService cvLinkService) {
		super();
		this.cvLinkService = cvLinkService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody CvLink cvLink) {
		return ResponseEntity.ok(this.cvLinkService.add(cvLink));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.cvLinkService.getAll()) ;
	}
	
	@GetMapping("/getallbycandidateId")
	public ResponseEntity<?> getAllByCandidateId(@RequestParam int candidateId){
		return ResponseEntity.ok(this.cvLinkService.getAllByCandidateId(candidateId));
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody CvLink cvLink) {
		return ResponseEntity.ok(this.cvLinkService.delete(cvLink));
	}
	

}

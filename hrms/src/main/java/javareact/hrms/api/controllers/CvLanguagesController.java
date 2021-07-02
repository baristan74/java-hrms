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

import javareact.hrms.business.abstracts.CvLanguageService;
import javareact.hrms.entities.concretes.CvLanguage;

@RestController
@RequestMapping("/api/cvlanguages")
@CrossOrigin
public class CvLanguagesController {
	private CvLanguageService cvLanguageService;

	@Autowired
	public CvLanguagesController(CvLanguageService cvLanguageService) {
		super();
		this.cvLanguageService = cvLanguageService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody CvLanguage cvLanguage) {
		return ResponseEntity.ok(this.cvLanguageService.add(cvLanguage));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.cvLanguageService.getAll());
	}
	
	@GetMapping("/getallbycandidateid")
	public ResponseEntity<?> getAllByCandidateId(@RequestParam int candidateId){
		return ResponseEntity.ok(this.cvLanguageService.getAllByCandidateId(candidateId));
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody CvLanguage cvLanguage) {
		return ResponseEntity.ok(this.cvLanguageService.delete(cvLanguage));
	}
}

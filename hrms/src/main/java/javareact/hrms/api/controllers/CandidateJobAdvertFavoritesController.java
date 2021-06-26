package javareact.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javareact.hrms.business.abstracts.CandidateJobAdvertFavoriteService;
import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.entities.concretes.CandidateJobAdvertFavorite;

@RestController
@RequestMapping("/api/candidatejobadvertfavorites")
@CrossOrigin
public class CandidateJobAdvertFavoritesController {
	
	private CandidateJobAdvertFavoriteService candidateJobAdvertFavoriteService;
	
	@Autowired
	public CandidateJobAdvertFavoritesController(CandidateJobAdvertFavoriteService candidateJobAdvertFavoriteService) {
		super();
		this.candidateJobAdvertFavoriteService = candidateJobAdvertFavoriteService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateJobAdvertFavorite candidateJobAdvertFavorite) {
		return this.candidateJobAdvertFavoriteService.add(candidateJobAdvertFavorite);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody CandidateJobAdvertFavorite candidateJobAdvertFavorite) {
		return this.candidateJobAdvertFavoriteService.delete(candidateJobAdvertFavorite);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CandidateJobAdvertFavorite>> getAll(){
		return this.candidateJobAdvertFavoriteService.getAll();
	}
	
	@GetMapping("/getallbycandidateid")
	public DataResult<List<CandidateJobAdvertFavorite>> getAllByCandidateId(@RequestParam int candidateId){
		return this.candidateJobAdvertFavoriteService.getAllByCandidateId(candidateId);
	}
	
	
}

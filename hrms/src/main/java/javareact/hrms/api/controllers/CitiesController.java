package javareact.hrms.api.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javareact.hrms.business.abstracts.CityService;
import javareact.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {
	
	private CityService cityService;
	
	@Autowired
	public CitiesController(CityService cityService) {
		super();
		this.cityService = cityService;
	}


	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.cityService.getAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody City city) {
		return ResponseEntity.ok(this.cityService.add(city));
	}
}

package javareact.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javareact.hrms.business.abstracts.AuthService;
import javareact.hrms.business.abstracts.CandidateService;
import javareact.hrms.business.abstracts.EmployerService;
import javareact.hrms.core.utilities.mail.MailService;
import javareact.hrms.core.utilities.results.ErrorResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.core.utilities.results.SuccessResult;
import javareact.hrms.entities.concretes.Candidate;
import javareact.hrms.entities.concretes.Employer;
@Service
public class AuthManager implements AuthService {

	private CandidateService candidateService;
	private EmployerService employerService;
	private MailService mailService;
	
	@Autowired
	public AuthManager(EmployerService employerService,CandidateService candidateService,MailService mailService) {
		super();
		this.employerService=employerService;
		this.candidateService = candidateService;
		this.mailService = mailService;
	}

	@Override
	public Result registerEmployer(Employer employer, String confirmedPassword) {
		

		if(!checkIfEqualsPasswordAndConfirmPassword(employer.getPassword(),confirmedPassword)) {
			return new ErrorResult("Parolalarınız uyuşmuyor");
			}
		
		
		
		var result =this.employerService.add(employer);
				
				if(result.isSuccess()) {
					
					this.mailService.send(employer.getEmail());
					return new SuccessResult("Employer Registered");
					
					
				}
				
				return this.employerService.add(employer);
			
			
	}

	@Override
	public Result registerCandidate(Candidate candidate, String confirmedPassword) {
		if(!checkIfEqualsPasswordAndConfirmPassword(candidate.getPassword(),confirmedPassword)) {
		return new ErrorResult("Parolalarınız uyuşmuyor");
		}
		
		var result =this.candidateService.add(candidate);
		
		if(result.isSuccess()) {
			
			this.mailService.send(candidate.getEmail());
			return new SuccessResult("Candidate Registered");
			
			
		}
		
		return this.candidateService.add(candidate);
		
		
	}

	private boolean checkIfEqualsPasswordAndConfirmPassword(String password,String confirmedPassword) {
		if(!password.equals(confirmedPassword)) {
			return false;
		}
		return true;
	}

}

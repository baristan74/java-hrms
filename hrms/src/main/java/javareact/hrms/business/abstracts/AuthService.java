package javareact.hrms.business.abstracts;

import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.entities.concretes.Candidate;
import javareact.hrms.entities.concretes.Employer;

public interface AuthService {
	Result registerEmployer(Employer employer,String confirmedPassword);
	Result registerCandidate(Candidate candidate,String confirmedPassword);
	
}

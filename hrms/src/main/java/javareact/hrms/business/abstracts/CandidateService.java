package javareact.hrms.business.abstracts;

import java.util.List;

import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.entities.concretes.Candidate;

public interface CandidateService {
	
	DataResult<List<Candidate>> getAll();

	Result add(Candidate candidate);
	
	DataResult<Candidate> getByIdentityNumber(String identityNumber);
	
	DataResult<Candidate> getByEmail(String email);
	
	DataResult<Candidate> getById(int id);
	
	
	
}

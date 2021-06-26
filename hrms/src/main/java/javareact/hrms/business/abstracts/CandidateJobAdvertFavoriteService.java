package javareact.hrms.business.abstracts;


import java.util.List;

import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.entities.concretes.CandidateJobAdvertFavorite;

public interface CandidateJobAdvertFavoriteService {
	 
	Result add(CandidateJobAdvertFavorite candidateJobAdvertFavorite);
	Result delete(CandidateJobAdvertFavorite candidateJobAdvertFavorite);
	DataResult<List<CandidateJobAdvertFavorite>> getAll();
	DataResult<List<CandidateJobAdvertFavorite>> getAllByCandidateId(int candidateId);
	

}

package javareact.hrms.business.abstracts;

import java.util.List;

import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.entities.concretes.CvCoverLetter;

public interface CvCoverLetterService {
	Result add(CvCoverLetter cvCoverLetter);
	DataResult<List<CvCoverLetter>> getAll();
	DataResult<CvCoverLetter> getById(int id);
	DataResult<List<CvCoverLetter>> getAllByCandidateId(int candidateId);
}

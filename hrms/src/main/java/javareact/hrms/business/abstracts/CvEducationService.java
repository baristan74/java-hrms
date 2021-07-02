package javareact.hrms.business.abstracts;

import java.util.List;

import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.entities.concretes.CvEducation;

public interface CvEducationService {
	
	Result add(CvEducation cvEducation);
	
	Result delete(CvEducation cvEducation);

	DataResult<List<CvEducation>> getAll();

	DataResult<List<CvEducation>> getAllByCandidateIdOrderByFinishDateDesc(int candidateId);

	DataResult<List<CvEducation>> getAllByCandidateId(int candidateId);
}

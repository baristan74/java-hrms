package javareact.hrms.business.abstracts;

import java.util.List;

import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.entities.concretes.CvJobExperience;

public interface CvJobExperienceService {
	Result add(CvJobExperience cvJobExperience);
	DataResult<List<CvJobExperience>> getAll();
	DataResult<List<CvJobExperience>> getAllByCandidateIdOrderByLeaveDateDesc(int candidateId);
	DataResult<List<CvJobExperience>> getAllByCandidateId(int candidateId);
	Result delete(CvJobExperience cvJobExperience);
}

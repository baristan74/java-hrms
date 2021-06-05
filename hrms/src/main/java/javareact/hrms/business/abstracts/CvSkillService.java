package javareact.hrms.business.abstracts;

import java.util.List;

import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.entities.concretes.CvSkill;

public interface CvSkillService {
	Result add(CvSkill cvSkill);
    DataResult<List<CvSkill>> getAll();
    DataResult<List<CvSkill>> getAllByCandidateId(int candidateId);
}

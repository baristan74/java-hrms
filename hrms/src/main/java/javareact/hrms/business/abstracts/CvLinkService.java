package javareact.hrms.business.abstracts;

import java.util.List;

import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.entities.concretes.CvLink;

public interface CvLinkService {
	Result add(CvLink cvLink);
    DataResult<List<CvLink>> getAll();
    DataResult<List<CvLink>> getAllByCandidateId(int candidateId);
    Result delete(CvLink cvLink);
}

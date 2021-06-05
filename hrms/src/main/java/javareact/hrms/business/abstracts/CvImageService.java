package javareact.hrms.business.abstracts;

import java.util.List;

import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.entities.concretes.CvImage;

public interface CvImageService {
	Result add(CvImage cvImage);
	DataResult<List<CvImage>> getAll();
	DataResult<List<CvImage>> getAllByCandidateId(int candidateId);
}

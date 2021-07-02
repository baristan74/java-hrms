package javareact.hrms.business.abstracts;

import java.util.List;

import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.entities.concretes.CvLanguage;

public interface CvLanguageService {
	Result add(CvLanguage cvLanguage);
	DataResult<List<CvLanguage>> getAll();
	DataResult<List<CvLanguage>> getAllByCandidateId(int candidateId);
	Result delete(CvLanguage cvLanguage);
}

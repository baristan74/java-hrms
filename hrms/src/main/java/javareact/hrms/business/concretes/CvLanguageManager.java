package javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javareact.hrms.business.abstracts.CvLanguageService;
import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.core.utilities.results.SuccessDataResult;
import javareact.hrms.core.utilities.results.SuccessResult;
import javareact.hrms.dataAccess.abstracts.CvLanguageDao;
import javareact.hrms.entities.concretes.CvLanguage;
@Service
public class CvLanguageManager implements CvLanguageService {

	private CvLanguageDao cvLanguageDao;

	@Autowired
	public CvLanguageManager(CvLanguageDao cvLanguageDao) {
		super();
		this.cvLanguageDao = cvLanguageDao;
	}

	@Override
	public Result add(CvLanguage cvLanguage) {
		this.cvLanguageDao.save(cvLanguage);
		return new SuccessResult("Language added");
	}

	@Override
	public DataResult<List<CvLanguage>> getAll() {
		
		return new SuccessDataResult<List<CvLanguage>>(this.cvLanguageDao.findAll());
	}

	@Override
	public DataResult<List<CvLanguage>> getAllByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<CvLanguage>>(this.cvLanguageDao.getAllByCandidateId(candidateId));
	}
}

package javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javareact.hrms.business.abstracts.CvEducationService;
import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.core.utilities.results.SuccessDataResult;
import javareact.hrms.core.utilities.results.SuccessResult;
import javareact.hrms.dataAccess.abstracts.CvEducationDao;
import javareact.hrms.entities.concretes.CvEducation;
@Service
public class CvEducationManager implements CvEducationService{
	
	private CvEducationDao cvEducationDao;
	
	@Autowired
	public CvEducationManager(CvEducationDao cvEducationDao) {
		super();
		this.cvEducationDao = cvEducationDao;
	}

	@Override
	public Result add(CvEducation cvEducation) {
		
		this.cvEducationDao.save(cvEducation);
		return new SuccessResult("School added.");
	}

	@Override
	public DataResult<List<CvEducation>> getAll() {
		return new SuccessDataResult<List<CvEducation>>(this.cvEducationDao.findAll());
	}

	@Override
	public DataResult<List<CvEducation>> getAllByCandidateIdOrderByFinishDateDesc(int candidateId) {
		
		return new SuccessDataResult<List<CvEducation>>(this.cvEducationDao.getAllByCandidateIdOrderByFinishDateDesc(candidateId));
	}

	@Override
	public DataResult<List<CvEducation>> getAllByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<CvEducation>>(this.cvEducationDao.getAllByCandidateId(candidateId));
	}

	@Override
	public Result delete(CvEducation cvEducation) {
		this.cvEducationDao.delete(cvEducation);
		return new SuccessResult("School deleted");
	}
}

package javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javareact.hrms.business.abstracts.CvJobExperienceService;
import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.core.utilities.results.SuccessDataResult;
import javareact.hrms.core.utilities.results.SuccessResult;
import javareact.hrms.dataAccess.abstracts.CvJobExperienceDao;
import javareact.hrms.entities.concretes.CvJobExperience;
@Service
public class CvJobExperienceManager implements CvJobExperienceService{
	
	private CvJobExperienceDao cvJobExperienceDao;
	
	@Autowired
	public CvJobExperienceManager(CvJobExperienceDao cvJobExperienceDao) {
		super();
		this.cvJobExperienceDao = cvJobExperienceDao;
	}

	@Override
	public Result add(CvJobExperience cvJobExperience) {
		this.cvJobExperienceDao.save(cvJobExperience);
		return new SuccessResult("Job Experience added.");
	}

	@Override
	public DataResult<List<CvJobExperience>> getAll() {
		
		return new SuccessDataResult<List<CvJobExperience>>(this.cvJobExperienceDao.findAll());
	}

	@Override
	public DataResult<List<CvJobExperience>> getAllByCandidateIdOrderByLeaveDateDesc(int candidateId) {
		
		return new SuccessDataResult<List<CvJobExperience>>(this.cvJobExperienceDao.getAllByCandidateIdOrderByLeaveDateDesc(candidateId));
	}

	@Override
	public DataResult<List<CvJobExperience>> getAllByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<CvJobExperience>>(this.cvJobExperienceDao.getAllByCandidateId(candidateId));
	}
	
}

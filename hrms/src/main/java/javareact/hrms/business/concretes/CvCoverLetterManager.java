package javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javareact.hrms.business.abstracts.CvCoverLetterService;
import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.core.utilities.results.SuccessDataResult;
import javareact.hrms.core.utilities.results.SuccessResult;
import javareact.hrms.dataAccess.abstracts.CvCoverLetterDao;
import javareact.hrms.entities.concretes.CvCoverLetter;
@Service
public class CvCoverLetterManager implements CvCoverLetterService{
	
	private CvCoverLetterDao cvCoverLetterDao;
	
	@Autowired
	public CvCoverLetterManager(CvCoverLetterDao cvCoverLetterDao) {
		super();
		this.cvCoverLetterDao = cvCoverLetterDao;
	}

	@Override
	public Result add(CvCoverLetter cvCoverLetter) {
		this.cvCoverLetterDao.save(cvCoverLetter);
		return new SuccessResult("Cover Letter added");
	}

	@Override
	public DataResult<List<CvCoverLetter>> getAll() {
		
		return new SuccessDataResult<List<CvCoverLetter>>(this.cvCoverLetterDao.findAll());
	}

	@Override
	public DataResult<CvCoverLetter> getById(int id) {
		
		return new SuccessDataResult<CvCoverLetter>(this.cvCoverLetterDao.getById(id));
	}

	@Override
	public DataResult<List<CvCoverLetter>> getAllByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<CvCoverLetter>>(this.cvCoverLetterDao.getAllByCandidateId(candidateId));
	}

}

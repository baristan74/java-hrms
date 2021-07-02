package javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javareact.hrms.business.abstracts.CvLinkService;
import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.core.utilities.results.SuccessDataResult;
import javareact.hrms.core.utilities.results.SuccessResult;
import javareact.hrms.dataAccess.abstracts.CvLinkDao;
import javareact.hrms.entities.concretes.CvLink;

@Service
public class CvLinkManager implements CvLinkService {

	private CvLinkDao cvLinkDao;

	@Autowired
	public CvLinkManager(CvLinkDao cvLinkDao) {
		super();
		this.cvLinkDao = cvLinkDao;
	}

	@Override
	public Result add(CvLink cvLink) {
		this.cvLinkDao.save(cvLink);
		return new SuccessResult("Cv Link added");
	}

	@Override
	public DataResult<List<CvLink>> getAll() {
		
		return new SuccessDataResult<List<CvLink>>(this.cvLinkDao.findAll());
	}

	@Override
	public DataResult<List<CvLink>> getAllByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<CvLink>>(this.cvLinkDao.getAllByCandidateId(candidateId));
	}

	@Override
	public Result delete(CvLink cvLink) {
		this.cvLinkDao.delete(cvLink);
		return new SuccessResult("Cv Link deleted");
	}
}

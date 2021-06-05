package javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javareact.hrms.business.abstracts.CvImageService;
import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.core.utilities.results.SuccessDataResult;
import javareact.hrms.core.utilities.results.SuccessResult;
import javareact.hrms.dataAccess.abstracts.CvImageDao;
import javareact.hrms.entities.concretes.CvImage;
@Service
public class CvImageManager implements CvImageService{
	
	private CvImageDao cvImageDao;
	
	@Autowired
	public CvImageManager(CvImageDao cvImageDao) {
		super();
		this.cvImageDao = cvImageDao;
	}

	@Override
	public Result add(CvImage cvImage) {
		this.cvImageDao.save(cvImage);
		return new SuccessResult("Image added.");
	}

	@Override
	public DataResult<List<CvImage>> getAll() {
		
		return new SuccessDataResult<List<CvImage>>(this.cvImageDao.findAll());
	}

	@Override
	public DataResult<List<CvImage>> getAllByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<CvImage>>(this.cvImageDao.getAllByCandidateId(candidateId));
	}

}

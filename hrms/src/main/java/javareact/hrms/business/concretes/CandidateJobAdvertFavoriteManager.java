package javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javareact.hrms.business.abstracts.CandidateJobAdvertFavoriteService;
import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.core.utilities.results.SuccessDataResult;
import javareact.hrms.core.utilities.results.SuccessResult;
import javareact.hrms.dataAccess.abstracts.CandidateJobAdvertFavoriteDao;
import javareact.hrms.entities.concretes.CandidateJobAdvertFavorite;
@Service
public class CandidateJobAdvertFavoriteManager implements CandidateJobAdvertFavoriteService{
	
	private CandidateJobAdvertFavoriteDao candidateJobAdvertFavoriteDao;

	@Autowired
	public CandidateJobAdvertFavoriteManager(CandidateJobAdvertFavoriteDao candidateJobAdvertFavoriteDao) {
		super();
		this.candidateJobAdvertFavoriteDao = candidateJobAdvertFavoriteDao;
	}

	@Override
	public Result add(CandidateJobAdvertFavorite candidateJobAdvertFavorite) {
		this.candidateJobAdvertFavoriteDao.save(candidateJobAdvertFavorite);
		return new SuccessResult("İş ilanı favorilere eklendi");
	}

	@Override
	public Result delete(CandidateJobAdvertFavorite candidateJobAdvertFavorite) {
		this.candidateJobAdvertFavoriteDao.delete(candidateJobAdvertFavorite);
		return new SuccessResult("İş ilanı favorilerden kaldırıldı");
	}

	@Override
	public DataResult<List<CandidateJobAdvertFavorite>> getAll() {
		
		return new SuccessDataResult<List<CandidateJobAdvertFavorite>>(this.candidateJobAdvertFavoriteDao.findAll());
	}

	@Override
	public DataResult<List<CandidateJobAdvertFavorite>> getAllByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<CandidateJobAdvertFavorite>>(this.candidateJobAdvertFavoriteDao.getAllByCandidateId(candidateId));
	}
	

}

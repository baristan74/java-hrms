package javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javareact.hrms.business.abstracts.CvSkillService;
import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.core.utilities.results.SuccessDataResult;
import javareact.hrms.core.utilities.results.SuccessResult;
import javareact.hrms.dataAccess.abstracts.CvSkillDao;
import javareact.hrms.entities.concretes.CvSkill;
@Service
public class CvSkillManager implements CvSkillService{
	
	private CvSkillDao cvSkillDao;
	
	@Autowired
	public CvSkillManager(CvSkillDao cvSkillDao) {
		super();
		this.cvSkillDao = cvSkillDao;
	}

	@Override
	public Result add(CvSkill cvSkill) {
		this.cvSkillDao.save(cvSkill);
		return new SuccessResult("Cv Skill Added");
	}

	@Override
	public DataResult<List<CvSkill>> getAll() {
		
		return new SuccessDataResult<List<CvSkill>>(this.cvSkillDao.findAll());
	}

	@Override
	public DataResult<List<CvSkill>> getAllByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<CvSkill>>(this.cvSkillDao.getAllByCandidateId(candidateId));
	}

}

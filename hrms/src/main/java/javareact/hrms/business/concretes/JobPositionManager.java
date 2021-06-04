package javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javareact.hrms.business.abstracts.JobPositionService;
import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.ErrorResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.core.utilities.results.SuccessDataResult;
import javareact.hrms.core.utilities.results.SuccessResult;
import javareact.hrms.dataAccess.abstracts.JobPositionDao;
import javareact.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{
	
	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}
	
	@Override
	public DataResult<List<JobPosition>> getAll() {
		
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"Job Positions Listed");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		if(getByPosition(jobPosition.getPosition()) != null) {
			return new ErrorResult("Aynı pozisyon zaten var.");
        }
		
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("Pozisyon eklendi");
		
	}

	
	@Override
    public DataResult<JobPosition> getByPosition(String position) {
        return new SuccessDataResult<>(this.jobPositionDao.getByPosition(position));
    }

}

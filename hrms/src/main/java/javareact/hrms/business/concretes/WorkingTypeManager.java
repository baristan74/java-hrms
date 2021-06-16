package javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javareact.hrms.business.abstracts.WorkingTypeService;
import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.core.utilities.results.SuccessDataResult;
import javareact.hrms.core.utilities.results.SuccessResult;
import javareact.hrms.dataAccess.abstracts.WorkingTypeDao;
import javareact.hrms.entities.concretes.WorkingType;
@Service
public class WorkingTypeManager implements WorkingTypeService{

	private WorkingTypeDao workingTypeDao;
	
	@Autowired
	public WorkingTypeManager(WorkingTypeDao workingTypeDao) {
		super();
		this.workingTypeDao = workingTypeDao;
	}

	@Override
	public Result add(WorkingType workingType) {
		this.workingTypeDao.save(workingType);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<WorkingType>> getAll() {
		
		return new SuccessDataResult<List<WorkingType>>(this.workingTypeDao.findAll());
	}
	
}

package javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javareact.hrms.business.abstracts.EmploymentTypeService;
import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.core.utilities.results.SuccessDataResult;
import javareact.hrms.core.utilities.results.SuccessResult;
import javareact.hrms.dataAccess.abstracts.EmploymentTypeDao;
import javareact.hrms.entities.concretes.EmploymentType;
@Service
public class EmploymentTypeManager implements EmploymentTypeService{

	private EmploymentTypeDao employmentTypeDao;
	
	@Autowired
	public EmploymentTypeManager(EmploymentTypeDao employmentTypeDao) {
		super();
		this.employmentTypeDao = employmentTypeDao;
	}

	@Override
	public Result add(EmploymentType employmentType) {
		this.employmentTypeDao.save(employmentType);
		return new SuccessResult("Employment Type Added");
	}

	@Override
	public DataResult<List<EmploymentType>> getAll() {
		
		return new SuccessDataResult<List<EmploymentType>>(this.employmentTypeDao.findAll());
	}

}

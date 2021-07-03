package javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javareact.hrms.business.abstracts.EmployerUpdateConfirmByEmployeeService;
import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.core.utilities.results.SuccessDataResult;
import javareact.hrms.core.utilities.results.SuccessResult;
import javareact.hrms.dataAccess.abstracts.EmployerUpdateConfirmByEmployeeDao;
import javareact.hrms.entities.concretes.EmployerUpdateConfirmByEmployee;
@Service
public class EmployerUpdateConfirmByEmployeeManager implements EmployerUpdateConfirmByEmployeeService{
	
	private EmployerUpdateConfirmByEmployeeDao employerUpdateConfirmByEmployeeDao;
	
	@Autowired
	public EmployerUpdateConfirmByEmployeeManager(
			EmployerUpdateConfirmByEmployeeDao employerUpdateConfirmByEmployeeDao) {
		super();
		this.employerUpdateConfirmByEmployeeDao = employerUpdateConfirmByEmployeeDao;
	}

	@Override
	public Result add(EmployerUpdateConfirmByEmployee employerUpdateConfirmByEmployee) {
		this.employerUpdateConfirmByEmployeeDao.save(employerUpdateConfirmByEmployee);
		return new SuccessResult("Confirm tablosuna eklendi");
	}

	@Override
	public Result delete(int id) {
		this.employerUpdateConfirmByEmployeeDao.deleteById(id);
		return new SuccessResult("Confirm tablosundan silindi");
	}

	@Override
	public DataResult<List<EmployerUpdateConfirmByEmployee>> getAlll() {
		
		return new SuccessDataResult<List<EmployerUpdateConfirmByEmployee>>(this.employerUpdateConfirmByEmployeeDao.findAll());
	}

	@Override
	public DataResult<EmployerUpdateConfirmByEmployee> getById(int employerId) {
		
		return new SuccessDataResult<EmployerUpdateConfirmByEmployee>(this.employerUpdateConfirmByEmployeeDao.getById(employerId));
	}

	@Override
	public DataResult<List<EmployerUpdateConfirmByEmployee>> getAllByConfirmFalse() {
		
		return new SuccessDataResult<List<EmployerUpdateConfirmByEmployee>>(this.employerUpdateConfirmByEmployeeDao.getAllByConfirmFalse());
	}

	@Override
	public Result changeIsConfirmedByEmployee(int employerId) {
		EmployerUpdateConfirmByEmployee employerIsConfirmByEmployee = this.employerUpdateConfirmByEmployeeDao.findById(employerId).get();
		employerIsConfirmByEmployee.setConfirmByEmployee(true);
		this.employerUpdateConfirmByEmployeeDao.save(employerIsConfirmByEmployee);
		return new SuccessResult("Şirket doğrulama durumu değiştirildi");
	}

}

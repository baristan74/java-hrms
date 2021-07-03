package javareact.hrms.business.abstracts;

import java.util.List;

import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.entities.concretes.EmployerUpdateConfirmByEmployee;

public interface EmployerUpdateConfirmByEmployeeService {
	
	Result add(EmployerUpdateConfirmByEmployee employerUpdateConfirmByEmployee);

	Result delete(int id);

	DataResult<List<EmployerUpdateConfirmByEmployee>> getAlll();
	
	DataResult<EmployerUpdateConfirmByEmployee> getById(int employerId);
	
	DataResult<List<EmployerUpdateConfirmByEmployee>> getAllByConfirmFalse();
	
	Result changeIsConfirmedByEmployee(int employerId);
}

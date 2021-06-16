package javareact.hrms.business.abstracts;

import java.util.List;

import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.entities.concretes.Employee;

public interface EmployeeService {
	Result add(Employee employee);
	DataResult<List<Employee>> getAll();
}

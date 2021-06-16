package javareact.hrms.business.abstracts;

import java.util.List;

import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.entities.concretes.EmploymentType;

public interface EmploymentTypeService {
	Result add(EmploymentType employmentType);
	DataResult<List<EmploymentType>> getAll();
}

package javareact.hrms.business.abstracts;

import java.util.List;

import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.entities.concretes.WorkingType;

public interface WorkingTypeService {
	Result add(WorkingType workingType);
	DataResult<List<WorkingType>> getAll();
}

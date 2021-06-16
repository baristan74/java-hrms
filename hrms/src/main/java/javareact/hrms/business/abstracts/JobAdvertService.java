package javareact.hrms.business.abstracts;

import java.util.List;

import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.entities.concretes.JobAdvert;

public interface JobAdvertService {
	Result add(JobAdvert jobAdvert);
	Result changeActiveStatus(int id);
	DataResult<JobAdvert> getById(int id);
	DataResult<List<JobAdvert>> getAll();
	DataResult<List<JobAdvert>> getAllByEmployer(int employerId);
	DataResult <List<JobAdvert>> getByIsActivated();
	DataResult<List<JobAdvert>> getAllSortedByPublishedDate();
	
	DataResult<List<JobAdvert>> getAllByIsConfirmedByEmployee();

	Result changeIsConfirmedByEmployee(int jobAdvertId);
	
	DataResult<List<JobAdvert>> getAllByIsConfirmedByEmployeeFalse();
	
}

package javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javareact.hrms.business.abstracts.JobAdvertService;
import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.ErrorResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.core.utilities.results.SuccessDataResult;
import javareact.hrms.core.utilities.results.SuccessResult;
import javareact.hrms.dataAccess.abstracts.JobAdvertDao;
import javareact.hrms.entities.concretes.JobAdvert;

@Service
public class JobAdvertManager implements JobAdvertService {

	private JobAdvertDao jobAdvertDao;

	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		if (!this.checkJobAdvertEmpty(jobAdvert)) {
			return new ErrorResult("Tüm alanları doldurduğunuzdan emin olun!");
		}
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("İş ilanı eklendi");
	}

	@Override
	public DataResult<List<JobAdvert>> getAll() {

		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(), "İş İlanları listelendi");
	}

	@Override
	public DataResult<List<JobAdvert>> getAllByEmployer(int employerId) {

		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getAllByEmployerId(employerId),
				"İş verene ait iş ilanları listelendi");
	}

	@Override
	public Result changeActiveStatus(int id) {
		JobAdvert jobAdvertToChangeActive = this.jobAdvertDao.findById(id).get();
		jobAdvertToChangeActive.setIsActivated(!jobAdvertToChangeActive.getIsActivated());
		this.jobAdvertDao.save(jobAdvertToChangeActive);
		return new SuccessResult("Success");
	}

	@Override
	public DataResult<List<JobAdvert>> getByIsActivated() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByIsActivated(),
				"Aktif iş ilanları listelendi");
	}

	@Override
	public DataResult<List<JobAdvert>> getAllSortedByPublishedDate() {

		Sort sort = Sort.by(Sort.Direction.DESC, "publishedDate");
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(sort));
	}

	@Override
	public DataResult<JobAdvert> getById(int id) {

		return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.findById(id).get());
	}

	@Override
	public DataResult<List<JobAdvert>> getAllByIsConfirmedByEmployee() {

		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getAllByIsConfirmedByEmployee(),
				("Aktif ve Doğrulanmış İlanları Desc Sıralandı"));
	}

	@Override
	public Result changeIsConfirmedByEmployee(int jobAdvertId) {
		JobAdvert jobAdvertIsConfirmEmployee = this.jobAdvertDao.findById(jobAdvertId).get();
		jobAdvertIsConfirmEmployee.setIsConfirmedByEmployee(true);
		this.jobAdvertDao.save(jobAdvertIsConfirmEmployee);
		return new SuccessResult("Success");
	}
	
	@Override
	public DataResult<List<JobAdvert>> getAllByIsConfirmedByEmployeeFalse() {
		
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getAllByIsConfirmedByEmployeeFalse());
	}

	// business rules
	private boolean checkJobAdvertEmpty(JobAdvert jobAdvert) {
		if (jobAdvert.getApplicationDeadline() == null && jobAdvert.getCity() == null
				&& jobAdvert.getOpenPositionCount() == 0) {

			return false;
		}
		return true;
	}

	

}

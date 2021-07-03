package javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javareact.hrms.business.abstracts.EmployerService;
import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.ErrorResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.core.utilities.results.SuccessDataResult;
import javareact.hrms.core.utilities.results.SuccessResult;
import javareact.hrms.dataAccess.abstracts.EmployerDao;
import javareact.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Employers Listed");
	}

	@Override
	public Result add(Employer employer) {

		if (!this.checkIfEqualEmailAndDomain(employer.getEmail(), employer.getWebAdress())) {
			return new ErrorResult("Email domaininizi kontrol ediniz");
		}
		//if (!this.checkIfEmailExists(employer.getEmail())) {
		//	return new ErrorResult("Bu Email adresi zaten mevcut");
		//}

		this.employerDao.save(employer);
		return new SuccessResult("Employer Added");

	}

	@Override
	public DataResult<Employer> getByEmail(String email) {

		return new SuccessDataResult<Employer>(this.employerDao.getByEmail(email));
	}
	
	@Override
	public DataResult<List<Employer>> getAllByConfirmed() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.getAllByConfirmed());
	}

	@Override
	public Result changeIsConfirmedByEmployee(int employerId) {
		Employer employerIsConfirmByEmployee = this.employerDao.findById(employerId).get();
		employerIsConfirmByEmployee.setConfirmByEmployee(true);
		this.employerDao.save(employerIsConfirmByEmployee);
		return new SuccessResult("Şirket doğrulama durumu değiştirildi");
	}
	
	@Override
	public DataResult<Employer> getById(int employerId) {
		
		return new SuccessDataResult<Employer>(this.employerDao.findById(employerId).orElse(null));
	}

	// Business Rules

	private boolean checkIfEqualEmailAndDomain(String email, String website) {
		String[] emailArr = email.split("@", 2); // @ gördüğünde böler 2 ayrı parçaya ve dizide tuttuk
		String domain = website.substring(4, website.length()); // 4. karakterden başlayıp website uzunluğu kadar alır
		// System.out.println(domain);
		// System.out.println(emailArr[1]);
		if (emailArr[1].equals(domain)) {
			return true;
		}
		return false;
	}

	private boolean checkIfEmailExists(String email) {
		if (this.employerDao.getByEmail(email) != null) {
			return false;
		}
		return true;
	}

	



}

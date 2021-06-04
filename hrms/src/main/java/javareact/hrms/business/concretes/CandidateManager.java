package javareact.hrms.business.concretes;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javareact.hrms.business.abstracts.CandidateService;
import javareact.hrms.core.utilities.adapters.mernis.UserCheckService;
import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.ErrorResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.core.utilities.results.SuccessDataResult;
import javareact.hrms.core.utilities.results.SuccessResult;
import javareact.hrms.dataAccess.abstracts.CandidateDao;
import javareact.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	private UserCheckService userCheckService;
	
	
	@Autowired
	public CandidateManager(UserCheckService userCheckService,CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
		this.userCheckService=userCheckService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"Candidates Listed") ;
	}

	@Override
	public Result add(Candidate candidate) {
		
		if(!this.checkIfCandidateEmpty(candidate)) {
			return new ErrorResult("Boş Alanları doldurunuz");
		}
		
		if(!this.checkIfRealPerson(candidate)) {
			return new ErrorResult("Mernis doğrulaması geçersiz");
		}
		if(!this.checkIfEmailExists(candidate.getEmail())) {
			return new ErrorResult("Bu Email adresi zaten mevcut");
		}
		if(!this.checkIfIdentityNumber(candidate.getIdentityNumber())) {
			return new ErrorResult("Bu kimlik numarası zaten mevcut");
		}
		if (!this.checkEmailIsCorrect(candidate.getEmail())) {
			return new ErrorResult("Email adresi istenilen formatta değil");
		}
		
		
			this.candidateDao.save(candidate);
			return new SuccessResult("Candidate Added");
	}

	@Override
	public DataResult<Candidate> getByIdentityNumber(String identityNumber) {
		
		return new SuccessDataResult<Candidate>(this.candidateDao.getByIdentityNumber(identityNumber));
	}
	
	@Override
	public DataResult<Candidate> getByEmail(String email) {
		
		return new SuccessDataResult<Candidate>(this.candidateDao.getByEmail(email));
	}
	
	@Override
    public DataResult<Candidate> getById(int id) {
        return new SuccessDataResult<>(this.candidateDao.findById(id).get());
    }
	
	 
	
	
	//Busines Rules
	private boolean checkIfEmailExists(String email) {
		if(this.candidateDao.getByEmail(email)!=null) {
			return false;
		}
		return true;
	}
	
	private boolean checkIfIdentityNumber(String identityNumber) {
		if(this.candidateDao.getByIdentityNumber(identityNumber)!=null) {
			return false;
		}
		return true;
	}
	private boolean checkIfRealPerson(Candidate candidate) {
		if(!this.userCheckService.checkIfRealPerson(candidate.getIdentityNumber(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate())) {
			return false;
		}
		return true;
	}
	private boolean checkIfCandidateEmpty(Candidate candidate) {
		if(candidate.getEmail() == null && candidate.getBirthDate() == null && candidate.getFirstName() == null
				&& candidate.getIdentityNumber() == null && candidate.getLastName() == null
				&& candidate.getPassword() == null) {
			return false;
		}
		return true;
	}
	private boolean checkEmailIsCorrect(String email) {
		String EMAILPATTERN = "^[A-Z0-9.%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
        Pattern pattern = Pattern.compile(EMAILPATTERN,    Pattern.CASE_INSENSITIVE);
        if(!pattern.matcher(email).find()){
            
            return false;
        }
        return true;
	}
	
	
	
	
}

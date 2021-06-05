package javareact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javareact.hrms.business.abstracts.CandidateService;
import javareact.hrms.business.abstracts.CvCoverLetterService;
import javareact.hrms.business.abstracts.CvEducationService;
import javareact.hrms.business.abstracts.CvImageService;
import javareact.hrms.business.abstracts.CvJobExperienceService;
import javareact.hrms.business.abstracts.CvLanguageService;
import javareact.hrms.business.abstracts.CvLinkService;
import javareact.hrms.business.abstracts.CvSkillService;
import javareact.hrms.core.utilities.adapters.mernis.UserCheckService;
import javareact.hrms.core.utilities.results.DataResult;
import javareact.hrms.core.utilities.results.ErrorResult;
import javareact.hrms.core.utilities.results.Result;
import javareact.hrms.core.utilities.results.SuccessDataResult;
import javareact.hrms.core.utilities.results.SuccessResult;
import javareact.hrms.dataAccess.abstracts.CandidateDao;
import javareact.hrms.entities.concretes.Candidate;
import javareact.hrms.entities.dtos.CandidateCvDto;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private UserCheckService userCheckService;
	private CvCoverLetterService cvCoverLetterService;
	private CvEducationService cvEducationService;
	private CvImageService cvImageService;
	private CvJobExperienceService cvJobExperienceService;
	private CvLanguageService cvLanguageService;
	private CvLinkService cvLinkService;
	private CvSkillService cvSkillService;

	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, UserCheckService userCheckService,
			CvCoverLetterService cvCoverLetterService, CvEducationService cvEducationService,
			CvImageService cvImageService, CvJobExperienceService cvJobExperienceService,
			CvLanguageService cvLanguageService, CvLinkService cvLinkService, CvSkillService cvSkillService) {
		super();
		this.candidateDao = candidateDao;
		this.userCheckService = userCheckService;
		this.cvCoverLetterService = cvCoverLetterService;
		this.cvEducationService = cvEducationService;
		this.cvImageService = cvImageService;
		this.cvJobExperienceService = cvJobExperienceService;
		this.cvLanguageService = cvLanguageService;
		this.cvLinkService = cvLinkService;
		this.cvSkillService = cvSkillService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Candidates Listed");
	}

	@Override
	public Result add(Candidate candidate) {

		if (!this.checkIfRealPerson(candidate)) {
			return new ErrorResult("Mernis doğrulaması geçersiz");
		}
		if (!this.checkIfEmailExists(candidate.getEmail())) {
			return new ErrorResult("Bu Email adresi zaten mevcut");
		}
		if (!this.checkIfIdentityNumber(candidate.getIdentityNumber())) {
			return new ErrorResult("Bu kimlik numarası zaten mevcut");
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
	public DataResult<Candidate> getById(int candidateId) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getById(candidateId));
	}
	
	
	@Override
	public DataResult<CandidateCvDto> getCvByCandidateId(int candidateId) {
		CandidateCvDto candidateCvDto = new CandidateCvDto();
		candidateCvDto.setCandidate(this.getById(candidateId).getData());
		candidateCvDto.setEducations(this.cvEducationService.getAllByCandidateIdOrderByFinishDateDesc(candidateId).getData());
		candidateCvDto.setCoverletters(this.cvCoverLetterService.getAllByCandidateId(candidateId).getData());
		candidateCvDto.setImage(this.cvImageService.getByCandidateId(candidateId).getData());
		candidateCvDto.setJobExperiences(this.cvJobExperienceService.getAllByCandidateIdOrderByLeaveDateDesc(candidateId).getData());
		candidateCvDto.setLanguages(this.cvLanguageService.getAllByCandidateId(candidateId).getData());
		candidateCvDto.setLinks(this.cvLinkService.getAllByCandidateId(candidateId).getData());
		candidateCvDto.setSkills(this.cvSkillService.getAllByCandidateId(candidateId).getData());
		return new SuccessDataResult<CandidateCvDto>(candidateCvDto);
	}

	// Busines Rules
	private boolean checkIfEmailExists(String email) {
		if (this.candidateDao.getByEmail(email) != null) {
			return false;
		}
		return true;
	}

	private boolean checkIfIdentityNumber(String identityNumber) {
		if (this.candidateDao.getByIdentityNumber(identityNumber) != null) {
			return false;
		}
		return true;
	}

	private boolean checkIfRealPerson(Candidate candidate) {
		if (!this.userCheckService.checkIfRealPerson(candidate.getIdentityNumber(), candidate.getFirstName(),
				candidate.getLastName(), candidate.getBirthDate())) {
			return false;
		}
		return true;
	}

	

}

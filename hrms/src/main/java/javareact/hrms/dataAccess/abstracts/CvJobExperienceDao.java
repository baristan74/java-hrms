package javareact.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javareact.hrms.entities.concretes.CvJobExperience;

public interface CvJobExperienceDao extends JpaRepository<CvJobExperience,Integer>{
	List<CvJobExperience> getAllByCandidateIdOrderByLeaveDateDesc(int candidateId);
	List<CvJobExperience> getAllByCandidateId(int candidateId);
}

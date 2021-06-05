package javareact.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javareact.hrms.entities.concretes.CvEducation;

public interface CvEducationDao extends JpaRepository<CvEducation,Integer>{
	List<CvEducation> getAllByCandidateIdOrderByFinishDateDesc(int candidateId);
	List<CvEducation> getAllByCandidateId(int candidateId);
}

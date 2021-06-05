package javareact.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javareact.hrms.entities.concretes.CvCoverLetter;

public interface CvCoverLetterDao extends JpaRepository<CvCoverLetter, Integer>{
	CvCoverLetter getById(int id);
	List<CvCoverLetter> getAllByCandidateId(int candidateId);
}

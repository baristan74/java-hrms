package javareact.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javareact.hrms.entities.concretes.CvSkill;

public interface CvSkillDao extends JpaRepository<CvSkill,Integer>{
	List<CvSkill> getAllByCandidateId(int candidateId);
}

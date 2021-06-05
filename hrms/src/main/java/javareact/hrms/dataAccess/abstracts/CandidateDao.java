package javareact.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import javareact.hrms.entities.concretes.Candidate;


public interface CandidateDao extends JpaRepository<Candidate,Integer>{
	Candidate getByIdentityNumber(String identityNumber);
	Candidate getByEmail(String email);
	Candidate getById(int candidateId);
	
	
}

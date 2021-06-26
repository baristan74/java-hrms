package javareact.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javareact.hrms.entities.concretes.CandidateJobAdvertFavorite;

public interface CandidateJobAdvertFavoriteDao extends JpaRepository<CandidateJobAdvertFavorite,Integer>{
		
	List<CandidateJobAdvertFavorite> getAllByCandidateId(int candidateId);
	//CandidateJobAdvertFavorite getByJobAdvert_Id(int jobAdvertId);

}

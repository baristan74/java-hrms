package javareact.hrms.dataAccess.abstracts;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javareact.hrms.entities.concretes.CvImage;

public interface CvImageDao extends JpaRepository<CvImage,Integer>{
	
	CvImage findByCandidate_Id(int candidateId);
}

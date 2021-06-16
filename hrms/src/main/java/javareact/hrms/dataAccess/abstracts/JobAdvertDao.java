package javareact.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javareact.hrms.entities.concretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert,Integer>{
	
	List<JobAdvert> getAllByEmployerId(int employerId);
	
	@Query("From JobAdvert where is_activated=true")
	List<JobAdvert> getByIsActivated();
	
	
	@Query("From JobAdvert where is_confirmed_by_employee=true AND is_activated=true Order By published_date DESC")
	List<JobAdvert> getAllByIsConfirmedByEmployee();
	
	@Query("From JobAdvert where is_confirmed_by_employee=false Order By published_date DESC")
	List<JobAdvert> getAllByIsConfirmedByEmployeeFalse();
	
	
	
	
}

package javareact.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javareact.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer,Integer>{
	Employer getByEmail(String email);
	
	@Query("From Employer where is_confirm_by_employee=false")
	List<Employer> getAllByConfirmed();
}

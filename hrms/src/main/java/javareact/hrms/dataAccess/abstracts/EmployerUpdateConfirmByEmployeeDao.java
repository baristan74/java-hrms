package javareact.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javareact.hrms.entities.concretes.EmployerUpdateConfirmByEmployee;

public interface EmployerUpdateConfirmByEmployeeDao extends JpaRepository<EmployerUpdateConfirmByEmployee,Integer>{

	EmployerUpdateConfirmByEmployee getById(int id);
	
	@Query("From EmployerUpdateConfirmByEmployee where is_confirm_by_employee=false")
	List<EmployerUpdateConfirmByEmployee> getAllByConfirmFalse();
}

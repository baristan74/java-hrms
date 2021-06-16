package javareact.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javareact.hrms.entities.concretes.EmploymentType;

public interface EmploymentTypeDao extends JpaRepository<EmploymentType,Integer>{

}

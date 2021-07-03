package javareact.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javareact.hrms.entities.concretes.JobAdvert;
import javareact.hrms.entities.dtos.JobAdvertFilter;

public interface JobAdvertDao extends JpaRepository<JobAdvert,Integer>{
	
	List<JobAdvert> getAllByEmployerId(int employerId);
	
	@Query("From JobAdvert where is_activated=true")
	List<JobAdvert> getByIsActivated();
	
	
	@Query("From JobAdvert where is_confirmed_by_employee=true AND is_activated=true Order By published_date DESC")
	List<JobAdvert> getAllByIsConfirmedByEmployee();
	
	@Query("From JobAdvert where is_confirmed_by_employee=false Order By published_date DESC")
	List<JobAdvert> getAllByIsConfirmedByEmployeeFalse();
	
	@Query("From JobAdvert where is_confirmed_by_employee=true AND is_activated=true Order By published_date DESC")
	List<JobAdvert> getAllByIsConfirmedByEmployee(Pageable pageable);
	
	//@Query("SELECT j FROM JobAdvert j WHERE ((:#{#filter.cityId}) IS NULL OR j.city.id IN (:#{#filter.cityId}))"
	 //      +" and ((:#{#filter.jobPositionId}) IS NULL OR j.jobPosition.id IN (:#{#filter.jobPositionId}))"
	  //     +" and ((:#{#filter.workingTypeId}) IS NULL OR j.workingType.id IN (:#{#filter.workingTypeId}))"
	  //     +" and ((:#{#filter.employmentTypeId}) IS NULL OR j.employmentType.id IN (:#{#filter.employmentTypeId}))"
	  //      +" and j.isActivated=true" + "and j.isConfirmedByEmployee=true")
	 // public Page<JobAdvert> getByFilter(@Param("filter") JobAdvertFilter jobAdvertFilter, Pageable pageable);
	
	
	
	
	
}

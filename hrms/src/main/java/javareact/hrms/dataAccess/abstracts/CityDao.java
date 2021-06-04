package javareact.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javareact.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City,Integer>{

}

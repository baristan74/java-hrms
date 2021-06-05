package javareact.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javareact.hrms.entities.concretes.LinkType;

public interface LinkTypeDao extends JpaRepository<LinkType,Integer> {
}

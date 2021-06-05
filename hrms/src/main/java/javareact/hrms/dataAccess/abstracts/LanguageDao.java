package javareact.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javareact.hrms.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language,Integer> {
}

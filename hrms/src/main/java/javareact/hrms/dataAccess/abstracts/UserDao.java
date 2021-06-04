package javareact.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javareact.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User,Integer>{
	 User getByEmail(String email);
}

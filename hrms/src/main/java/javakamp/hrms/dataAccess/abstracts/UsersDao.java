package javakamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javakamp.hrms.entities.concretes.User;

public interface UsersDao extends JpaRepository<User, Integer> {

	List<User> findAllByEmail(String email);
	
	
}

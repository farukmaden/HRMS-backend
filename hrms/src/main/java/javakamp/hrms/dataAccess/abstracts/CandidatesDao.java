package javakamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javakamp.hrms.entities.concretes.Candidate;
import javakamp.hrms.entities.concretes.User;

@Repository
public interface CandidatesDao extends JpaRepository<Candidate , Integer>{
	
	List<User> findAllByIdentityNumber(String identity_number);
}
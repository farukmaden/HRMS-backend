package javakamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javakamp.hrms.entities.concretes.Employer;

public interface EmployersDao extends JpaRepository<Employer, Integer>{

}

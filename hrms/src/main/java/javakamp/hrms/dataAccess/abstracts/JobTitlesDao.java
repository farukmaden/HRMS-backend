package javakamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javakamp.hrms.entities.concretes.JobTitle;

public interface JobTitlesDao extends JpaRepository<JobTitle, Integer>{

	List<JobTitle> findAllByTitle(String title);
}

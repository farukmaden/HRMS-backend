package javakamp.hrms.dataAccess.abstracts;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javakamp.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementsDao extends JpaRepository<JobAdvertisement, Integer> {
	
	List<JobAdvertisement> getByIsActiveTrue();
	
	List<JobAdvertisement> getByIsActiveTrueAndEmployer_id(int id);
	
	List<JobAdvertisement> getByIsActiveTrueOrderByApplicationDeadline();
}

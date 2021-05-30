package javakamp.hrms.business.abstracts;

import java.util.List;

import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementsService {

	DataResult<List<JobAdvertisement>> getAll();
	
	Result add (JobAdvertisement jobAdvertisement);
	
	DataResult<List<JobAdvertisement>> getByIsActiveTrue();
	
	DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployer_id(int id);
	
	DataResult<JobAdvertisement> getUpdate(int id);
	
	DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByApplicationDeadline();
}

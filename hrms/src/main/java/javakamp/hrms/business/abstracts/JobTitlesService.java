package javakamp.hrms.business.abstracts;

import java.util.List;

import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.entities.concretes.JobTitle;

public interface JobTitlesService {
	
	
	
	DataResult<List<JobTitle>> getAll();
	
	Result record (JobTitle jobTitle);
	

}

package javakamp.hrms.business.abstracts;

import java.util.List;

import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.entities.concretes.Employer;

public interface EmployersService {
	
	DataResult<List<Employer>> getAll();
	
	Result record (Employer employer);
}

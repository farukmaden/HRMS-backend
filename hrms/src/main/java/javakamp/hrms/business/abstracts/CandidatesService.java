package javakamp.hrms.business.abstracts;

import java.util.List;

import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.entities.concretes.Candidate;

public interface CandidatesService {
	DataResult<List<Candidate>> getAll();
	Result record(Candidate candidate);
	
}

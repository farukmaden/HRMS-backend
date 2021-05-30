package javakamp.hrms.business.abstracts;

import java.util.List;

import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.entities.concretes.City;

public interface CityService {

	DataResult <List<City>> getAll();
	
	Result add (City city);
}

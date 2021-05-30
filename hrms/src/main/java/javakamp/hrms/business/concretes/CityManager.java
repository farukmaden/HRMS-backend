package javakamp.hrms.business.concretes;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javakamp.hrms.business.abstracts.CityService;
import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.core.utilities.results.SuccessDataResult;
import javakamp.hrms.core.utilities.results.SuccessResult;
import javakamp.hrms.dataAccess.abstracts.CityDao;
import javakamp.hrms.entities.concretes.City;
@Service
public class CityManager implements CityService{

	private CityDao cityDao;
	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult <List<City>>(this.cityDao.findAll(),"adasda");
	}

	@Override
	public Result add(City city) {
		this.cityDao.save(city);
		return new SuccessResult(true,"şehir başarıyla eklendi");
	}

}

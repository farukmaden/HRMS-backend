package javakamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javakamp.hrms.business.abstracts.JobAdvertisementsService;
import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.core.utilities.results.SuccessDataResult;
import javakamp.hrms.core.utilities.results.SuccessResult;
import javakamp.hrms.dataAccess.abstracts.JobAdvertisementsDao;
import javakamp.hrms.entities.concretes.JobAdvertisement;
import net.bytebuddy.asm.Advice.This;
@Service
public class JobAdvertisementsManager implements JobAdvertisementsService {

	private JobAdvertisementsDao jobAdvertisementsDao;
	
	@Autowired
	public JobAdvertisementsManager(JobAdvertisementsDao jobAdvertisementsDao) {
		super();
		this.jobAdvertisementsDao = jobAdvertisementsDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementsDao.save(jobAdvertisement);
		return new SuccessResult(true , "İş ialnı başarıyla eklendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementsDao.findAll(),"İş ilanları listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrue() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementsDao.getByIsActiveTrue(),"data listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployer_id(int id) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementsDao.getByIsActiveTrueAndEmployer_id(id),"data listelendi");
	}

	

	@Override
	public DataResult<JobAdvertisement> getUpdate(int id) {
		JobAdvertisement jobAdvertisement =jobAdvertisementsDao.getOne(id);
		jobAdvertisement.setActive(false);
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementsDao.save(jobAdvertisement),"ialn pasif hale getirildi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByApplicationDeadline() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementsDao.getByIsActiveTrueOrderByApplicationDeadline(),"data listelendi");
	}

	

	
	

	

	
	

	

}

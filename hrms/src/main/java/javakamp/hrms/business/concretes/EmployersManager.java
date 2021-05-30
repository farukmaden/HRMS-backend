package javakamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javakamp.hrms.business.abstracts.EmployersService;
import javakamp.hrms.core.abstracts.MailVerificationService;
import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.ErrorResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.core.utilities.results.SuccessDataResult;
import javakamp.hrms.core.utilities.results.SuccessResult;
import javakamp.hrms.dataAccess.abstracts.EmployersDao;
import javakamp.hrms.dataAccess.abstracts.UsersDao;
import javakamp.hrms.entities.concretes.Employer;
@Service
public class EmployersManager implements EmployersService{

	private UsersDao usersDao;
	private EmployersDao employersDao;
	private MailVerificationService mailVerificationService;

	@Autowired
	public EmployersManager(EmployersDao employersDao,UsersDao usersDao,MailVerificationService mailVerificationService) {
		super();
		this.employersDao = employersDao;
		this.usersDao = usersDao;
		this.mailVerificationService =  mailVerificationService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employersDao.findAll(),"Başarıyla listelendi.");
	}

	@Override
	public Result record(Employer employer) {
		if(!companyNameControl(employer)) {
			return new ErrorResult("Şirket ismi boş kalamaz.");
		}else if(!webAddressControl(employer)) {
			return new ErrorResult("Web adres kısmı boş kalamaz");
		}else if(!emailControl(employer)) {
			return new ErrorResult("E-mail kısmı boş kalamaz");
		}else if(!passwordControl(employer)) {
			return new ErrorResult("Şifre kısmı boş kalamaz");
		}else if(employer.getPassword().equals(employer.getPasswordRepeat()) == false) {
			return new ErrorResult("Şifreler uyuşmuyor");
		}else if(!phoneNumberControl(employer)) {
			return new ErrorResult("Telefon numarası kısmı boş kalamaz");
			
		}else if(!mailAndWebbaddressControl(employer)){
			return new ErrorResult("E-mailiniz web adresinizdeki domain ile aynı değil.");
			
		}else if(usersDao.findAllByEmail(employer.getEmail()).stream().count() !=0){
			return new ErrorResult("E-mail kullanımda");
		}
		this.mailVerificationService.mailVerification(employer);
		this.employersDao.save(employer);
		return new SuccessResult(true , "eklendi");
	}
	
	public boolean companyNameControl (Employer employer) {
		if(employer.getCompanyName().isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
	public boolean webAddressControl(Employer employer) {
		if(employer.getWebAddress().isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
	public boolean emailControl(Employer employer ) {
		if(employer.getEmail().isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
	public boolean passwordControl(Employer employer ) {
		if(employer.getPassword().isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
	public boolean phoneNumberControl(Employer employer) {
		if(employer.getPhoneNumber().isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
	public boolean mailAndWebbaddressControl(Employer employer) {
		String [] splitMail = employer.getEmail().split("@");
		String []splitWebaddress = employer.getWebAddress().split("www.");
		if(!splitMail[1].equals(splitWebaddress[1])) {
			return false;
		}else {
			return true;
		}
	}

}




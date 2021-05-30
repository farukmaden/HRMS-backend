package javakamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javakamp.hrms.business.abstracts.CandidatesService;
import javakamp.hrms.core.abstracts.MailVerificationService;
import javakamp.hrms.core.abstracts.MernisVerificationService;
import javakamp.hrms.core.utilities.results.DataResult;
import javakamp.hrms.core.utilities.results.ErrorResult;
import javakamp.hrms.core.utilities.results.Result;
import javakamp.hrms.core.utilities.results.SuccessDataResult;
import javakamp.hrms.core.utilities.results.SuccessResult;
import javakamp.hrms.dataAccess.abstracts.CandidatesDao;
import javakamp.hrms.dataAccess.abstracts.UsersDao;
import javakamp.hrms.entities.concretes.Candidate;

@Service
public class CandidatesManager implements CandidatesService {

	private MailVerificationService mailVerificationService;
	private UsersDao usersDao;
	private CandidatesDao candidatesDao;
	private MernisVerificationService mernisVerificationService;

	@Autowired
	public CandidatesManager(CandidatesDao candidatesDao, UsersDao usersDao,
			MailVerificationService mailVerificationService, MernisVerificationService mernisVerificationService) {
		super();
		this.candidatesDao = candidatesDao;
		this.usersDao = usersDao;
		this.mailVerificationService = mailVerificationService;
		this.mernisVerificationService = mernisVerificationService;
	}

	@Override
	public Result record(Candidate candidate) {
		if (!firstNameControl(candidate)) {
			return new ErrorResult(false, "isim kısmı boş kalamaz");
		} else if (!lastNameControl(candidate)) {
			return new ErrorResult("soyisim kısmı boş kalamaz");
		} else if (!emailControl(candidate)) {
			return new ErrorResult("mail kısmı boş kalamaz");
		} else if (!identityNumberControl(candidate)) {
			return new ErrorResult("tc no kısmı boş kalamaz");
		} else if (!passwordControl(candidate)) {
			return new ErrorResult("şifre kısmı bış kalamaz");
		} else if (!birthDateControl(candidate)) {
			return new ErrorResult("doğum tarihi kısmı boş kalamaz");
		} else if (usersDao.findAllByEmail(candidate.getEmail()).stream().count() != 0) {
			return new ErrorResult("mail adresi kullanımda");
		} else if (emailTypeControl(candidate)) {
			return new ErrorResult("mail adresiniz mail formatında değil !");
		} else if (candidate.getPassword().equals(candidate.getPasswordRepeat()) == false) {
			return new ErrorResult("Şifreler Uyuşmuyor");
		} else if (mernisVerificationService.mernisVerification(candidate) == false) {
			return new ErrorResult("mernis doğrulamsı geçersiz");
		} else if (candidatesDao.findAllByIdentityNumber(candidate.getIdentityNumber()).stream().count() != 0) {
			return new ErrorResult("Tc numarası kullanımda");
		}else {
			this.mailVerificationService.mailVerification(candidate);
		this.candidatesDao.save(candidate);
		return new SuccessResult(true, "kayıt başarılı");
		}
		
	}

	@Override
	public DataResult<List<Candidate>> getAll() {

		return new SuccessDataResult<List<Candidate>>(this.candidatesDao.findAll(), "Başarıyla listelendi.");
	}

	public boolean firstNameControl(Candidate candidate) {
		if (candidate.getFirstName().isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	public boolean lastNameControl(Candidate candidate) {
		if (candidate.getLastName().isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	public boolean emailControl(Candidate candidate) {
		if (candidate.getEmail().isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	public boolean passwordControl(Candidate candidate) {
		if (candidate.getPassword().isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	public boolean identityNumberControl(Candidate candidate) {
		if (candidate.getIdentityNumber().isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	public boolean birthDateControl(Candidate candidate) {
		if (candidate.getBirthDate() == null) {
			return false;
		} else {
			return true;
		}
	}

	public boolean emailTypeControl(Candidate candidate) {
		if (candidate.getEmail().contains("@")) {
			return false;
		} else {
			return true;
		}
	}

}







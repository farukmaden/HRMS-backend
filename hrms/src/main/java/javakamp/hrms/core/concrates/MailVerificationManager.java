package javakamp.hrms.core.concrates;

import org.springframework.stereotype.Service;

import javakamp.hrms.core.abstracts.MailVerificationService;
import javakamp.hrms.entities.concretes.User;
@Service
public class MailVerificationManager implements MailVerificationService{

	@Override
	public void mailVerification(User user) {
		System.out.println(user.getEmail() + "mail adresine kod gönderildi");
		System.out.println("mail adresi doğrulandı");
		
	}

	
	

}

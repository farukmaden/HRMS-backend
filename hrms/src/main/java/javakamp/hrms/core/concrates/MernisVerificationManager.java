package javakamp.hrms.core.concrates;

import org.springframework.stereotype.Service;

import javakamp.hrms.core.abstracts.MernisVerificationService;
import javakamp.hrms.entities.concretes.Candidate;
@Service
public class MernisVerificationManager implements MernisVerificationService {

	@Override
	public boolean mernisVerification(Candidate candidate) {
		if(candidate.getIdentityNumber().length()!=11) {
			System.out.println("mernis doğrulaması başarısız");
			return false;
		}else {
			System.out.println("mernis doğrulaması başarılı");
			return true;
		}
	}

}

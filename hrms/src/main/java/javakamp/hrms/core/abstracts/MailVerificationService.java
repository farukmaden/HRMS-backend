package javakamp.hrms.core.abstracts;

import javakamp.hrms.entities.concretes.User;

public interface MailVerificationService {
	void mailVerification (User user);
}

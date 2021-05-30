package javakamp.hrms.core.abstracts;

import javakamp.hrms.entities.concretes.Candidate;

public interface MernisVerificationService {
	boolean mernisVerification (Candidate candidate);
}

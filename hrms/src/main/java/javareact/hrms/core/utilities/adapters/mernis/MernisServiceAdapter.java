package javareact.hrms.core.utilities.adapters.mernis;



import org.springframework.stereotype.Service;

import javareact.hrms.mernisService.FakeMernisService;

@Service
public class MernisServiceAdapter implements UserCheckService {

	@Override
	public boolean checkIfRealPerson(String identityNumber, String firstName, String lastName, String dateOfBirth) {
		
		FakeMernisService client = new FakeMernisService();

		boolean result = client.TCKimlikDogrula(identityNumber, firstName, lastName, dateOfBirth);

		return result;
	}

	

}

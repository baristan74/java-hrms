package javareact.hrms.core.utilities.adapters.mernis;



public interface UserCheckService {
	boolean checkIfRealPerson(String identityNumber, String firstName, String lastName,String dateOfBirth);
}

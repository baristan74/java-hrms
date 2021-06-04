package javareact.hrms.core.utilities.mail;

import org.springframework.stereotype.Service;


@Service
public class MailManager implements MailService{

	
	public void send(String email) {
		System.out.println("Email gönderildi" + email);
		//Burası refactor edilicek
	}

}

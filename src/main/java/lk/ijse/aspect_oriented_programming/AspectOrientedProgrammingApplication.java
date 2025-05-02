package lk.ijse.aspect_oriented_programming;

import lk.ijse.aspect_oriented_programming.dao.AccountDAO;
import lk.ijse.aspect_oriented_programming.dao.MemberShipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AspectOrientedProgrammingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AspectOrientedProgrammingApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(AccountDAO accountDAO, MemberShipDAO memberShipDAO) {
		return runner->{
			demoBeforeAdvice(accountDAO,memberShipDAO);

		};
	}


	private void demoBeforeAdvice(AccountDAO accountDAO,MemberShipDAO memberShipDAO) {
		// call business method
		Account myAccount = new Account();
		accountDAO.addAccount(myAccount,true);
		accountDAO.doWork();

		memberShipDAO.addAccount();
		memberShipDAO.goToSleep();
	}


}

package lk.ijse.pointcutdeclaration;

import lk.ijse.pointcutdeclaration.dao.AccountDAO;
import lk.ijse.pointcutdeclaration.dao.MemberShipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PointCutDeclarationApplication {

    public static void main(String[] args) {
        SpringApplication.run(PointCutDeclarationApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MemberShipDAO memberShipDAO) {
        return runner -> {
            demoBeforeAdvice(accountDAO,memberShipDAO);
        };
    }
    private void demoBeforeAdvice(AccountDAO accountDAO,MemberShipDAO memberShipDAO) {
        // call business method
        Account myAccount = new Account();
        accountDAO.addAccount(myAccount,true);
        accountDAO.doWork();

        //call account getter/setter methods
        accountDAO.setName("myAccount");
        accountDAO.setServiceCode("myServiceCode");

        String name = accountDAO.getName();
        String serviceCode = accountDAO.getServiceCode();


        memberShipDAO.addAccount();
        memberShipDAO.goToSleep();
    }

}

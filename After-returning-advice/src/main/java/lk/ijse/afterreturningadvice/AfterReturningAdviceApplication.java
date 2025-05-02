package lk.ijse.afterreturningadvice;

import lk.ijse.afterreturningadvice.dao.AccountDAO;
import lk.ijse.afterreturningadvice.dao.MemberShipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AfterReturningAdviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AfterReturningAdviceApplication.class, args);
    }
    @Bean
    public CommandLineRunner init(AccountDAO accountDAO, MemberShipDAO memberShipDAO) {
        return runner -> {
            findAccount(accountDAO);
        };
    }

    private void findAccount(AccountDAO accountDAO) {
        List<Account> account = accountDAO.findAccount();

        System.out.println("\n\n Main programme demoTheAfterReturningAdvice");
            System.out.println(account);


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

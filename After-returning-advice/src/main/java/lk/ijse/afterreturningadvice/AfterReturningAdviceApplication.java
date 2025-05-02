package lk.ijse.afterreturningadvice;

import lk.ijse.afterreturningadvice.dao.AccountDAO;
import lk.ijse.afterreturningadvice.dao.MemberShipDAO;
import lk.ijse.afterreturningadvice.service.TrafficFortuneService;
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
    public CommandLineRunner init(AccountDAO accountDAO, MemberShipDAO memberShipDAO, TrafficFortuneService trafficFortuneService) {
        return runner -> {
            //findAccount(accountDAO);
            //demoAfterThrowingAdvice(accountDAO);

            //demoAfterAdvice(accountDAO);

            //demoAroundAdvice(trafficFortuneService);

            //demoAroundAdviceHnadleexception(trafficFortuneService);

            //demoAroundRethrowException(trafficFortuneService);
        };
    }

    private void demoAroundRethrowException(TrafficFortuneService trafficFortuneService) {
        System.out.println("-----main programme demo advice re throw exception----");
        System.out.println("calling fortune ()");

        boolean triWire=true;
        String fortune = trafficFortuneService.getFortune(triWire);


        System.out.println(fortune);
    }

    private void demoAroundAdviceHnadleexception(TrafficFortuneService trafficFortuneService) {
        System.out.println("main programme demo advice handle exception");
        System.out.println("calling fortune ()");

        boolean triWire=true;
        String fortune = trafficFortuneService.getFortune(triWire);


        System.out.println(fortune);
    }

    private void demoAroundAdvice(TrafficFortuneService trafficFortuneService) {

        System.out.println("main programme demo advice");
        System.out.println("calling fortune ()");
        String fortune = trafficFortuneService.getFortune();
        System.out.println(fortune);
        System.out.println("finished fortune ()");
    }

    private void demoAfterAdvice(AccountDAO accountDAO) {
        List<Account> account = null;


        try{
            boolean tripWire=true;
            account = accountDAO.findAccount(tripWire);

        }catch (Exception e){
            System.out.println("\n\n Main programme demoTheAfterReturningAdvice failed"+e.getMessage());
        }
    }

    private void demoAfterThrowingAdvice(AccountDAO accountDAO) {
        List<Account> account = null;


        try{
            boolean tripWire=true;
            account = accountDAO.findAccount(tripWire);

        }catch (Exception e){
            System.out.println("\n\n Main programme demoTheAfterReturningAdvice failed"+e.getMessage());
        }

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

package lk.ijse.afterreturningadvice.dao;




import lk.ijse.afterreturningadvice.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {
    private String name;
    private String serviceCode;


    @Override
    public List<Account> findAccount() {
        List<Account> myAccounts = new ArrayList<>();
        Account account1 = new Account("john","silver");
        Account account2 = new Account("paul","platinum");
        Account account3 = new Account("luca","gold");

        myAccounts.add(account1);
        myAccounts.add(account2);
        myAccounts.add(account3);

        return myAccounts;
    }

    @Override
    public void addAccount() {
        System.out.println(getClass()+" : Account DAO adding account ....");
    }

    @Override
    public void addAccount(Account account) {
        System.out.println(getClass()+" : Account DAO adding account with account class (one param) ....");
    }

    @Override
    public void addAccount(Account account, Boolean vipFlag) {
        System.out.println(getClass()+" : Account DAO adding account with account class and vip flag (two param) ....");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass()+" : Account DAO doWork() ....");
        return false;
    }



    public String getName() {
        System.out.println(getClass()+" : Account DAO getName()....");
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+" : Account DAO getServiceCode() ....");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

}

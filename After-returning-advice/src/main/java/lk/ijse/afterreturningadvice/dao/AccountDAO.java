package lk.ijse.afterreturningadvice.dao;


import lk.ijse.afterreturningadvice.Account;

import java.util.List;

public interface AccountDAO {

    List<Account> findAccount();
    void addAccount();
    void addAccount(Account account);
    void addAccount(Account account,Boolean vipFlag);

    boolean doWork();
     String getName();
     void setName(String name);

    String getServiceCode();

    void setServiceCode(String serviceCode);

    List<Account> findAccount(boolean tripWire);

}

package lk.ijse.pointcutdeclaration.dao;


import lk.ijse.pointcutdeclaration.Account;

public interface AccountDAO {
    void addAccount();
    void addAccount(Account account);
    void addAccount(Account account,Boolean vipFlag);

    boolean doWork();
     String getName();
     void setName(String name);

    String getServiceCode();

    void setServiceCode(String serviceCode);

}

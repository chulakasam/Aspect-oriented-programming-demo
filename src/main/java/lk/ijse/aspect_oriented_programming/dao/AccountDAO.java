package lk.ijse.aspect_oriented_programming.dao;

import lk.ijse.aspect_oriented_programming.Account;

public interface AccountDAO {
    void addAccount();
    void addAccount(Account account);
    void addAccount(Account account,Boolean vipFlag);

    boolean doWork();
}

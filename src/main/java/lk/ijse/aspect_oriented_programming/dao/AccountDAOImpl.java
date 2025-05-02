package lk.ijse.aspect_oriented_programming.dao;


import lk.ijse.aspect_oriented_programming.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements  AccountDAO {
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
}

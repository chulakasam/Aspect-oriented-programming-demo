package lk.ijse.pointcutdeclaration.dao;



import lk.ijse.pointcutdeclaration.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
    private String name;
    private String serviceCode;


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

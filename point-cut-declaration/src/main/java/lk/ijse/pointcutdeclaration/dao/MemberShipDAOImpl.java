package lk.ijse.pointcutdeclaration.dao;


import org.springframework.stereotype.Repository;

@Repository
public class MemberShipDAOImpl implements MemberShipDAO {
    @Override
    public boolean addAccount() {
        System.out.println(getClass()+" :  hey ! I' m the member ship! DAO");

        return true;
    }

    @Override
    public void goToSleep() {

        System.out.println(getClass()+" :  hey ! I' m going to sleep! ");
    }
}

package lk.ijse.pointcutdeclaration.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {

    //advice for logging

    //start with before advice
                          //here is the point cut expression
    //@Before("execution(public void addAccount())") ---> this is accountDAO addAccount()

    //@Before("execution(public void updateAccount())") ----> we haven't update account so,not run this point cut expression.only run actual method ....

    //@Before("execution(public void addAccount())")

    //@Before("execution(public void lk.ijse.aspect_oriented_programming.dao.AccountDAO.addAccount())") //---->this  only match with AccountDAO addAccount()

    //@Before("execution(public void add*())") // ----->  add advices starting with any add methods .so here run membership addAccount and addAccount

    //@Before("execution(void add*())")  //----------------> match adviser starting with add and return type void method ...

    //@Before("execution(* add*())") //-------> match advice starting with any add and any return type methods ....

    //@Before("execution(* add*(lk.ijse.aspect_oriented_programming.Account))") //--------> match advice with any return type,starting with add any method ,one param

    //@Before("execution(* add*(lk.ijse.aspect_oriented_programming.Account,..))") //--->match advice with any return type,starting with add any method and any number of arguments

    //@Before("execution(* add* (..))") // ---------> advice match with any no of any arguments

    @Before("execution(* lk.ijse.aspect_oriented_programming.dao.*.* (..))")  //----->given package any class and method any argument count
    public void beforeAddAccountAdvice(){
        System.out.println(getClass()+" : I 'm the before adviser ....");
    }
}

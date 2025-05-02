package lk.ijse.pointcutdeclaration.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {

    //01.  create point cut declaration
   @Pointcut("execution(* lk.ijse.pointcutdeclaration.dao.*.*(..))")
   private void forDAOPackage(){}

    //02.  apply pointcut declaration to advice
    @Before("forDAOPackage()")
    public void beforeAddAccountAdvice(){
        System.out.println(getClass()+" : I 'm the before adviser ....");
    }

    @Before("forDAOPackage()")
    public void performAnalytics(){
        System.out.println("===========> perform api analytics ....");
    }

}

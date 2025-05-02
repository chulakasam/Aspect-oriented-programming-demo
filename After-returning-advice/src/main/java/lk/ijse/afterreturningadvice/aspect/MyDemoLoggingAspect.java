package lk.ijse.afterreturningadvice.aspect;
import lk.ijse.afterreturningadvice.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
    //add a new advice for @AfterReturning
    @AfterReturning(
                    pointcut = "execution(* lk.ijse.afterreturningadvice.dao.AccountDAO.findAccount(..))",
                    returning = "result"
            )

    public void afterReturning(JoinPoint joinPoint, List<Account> result) {
        //print advising methods
        String method = joinPoint.getSignature().toShortString();
        System.out.println("executing methods :"+method);
        System.out.println("results are :"+result);

    }



    //02.  apply pointcut declaration to advice
    @Before("lk.ijse.afterreturningadvice.aspect.PointDeclaration.forDAOPackageExcludeGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint  joinPoint) {
        System.out.println(getClass()+" : I 'm the before adviser ....");

        //display method signature
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method Signature : "+signature);

        //display method arguments
        Object[] args = joinPoint.getArgs();

        //loop args
        for (Object arg : args) {
            System.out.println("args are :"+arg);
            if (arg instanceof Account) {
                //downcast and print account specific stuff
                Account account = (Account) arg;
                System.out.println("account name :"+account.getName());
                System.out.println("account level :"+account.getLevel());

            }
        }


    }




    //exclude with getter and setter
    /*@Before("forDAOPackageExcludeGetterSetter()")
    public void combinedPointCut(){
        System.out.println("===========> combined pointcut ....");
    }

     */

    // apita advice walata order ekak denna @Order use kranwa. ita klin apit aspect wena wenama class walata gann ona.


}

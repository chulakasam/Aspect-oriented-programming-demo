package lk.ijse.pointcutdeclaration.aspect;

import lk.ijse.pointcutdeclaration.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {




    //02.  apply pointcut declaration to advice
    @Before("lk.ijse.pointcutdeclaration.aspect.PointDeclaration.forDAOPackageExcludeGetterSetter()")
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

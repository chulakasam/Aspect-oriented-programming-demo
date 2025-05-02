package lk.ijse.afterreturningadvice.aspect;
import lk.ijse.afterreturningadvice.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {









    //add around advice
    @Around("execution(* lk.ijse.afterreturningadvice.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
                //print method advicing
        String shortString = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("aroundGetFortune()"+shortString);
        //get begin timestamp
        //long begin = System.currentTimeMillis();
        long begin=System.nanoTime();

        //execute method
        Object result = null;
        try{
            result=proceedingJoinPoint.proceed();
        }catch (Exception e){


            System.out.println("aroundGetFortune()"+e.getMessage());
           // System.out.println("major accident ! but no worries");
            //rethrow exception
            throw e;

        }


        //getend timestamp
        long end = System.currentTimeMillis();
        //compute duration
        long time = end - begin;
        System.out.println("aroundGetFortune duration ()"+time/1000.0+" seconds");
        return result;
    }





    //add after final advice
    @After("execution(* lk.ijse.afterreturningadvice.dao.AccountDAO.findAccount(..))")
    public void afterFinally(JoinPoint joinPoint) {
        System.out.println("===========> after Finally ...."+joinPoint.getSignature().getName());

    }







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

        //let's modify data
        System.out.println("modifying data ------");
        List<Account> result1 = convertAccountNameUpperCase(result);
        System.out.println("Upper names are :"+result1);


    }



    @AfterThrowing(
            pointcut ="execution(* lk.ijse.afterreturningadvice.dao.AccountDAO.findAccount(..))" ,
            throwing = "theExc"
    )
    public void afterThrowing(JoinPoint joinPoint, Throwable theExc) {
        //print method advising
        System.out.println("executing @AfterThrowing methods :"+joinPoint.getSignature().toShortString());
        // log exception
        System.out.println("the exception  :"+theExc);

    }











    private List<Account> convertAccountNameUpperCase(List<Account> result) {
        for (Account account : result) {
            String upperCase = account.getName().toUpperCase();
            account.setName(upperCase);
        }
        return result;
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

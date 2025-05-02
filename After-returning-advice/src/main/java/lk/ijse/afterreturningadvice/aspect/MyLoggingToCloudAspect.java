package lk.ijse.afterreturningadvice.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyLoggingToCloudAspect {
    @Before("lk.ijse.afterreturningadvice.aspect.PointDeclaration.PointDeclaration.forDAOPackageExcludeGetterSetter()")
    public void LogToCloudAdvice(){
        System.out.println("===========> combined pointcut ....");
    }
}

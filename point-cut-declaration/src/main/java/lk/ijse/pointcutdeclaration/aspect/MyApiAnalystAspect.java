package lk.ijse.pointcutdeclaration.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalystAspect {
    // reuse pointcut declaration
    @Before("lk.ijse.pointcutdeclaration.aspect.PointDeclaration.forDAOPackageExcludeGetterSetter()")
    public void performAnalytics(){
        System.out.println("===========> perform api analytics ....");
    }
}

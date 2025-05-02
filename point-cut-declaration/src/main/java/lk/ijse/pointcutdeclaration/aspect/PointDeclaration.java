package lk.ijse.pointcutdeclaration.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PointDeclaration {
    //01.  create point cut declaration
    @Pointcut("execution(* lk.ijse.pointcutdeclaration.dao.*.*(..))")
    public void forDAOPackage(){}

    // create point cut for getter setter
    @Pointcut("execution(* lk.ijse.pointcutdeclaration.dao.*.get*(..))")
    public void getter(){}


    @Pointcut("execution(* lk.ijse.pointcutdeclaration.dao.*.set*(..))")
    public void setter(){}

    // create point cut include package and exclude getter/setter
    @Pointcut("forDAOPackage()&& !(getter()||setter())")
    public void forDAOPackageExcludeGetterSetter(){}


}

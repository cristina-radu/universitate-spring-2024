package org.example.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Executable;

@Aspect
@Component
public class MyAspect {

    @Pointcut(value = "execution(public void getAllStudents())")
    public void getAllStudents(){}

    @Pointcut(value = "execution(* org.example.aop.service.TeacherService.*(..))")
    public void getAllMethodsTeacherService(){}

    @Pointcut(value = "execution(* org.example.aop.service.StudentService.*(..))")
    public void getAllMethodsStudentServicePointcut(){}

    @Pointcut(value = "execution(public String getTeacherName())")
    public void getTeacherNamePointcut(){}

    @Before(value = "getAllStudents()")
    public void beforeGetAllStudents(){
        System.out.println("Hello before method getAllStudents.");
    }

    @After(value = "getAllMethodsTeacherService()")
    public void afterAllMethods(){
        System.out.println("Hello after all Teacher Service method calls");
    }

    @AfterReturning(value = "getTeacherNamePointcut()", returning = "returnValue")
    public void afterReturningGetTeacherName(JoinPoint joinPoint, String returnValue) {
        System.out.println("The value returned by method "+ joinPoint.toString() +" is "+ returnValue);
    }

    @AfterThrowing(value = "getAllMethodsStudentServicePointcut()", throwing = "exception")
    public void afterThrowingException(JoinPoint joinPoint, Exception exception) {
        System.out.println(" An exception was throwing from method "+ joinPoint.toString() +
                " with exception message "+ exception.getMessage());
    }

}

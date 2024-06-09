package br.com.giulianabezerra.aspects_java_springaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

  @Before("execution(* br.com.giulianabezerra.aspects_java_springaop.dummy.*.*(..))")
  public void logBefore(JoinPoint joinPoint) {
    System.out.println("Before: " + joinPoint.getSignature());
  }

  @Around("execution(* br.com.giulianabezerra.aspects_java_springaop.dummy.*.*(..))")
  public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
    System.out.println("Around Before: " + joinPoint.getSignature());

    Object object = joinPoint.proceed();

    System.out.println("Around After: " + joinPoint.getSignature());

    return object;
  }
}

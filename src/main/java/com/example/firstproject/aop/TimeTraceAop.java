package com.example.firstproject.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

    //AOP 적용전에는 Controller -> 실제 MemberService -> 실제 MemberRepository
    //AOP 적용후에는 프록시Controller -> Controller -> 프록시 MemberService -> 실제 MemberService .....
    @Around("execution(* com.example.firstproject..*(..))")  //적용 대상 설정
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START : " +joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END : " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}

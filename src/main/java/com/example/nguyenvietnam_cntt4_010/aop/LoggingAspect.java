package com.example.nguyenvietnam_cntt4_010.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.example.nguyenvietnam_cntt4_010.service.PostService.createPost(..)) || " +
              "execution(* com.example.nguyenvietnam_cntt4_010.service.PostService.updatePost(..)) || " +
              "execution(* com.example.nguyenvietnam_cntt4_010.service.PostService.partialUpdatePost(..))")
    public void postServiceMethods() {}

    @Before("postServiceMethods()")
    public void logMethodCall(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Tên phương thức: " + methodName + " đã được gọi.");
    }
}

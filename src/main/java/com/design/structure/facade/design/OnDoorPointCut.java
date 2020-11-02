package com.design.structure.facade.design;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author wangyuj
 * @date 2020/11/2
 **/
@Aspect
@Component
public class OnDoorPointCut {


    @Pointcut(value = "@annotation(com.design.structure.facade.design.OnDoor)")
    public void onDoorPointCut() {

    }

    @Around("onDoorPointCut()")
    public void onDoorAround(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取类
        Class<?> aClass = joinPoint.getTarget().getClass();
        //获取方法签名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取方法
        Method method = aClass.getMethod(signature.getName(), signature.getParameterTypes());
        //获取方法上的@Ondoor注解
        OnDoor annotation = method.getAnnotation(OnDoor.class);
        String key = annotation.key();
        String returnJson = annotation.returnJson();

        Object proceed = joinPoint.proceed();
    }
}

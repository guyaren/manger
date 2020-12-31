package com.cxcs.manger.aop;

import com.cxcs.manger.vo.CommonException;
import com.cxcs.manger.vo.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;

@Slf4j
@Aspect
@Configuration
public class AspectConfig {
    @Pointcut("execution(public * com.cxcs.manger.controller.*.*(..))")
    public void webLog(){}

    @Around("webLog()")
    public Object calTime(ProceedingJoinPoint proceedingJoinPoint){
        long start = System.currentTimeMillis();
        //获取request
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        String orderId = String.valueOf(System.currentTimeMillis());
        request.setAttribute("orderId",orderId);
        try {
            CommonResponse obj = (CommonResponse) proceedingJoinPoint.proceed();
            obj.setOrderId(orderId);
            return obj;
        }catch (Throwable throwable) {
            log.error(throwable.getMessage());
            if(throwable instanceof CommonException){
                return CommonResponse.buildFailed(throwable.getMessage());
            }else{
                return CommonResponse.buildFailed("unknown error");
            }
        }finally {
            log.info("[{}] {} [time] : {}ms",orderId,request.getRequestURL(),System.currentTimeMillis()-start);
        }

    }

}

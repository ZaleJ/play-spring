//package com.jzl.play.common;
//
//import com.alibaba.fastjson.JSON;
//import com.jzl.play.model.User;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
//import org.springframework.data.redis.core.ReactiveRedisOperations;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author ：jizhaolun
// * @date ：Created in 2019/8/16 16:23
// * @description：
// * @modified By：
// * @version: $
// */
//@Component
//@Aspect
//public class Redis {
//    @Autowired
//    private RedisTemplate<Object, Object> redisTemplate;
//
//    @Pointcut("execution(* com.jzl.play.controller.UserController.*(..))")
////    @Pointcut("@annotation(org.springframework.web.bind.annotation.RestController)")
//    public void aaa() {
//    }
//
//    @Pointcut("@annotation(org.springframework.cache.annotation.Cacheable)")
//    public void aaa1() {
//    }
//    ;
//
//    @Around(value = "aaa()")
//    public Object set(ProceedingJoinPoint pjp) {
//
//        Object result = null;
//
//        Object[] args = pjp.getArgs();
//
//
//        //  before，从redis拿
//        Object value = before(pjp);
//        if (value != null) {
//            result = value;
//        }
//        // redis 没有对应数据
//        else {
//            try {
//                // 自定义逻辑
//                result = pjp.proceed(pjp.getArgs());
//                // after
//                after(pjp, result);
//            } catch (Throwable throwable) {
//                // afterThrowing，删除key
//                throwable.printStackTrace();
//            }
//        }
//        // AfterReturning
//        afterReturning(pjp, result);
//
//        // 入参 pjp
//        // 返回值  result
//        return result;
//    }
//
////     使用redisTemplate 操作redis
//
//    // spring-cache:redis、memoryCache....
//
//    /**
//     * 从redis拿
//     *
//     * @param pjp
//     * @return
//     */
//    private Object before(ProceedingJoinPoint pjp) {
//        String redisKey = getKey(pjp);
//        return redisTemplate.opsForValue().get(redisKey);
//    }
//
//    /**
//     * 填充到redis
//     *
//     * @param pjp
//     * @param result
//     */
//    private void after(ProceedingJoinPoint pjp, Object result) {
//        if (result == null) {
//            return;
//        }
//        String key = getKey(pjp);
//        redisTemplate.opsForValue().set(key, result, 10, TimeUnit.MINUTES);
//    }
//
//    /**
//     * 续命10分钟
//     * @param pjp
//     * @param result
//     */
//    private void afterReturning(ProceedingJoinPoint pjp, Object result) {
//        after(pjp, result);
//    }
//
//    private String getKey(ProceedingJoinPoint pjp) {
//        Object[] args = pjp.getArgs();
//        return JSON.toJSONString(args);
//    }
//
//}

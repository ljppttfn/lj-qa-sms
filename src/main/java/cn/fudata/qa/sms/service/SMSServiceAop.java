//package cn.fudata.qa.sms.service;
//
//import com.alibaba.fastjson.JSONObject;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import springfox.documentation.service.ResponseMessage;
//
//import java.util.Arrays;
//
///**
// * @author youlong
// * date 2019/5/5
// */
//@Aspect
//@Component
//public class SMSServiceAop {
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    /**
//     * execution是一种使用频率比较高比较主要的一种切点指示符，用来匹配方法签名，方法签名使用全限定名，
//     * 包括访问修饰符（public/private/protected）、返回类型，包名、类名、方法名、参数，其中返回类型，包名，类名，方法，参数是必须的
//     * From: https://blog.51cto.com/5914679/2092253
//     */
//    @Pointcut("execution(public * cn.fudata.qa.sms.service.SMSService.get_sms_all(..))")
//    public void point(){}
//
//    @Before("point()")
//    public void beforeAop(JoinPoint joinPoint){
//        System.out.println(">>>> Before Aop");
////        System.out.println(joinPoint.getArgs().length);
////        System.out.println(Arrays.toString(joinPoint.getArgs()));
////        System.out.println(joinPoint.getTarget().getClass());
////        System.out.println(joinPoint.getThis().getClass());
////        System.out.println(joinPoint.getSignature().getDeclaringType().getSimpleName());
////        System.out.println(joinPoint.getSignature().getName());
////        System.out.println(joinPoint.getSignature().getDeclaringTypeName());
////        System.out.println(joinPoint.getSignature().getModifiers());
//    }
//
//    @Around("point()")
//    public Object aroundAop(ProceedingJoinPoint pjd){
//        Object result = null;
//
//        try {
//            System.out.println(">>>Around AOP 目标方法执行前");
////            result = pjd.proceed(new Object[]{"test"});
//            result = pjd.proceed();
//            System.out.println(">>>Around AOP ret: " + result);
//            System.out.println(">>>Around AOP 目标方法执行返回结果后");
//        } catch (Throwable throwable) {
//            System.out.println(">>>Around AOP 目标方法执行异常后");
//            throwable.printStackTrace();
//        }
//        System.out.println(">>>Around AOP 目标方法执行返回后");
//        return result;
//    }
//
//    @After(value = "point()")
//    public void afterAOP(){
//        System.out.println("after AOP ret : ");
//
//    }
//
//    @AfterReturning(pointcut = "point()", returning = "ret")
//    public void afterRerurnAOP(JoinPoint jp, Object ret){
//        System.out.println("afterRerurn AOP ret: " + ret);
//    }
//
//    @AfterThrowing("point()")
//    public void afterThrowingAOP(){
//        System.out.println("afterThrowing AOP");
//    }
//}

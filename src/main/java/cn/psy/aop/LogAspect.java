package cn.psy.aop;

import cn.psy.service.LoginService;
import cn.psy.service.UserService;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Aspect
public class LogAspect {
    static Logger log = Logger.getLogger(LogAspect.class.getClass());


//    @Autowired
//    LoginService loginService;
    /**
     * 用户
     */
    //添加用户
    @Pointcut("execution(* cn.psy.service.LoginService.insertUser(..))")
    public void insertUser() {


    }

    /**
     * 添加业务逻辑方法切入点
     */
    @Pointcut("execution(* cn.psy.service.*.save(..))")
    public void insertCell() {
    }
//

    /**
     * 登录操作(后置通知)
     *
     * @param joinPoint //     * @param object
     * @throws Throwable
     */
    @Around(value = "insertUser()")
    public void insertUserLog(ProceedingJoinPoint joinPoint) throws Throwable {
        joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        joinPoint.proceed();
        args = joinPoint.getArgs();
        Date date = new Date();
        log.error(date + ":向数据库中添加了一条数据---> tel:" + args[0] + "    sendCodeTime:" + args[1] + "    count:" + args[2]);
        System.out.println("向数据库中添加了一条数据---> tel:" + args[0] + "    sendCodeTime:" + args[1] + "    count:" + args[2]);

        System.out.println(joinPoint.getArgs());

        joinPoint.proceed();

    }
}
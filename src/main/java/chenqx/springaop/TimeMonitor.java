package chenqx.springaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

/**
 * @author chenqx 2019-11-25
 * @instruction
 */
@Service
@Aspect
public class TimeMonitor {
    @Around("execution(* UserServiceImpl.sayHello(..))")
    public void monitorAround(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("method start time:" + System.currentTimeMillis());

        Object re = pjp.proceed();

        System.out.println("method end time:" + System.currentTimeMillis());
    }
}

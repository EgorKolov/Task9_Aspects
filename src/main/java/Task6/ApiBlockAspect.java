package Task6;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ApiBlockAspect {
    @Value("${timesCalled.max}")
    private int timesCalledMax;
    private int timesCalled = 0;
    
    private final Logger logger = LoggerFactory.getLogger(ApiBlockAspect.class);
    
    @Around("execution(* Task6.Application.mapApi(..))")
    public Object checkBlockStatus(ProceedingJoinPoint joinPoint) throws Throwable {
        if (timesCalled < timesCalledMax) {
    
            timesCalled++;
            logger.info("Call #" + timesCalled);
            return joinPoint.proceed();
        }
        return new ResponseEntity<>("Error 410 - Gone", HttpStatus.GONE);
    }
}

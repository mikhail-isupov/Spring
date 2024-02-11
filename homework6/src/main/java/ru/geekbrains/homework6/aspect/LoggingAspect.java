package ru.geekbrains.homework6.aspect;

import ch.qos.logback.classic.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {
    private final Logger log = (Logger) LoggerFactory.getLogger(this.getClass());
    /**
     * Pointcut that matches all repositories, services and Web REST endpoints.
     */
    @Pointcut("within(@org.springframework.stereotype.Repository *)" +
            " || within(@org.springframework.stereotype.Service *)" +
            " || within(@org.springframework.web.bind.annotation.RestController *)")
    public void springBeanPointcut() {
        // Method is empty as this is just a Pointcut, the implementations are in the advices.
    }

    /**
     * Pointcut that matches all Spring beans in the application's main packages.
     */
    @Pointcut("within(ru.geekbrains.homework6.controllers..*)"+
            " || within(ru.geekbrains.homework6.services..*)")
    public void applicationPackagePointcut() {
        // Method is empty as this is just a Pointcut, the implementations are in the advices.
    }
    /**
     * Логирование вызовов функций.
     * @param joinPoint - Joint Point
     */
    @Before("applicationPackagePointcut() && springBeanPointcut()")
    public void logBefore(JoinPoint joinPoint){
        String logString = String.format("Выполнен метод %s.%s() с аргументом(ами) = %s", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        log.debug(logString);
    }

    @AfterThrowing(pointcut = "applicationPackagePointcut() && springBeanPointcut()", throwing = "error")
    public void logAfter(JoinPoint joinPoint, Throwable error) {
        String logString = String.format("Исключение в методе %s.%s() по причине %s", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), error.getMessage());
        log.error(logString);
    }
}

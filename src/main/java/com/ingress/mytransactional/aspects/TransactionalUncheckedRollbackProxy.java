package com.ingress.mytransactional.aspects;

import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionalUncheckedRollbackProxy {


    @SneakyThrows
    @Around("@annotation(com.ingress.mytransactional.aspects.TransactionalUncheckedRollback)")
    public void myAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("Transaction started");
        try {
            proceedingJoinPoint.proceed();
        } catch (RuntimeException runtimeException) {
            System.out.println("Rollback transaction - Unchecked");
            throw runtimeException;
        } catch (Exception exception) {
            System.out.println("Commit transaction - Unchecked");
            throw exception;
        }

        System.out.println("Transaction finished");
    }
}


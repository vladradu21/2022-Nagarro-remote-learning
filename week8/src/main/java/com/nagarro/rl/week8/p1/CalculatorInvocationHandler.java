package com.nagarro.rl.week8.p1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CalculatorInvocationHandler implements InvocationHandler {

    private final Object target;
    private final Logger logger;

    public CalculatorInvocationHandler(Object target, Logger logger) {
        this.target = target;
        this.logger = logger;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            Object result = method.invoke(target, args);

            if (isLoggingEnabled(method)) {
                logger.logMethodCall(target, method, args, result);
            }
            return result;
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (cause instanceof ArithmeticException) {
                logger.logMethodCall(target, method, args, cause);
                throw cause;
            }
            throw e;
        }
    }

    private boolean isLoggingEnabled(Method method) {
        boolean enabled = target.getClass().isAnnotationPresent(Logged.class)
                || method.isAnnotationPresent(Logged.class);
        return enabled;
    }
}
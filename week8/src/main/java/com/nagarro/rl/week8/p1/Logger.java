package com.nagarro.rl.week8.p1;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Logger {

    private final boolean logMethodCalls;

    public Logger(boolean logMethodCalls) {
        this.logMethodCalls = logMethodCalls;
    }

    public void logMethodCall(Object obj, Method method, Object[] args, Object result) {
        if(logMethodCalls) {
            StringBuilder messageBuilder = new StringBuilder();
            messageBuilder.append("Method call: ")
                    .append(obj.getClass().getSimpleName())
                    .append(".")
                    .append(method.getName())
                    .append("(")
                    .append(Arrays.toString(args))
                    .append(") = ")
                    .append(result);

            System.out.println(messageBuilder);
        }
    }
}

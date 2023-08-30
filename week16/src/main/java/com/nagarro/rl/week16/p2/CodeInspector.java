package com.nagarro.rl.week16.p2;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CodeInspector {

    public static List<CodeInspectionResult> inspectCode(String className) throws ClassNotFoundException {
        try {
            Class<?> clazz = Class.forName(className);

            List<CodeInspectionResult> resultsCodeInspection = new ArrayList<>();
            resultsCodeInspection.addAll(inspectFields(clazz));
            resultsCodeInspection.addAll(inspectMethods(clazz));

            if (clazz.getSuperclass() != null && clazz.getSuperclass() != Object.class) {
                resultsCodeInspection.addAll(inspectCode(clazz.getSuperclass().getName()));
            }

            return resultsCodeInspection;
        } catch (Exception e) {
            throw new ClassNotFoundException("Class not found");
        }
    }

    private static List<CodeInspectionResult> inspectFields(Class<?> clazz) {
        return Arrays.stream(clazz.getDeclaredFields())
                .map(field -> {
                    if(Modifier.isPrivate(field.getModifiers()) && Character.isLowerCase(field.getName().charAt(0))) {
                        return CodeInspectionResult.PRIVATE_LOWERCASE_FIELD;
                    } else {
                        return CodeInspectionResult.NON_PRIVATE_FIELD_OR_NON_LOWERCASE_FIELD;
                    }
                })
                .collect(Collectors.toList());
    }

    private static List<CodeInspectionResult> inspectMethods(Class<?> clazz) {
        return Arrays.stream(clazz.getDeclaredMethods())
                .map(method -> {
                    if(Modifier.isPublic(method.getModifiers()) && Character.isLowerCase(method.getName().charAt(0))) {
                        return CodeInspectionResult.PUBLIC_LOWERCASE_METHOD;
                    } else {
                        return CodeInspectionResult.NON_PUBLIC_METHOD_OR_NON_LOWERCASE_METHOD;
                    }
                })
                .collect(Collectors.toList());
    }
}

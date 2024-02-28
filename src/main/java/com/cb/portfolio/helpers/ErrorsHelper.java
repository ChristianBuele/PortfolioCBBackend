package com.cb.portfolio.helpers;

import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

public class ErrorsHelper {
    public static Map<String,Object> getErrors(BindingResult result){
        Map<String,Object> errors = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), err.getDefaultMessage());
        });
        return errors;
    }
    public static String getErrorsString(BindingResult result){
       StringBuilder errors = new StringBuilder();
        result.getFieldErrors().forEach(err -> {
            errors.append(err.getDefaultMessage()).append(". ");
        });
        return errors.toString();
    }
}

package com.minutowka.io6.Exceptions;

import org.springframework.web.context.annotation.ApplicationScope;

@ApplicationScope
public class CustomExceptionBuilder {
    public static CustomException getCustomException(String cause){
        return new CustomException(cause);
    }
}

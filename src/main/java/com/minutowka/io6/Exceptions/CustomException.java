package com.minutowka.io6.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CustomException extends ResponseStatusException {
    public CustomException(HttpStatus status, String cause){
        super(status, cause);
    }
}

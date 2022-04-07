package com.daltonkyemiller.daltonkyemillerapi.exception;

import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.mongodb.MongoWriteException;
import lombok.NonNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@ControllerAdvice
public class ApiExceptionResolver extends ResponseEntityExceptionHandler {


    /**
     * Handles MongoWriteException
     * @param ex The Exception
     * @return ResponseEntity for client
     */
    @ExceptionHandler(value = {MongoWriteException.class})
    protected ResponseEntity<Object> handleWriteException(MongoWriteException ex){
        ApiError error = new ApiError("Unable to write to database", ex.getError().getMessage());

        return new ResponseEntity<>(error.toMap(), HttpStatus.NOT_ACCEPTABLE);
    }

    @Override
    protected @NonNull ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                           HttpHeaders headers,
                                                                           HttpStatus status,
                                                                           WebRequest request) {
        return new ResponseEntity<>(ex.getFieldError(), status);
    }
}

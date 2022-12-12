package com.bvn.bvnvalidationservice.controller;

import com.bvn.bvnvalidationservice.exception.EmptyBVNException;
import com.bvn.bvnvalidationservice.exception.InvalidBVNDataTypeException;
import com.bvn.bvnvalidationservice.exception.InvalidBVNException;
import com.bvn.bvnvalidationservice.exception.InvalidBVNLengthException;
import com.bvn.bvnvalidationservice.response.BVNErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import static org.springframework.http.HttpStatus.BAD_REQUEST;


@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmptyBVNException.class)
    public ResponseEntity<?> emptyBVNException(EmptyBVNException exception) {

        BVNErrorResponse exceptionResponse = BVNErrorResponse.builder().message(exception.getMessage()).code(exception.getCode()).build();

        return ResponseEntity.status(BAD_REQUEST).body(exceptionResponse);
    }


    @ExceptionHandler(InvalidBVNDataTypeException.class)
    public ResponseEntity<?> invalidBVNDataTypeException(InvalidBVNDataTypeException exception) {

        BVNErrorResponse exceptionResponse = BVNErrorResponse.builder().message(exception.getMessage())
                .code(exception.getCode()).bvn(exception.getBvn()).build();

        return ResponseEntity.status(BAD_REQUEST).body(exceptionResponse);
    }


    @ExceptionHandler(InvalidBVNException.class)
    public ResponseEntity<?> invalidBVNException(InvalidBVNException exception) {

        BVNErrorResponse exceptionResponse = BVNErrorResponse.builder().message(exception.getMessage())
                .code(exception.getCode()).bvn(exception.getBvn()).build();

        return ResponseEntity.status(BAD_REQUEST).body(exceptionResponse);
    }


    @ExceptionHandler(InvalidBVNLengthException.class)
    public ResponseEntity<?> invalidBVNLengthException(InvalidBVNLengthException exception) {

        BVNErrorResponse exceptionResponse = BVNErrorResponse.builder().message(exception.getMessage())
                .code(exception.getCode()).bvn(exception.getBvn()).build();

        return ResponseEntity.status(BAD_REQUEST).body(exceptionResponse);
    }

}

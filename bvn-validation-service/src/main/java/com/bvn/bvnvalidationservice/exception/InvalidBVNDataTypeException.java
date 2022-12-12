package com.bvn.bvnvalidationservice.exception;

import lombok.Data;

@Data
public class InvalidBVNDataTypeException extends RuntimeException {

    private String code = "400";

    private String bvn;

    public InvalidBVNDataTypeException(String message, String bvn) {
        super(message);
        this.bvn = bvn;
    }

}

package com.bvn.bvnvalidationservice.exception;

import lombok.Data;

@Data
public class InvalidBVNLengthException extends RuntimeException {

    private String code = "02";

    private String bvn;

    public InvalidBVNLengthException(String message, String bvn) {
        super(message);
        this.bvn = bvn;
    }

}

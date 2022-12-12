package com.bvn.bvnvalidationservice.exception;

import lombok.Data;

@Data
public class InvalidBVNException extends RuntimeException {

    private String code = "01";

    private String bvn;

    public InvalidBVNException(String message, String bvn) {
        super(message);
        this.bvn = bvn;
    }

}

package com.bvn.bvnvalidationservice.exception;

import lombok.Data;

@Data
public class EmptyBVNException extends RuntimeException {

    private String code = "400";

    private String bvn;

    public EmptyBVNException(String message, String bvn) {
        super(message);
        this.bvn = bvn;
    }
}

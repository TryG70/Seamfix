package com.bvn.bvnvalidationservice.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BVNErrorResponse {

    private String message;


    private String code;

    private String bvn;

}

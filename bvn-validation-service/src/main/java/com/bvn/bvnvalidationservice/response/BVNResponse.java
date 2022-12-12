package com.bvn.bvnvalidationservice.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class BVNResponse {

    private String message;

    private String code;

    private String bvn;

    private String imageDetail;

    private String basicDetail;

}
